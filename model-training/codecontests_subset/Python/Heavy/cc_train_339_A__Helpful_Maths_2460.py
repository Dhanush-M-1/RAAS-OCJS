class Node:
    def __init__(self, item=None, left=None, right=None):
        self.item = item
        self.left = left
        self.right = right

class BST:
    def __init__(self):
        self.root = None

    def __len__(self):
        return self._len_aux(self.root)

    def _len_aux(self, current):
        if current is None:
            return 0
        else:
            return 1 + self._len_aux(current.left) + self._len_aux(current.right)

    def insert(self, item):
        if self.root is None:
            self.root = Node(item)
        else:
            self._insert_aux(self.root, item)

    def _insert_aux(self, current, item):
        if current is None:
            return Node(item)
        
        else:
            if item <= current.item:
                current.left = self._insert_aux(current.left, item)

            else:
                current.right = self._insert_aux(current.right, item)

        return current

    def inorder(self):
        a_list = []
        self._inorder_aux(self.root, a_list)
        return a_list

    def _inorder_aux(self, current, lst):
        if current is not None:
            self._inorder_aux(current.left, lst)
            lst.append(str(current.item))
            lst.append("+")
            self._inorder_aux(current.right, lst)

def main():
    string = input()

    bst = BST()
    for char in string:
        if char.isdigit():
            bst.insert(int(char))
    numbers = bst.inorder()
    print(''.join(numbers[:-1]))


main()



