class LinkedListTest<T> {
    Node<T> first;
    Node<T> last;
    int size;


    private class Node<T> {
        T item;

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }

        Node<T> next;
        Node<T> prev;


        public Node(Node<T> prev, T item, Node<T> next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }


    }
//    Добавить елемент по индексу
    public void add(int i, T e){
        Node<T> element = getElement(i);

        addNewNodeForIndex(element, e);
    }

    private void addNewNodeForIndex(Node<T> element, T e) {
        Node<T> befor= element.getPrev();
        Node<T> next= element;
        Node<T> newNode = new Node<>(befor, e, next);
        befor.setNext(newNode);
        next.setPrev(newNode);
              size++;
    }

    // Добавить новый елемент в масив
    public void add(T e) {

        if (first == null) {

            addFirstNode(e);

        } else if (last == null) {

            addLastNode(e);

        } else {
             addNewNode(e);

        }
    }
// Добавление новой ячейки масива
    private void addNewNode(T e) {
        Node<T> beforeNode = last;
        Node<T> newNode = new Node<>(beforeNode, e, null);
        last = newNode;
        beforeNode.setNext(last);
        size++;


    }
//Добавление последней ячейки масива
    private void addLastNode(T e) {

        last = new Node<>(first, e, null);
        first.setNext(last);
        size++;
    }
// Добавление первой ячейки масива
    private void addFirstNode(T e) {

       first =  new Node<>(null, e, null);
        size++;
    }
// Получить содержымое ячейки масива
    public T get(int index) {
        T element = null;
        Node<T> node = getElement(index);
        element = node.item;

        return element;
    }

//    Удалить елемент маива по индексу
    public void remove(int i) {

        Node<T> element = getElement(i);
        if (element == first) {
            removeFirstElement(element);
        } else if (element == last) {
            removeLastElement(element);
        } else {
            removeElement(element);

        }


    }
//    Получить полное содержание елемента масива масива
    private Node<T> getElement(int i) {
        Node<T> element = first;

        for (int j = 0; j < size; j++) {
            if (j != i) {
                element = element.getNext();

            }else {
                break;
            }


        }
        return element;
    }
// Удалить последнюю ячейку масива
    private void removeLastElement(Node<T> element) {
        Node<T> beforeElement = element.getPrev();
        last = beforeElement;
        last.setNext(null);
        element = null;
        size--;

    }
//Удалить первую ячейку масива
    private void removeFirstElement(Node<T> element) {
        Node<T> nextElement = element.getNext();
        first = nextElement;
        first.setPrev(null);
        element = null;
        size--;
    }
// Удалить ячейку выбраную масива
    private void removeElement(Node<T> element) {
        Node<T> prevElement;
        Node<T> nextElement;
        prevElement = element.getPrev();
        nextElement = element.getNext();
        prevElement.setNext(nextElement);
        nextElement.setPrev(prevElement);
        element = null;
        size--;
    }


}


