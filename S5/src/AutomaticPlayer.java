// Cette classe représente un joueur automatique.
// Elle maintient à jour un arbre des meileurs coups.
public class AutomaticPlayer extends SimpleSpectator implements Player {

  // Noeud courant de jeu. C'est le noeud qui correspond à l'état courant du jeu.
  private Tree currentNode;

  // En plus du contrat de Spectator, cette méthode :
  // 1) Initialise l'arbre du jeu, et
  // 2) calcule les valeurs Minimax pour chaque noeud de l'arbre.
  @Override
  public void start(State state) {
    this.currentNode = new Tree(state);
    this.currentNode.computeMinimaxValues();
  }

  // En plus du contrat de Spectator, cette méthode maintient currentNode,
  // cad le noeud qui correspond à l'état courant du jeu.
  @Override
  public void play(boolean isLeftMove, State state) {
    Triplet minimaxVal = currentNode.getMinimaxValue();

    if (isLeftMove) {
      if (minimaxVal.isLeftMove())
        state = state.playLeft();
      else
        state = state.playRight();

    } else {
      if (!minimaxVal.isLeftMove())
        state = state.playRight();
      else
        state = state.playLeft();
    }

    this.currentNode = new Tree(state);
    this.currentNode.computeMinimaxValues();
  }

  // Cette méthode est appelée pour connaitre le coup de ce joueur :
  // 1) Elle renvoie vrai si ce joueur joue la barre de gauche, et
  // 2) Elle renvoie faux si ce joueur joue la barre de droite.
  @Override
  public boolean nextPlay() {
    Triplet minimaxVal = currentNode.getMinimaxValue();

    return minimaxVal.isLeftMove();
  }
}
