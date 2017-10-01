package huskyhacks3.world.data;

/**
 * Created by david on 10/1/2017.
 */
public class FiniteGrid<E> {
    private static int X_CAPACITY = 15;
    private static int Y_CAPACITY = 10;
    FiniteLinkedList<FiniteLinkedList<E>> finiteGrid;
    int xCurrent = 0;
    int yCurrent = 0;

    public FiniteGrid() {
        finiteGrid = new FiniteLinkedList<FiniteLinkedList<E>>(X_CAPACITY, null);
        for (int i = 0; i < X_CAPACITY; i++) {
            finiteGrid.set(i, new FiniteLinkedList<E>(Y_CAPACITY, null));
        }
    }

    private void translateGrid(int x, int y) {
        if (x - xCurrent >= X_CAPACITY) {
            for (int i = 0; i <= xCurrent + X_CAPACITY - x; i++) {
                finiteGrid.append(new FiniteLinkedList<>(Y_CAPACITY, null));
            }
            xCurrent += xCurrent + X_CAPACITY - x + 1;
        }
        if (x < xCurrent ) {
            for (int i = 0; i < xCurrent - x; i++) {
                finiteGrid.prepend(new FiniteLinkedList<>(X_CAPACITY, null));
            }
            xCurrent = x;
        }
        if (y - yCurrent >= Y_CAPACITY) {
            for (int xIndex = 0; xIndex < X_CAPACITY; xIndex++) {
                FiniteLinkedList<E> currentList = finiteGrid.get(xIndex);
                for (int i = 0; i <= yCurrent + Y_CAPACITY - y; i++) {
                    currentList.append(null);
                }
            }
            yCurrent += yCurrent + Y_CAPACITY - y + 1;
        }
        if (y < yCurrent) {
            for (int xIndex = 0; xIndex < X_CAPACITY; xIndex++) {
                FiniteLinkedList<E> currentList = finiteGrid.get(xIndex);
                for (int i = 0; i < y - yCurrent; i++) {
                    currentList.prepend(null);
                }
            }
            yCurrent = y;
        }
    }

    public void set(E element, int x, int y) {
        translateGrid(x, y);
        finiteGrid.get(x - xCurrent).set(y - yCurrent, element);
    }

    public E get(int x, int y) {
        translateGrid(x, y);
        return finiteGrid.get(x - xCurrent).get(y - yCurrent);
    }
}
