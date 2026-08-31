#include <bits/stdc++.h>
long long int min2(long long int a, long long int b) { return a > b ? a : b; }
long long int max2(long long int a, long long int b) { return a < b ? a : b; }
class node {
 public:
  int left, right;
  long long int num, min;
  bool isMinLeft;
  bool willPropagate;
  node *leftchild, *rightchild, *parent;
  node(int left, int right, node *parent) {
    this->left = left;
    this->right = right;
    this->min = this->num = 0;
    this->isMinLeft = false;
    this->parent = parent;
    this->willPropagate = false;
    if (left == right) {
      this->leftchild = NULL;
      this->rightchild = NULL;
    } else {
      int mid = (this->left + this->right) / 2;
      this->leftchild = new node(this->left, mid, this);
      this->rightchild = new node(mid + 1, this->right, this);
    }
  }
  bool isLeaf() { return this->leftchild == NULL && this->rightchild == NULL; }
  bool isIn(int index) { return (this->left <= index && index <= this->right); }
  int updateDirection(int lbound, int rbound) {
    if (this->left == lbound && this->right == rbound)
      return 0;
    else if (this->isLeaf() || lbound > rbound)
      return -1;
    else if (this->leftchild->isIn(lbound) && this->leftchild->isIn(rbound))
      return 1;
    else if (this->rightchild->isIn(lbound) && this->rightchild->isIn(rbound))
      return 2;
    else if (this->leftchild->isIn(lbound) && this->rightchild->isIn(rbound))
      return 3;
    else
      return -1;
  }
  long long int parent_num_sum() {
    node *ancestor = this;
    long long int ans = 0;
    while (ancestor != NULL) {
      ans += ancestor->num;
      ancestor = ancestor->parent;
    }
    return ans;
  }
  void singleUpdate() {
    if (this->isLeaf()) {
      this->min = this->num;
      this->isMinLeft = true;
    } else {
      isMinLeft = true;
      isMinLeft = (this->leftchild->min < this->rightchild->min);
      this->min = num;
      if (isMinLeft)
        this->min += this->leftchild->min;
      else
        this->min += this->rightchild->min;
    }
  }
  void upperPropagation() {
    if (!this->willPropagate)
      return;
    else if (!this->isLeaf() && (this->leftchild->willPropagate ||
                                 this->rightchild->willPropagate))
      return;
    else {
      this->willPropagate = false;
      this->singleUpdate();
      if (this->parent != NULL) this->parent->upperPropagation();
    }
  }
  void update(long long int val, int lbound, int rbound) {
    int dir = this->updateDirection(lbound, rbound);
    if (dir == -1) return;
    this->willPropagate = true;
    if (dir == 0) {
      this->num += val;
      this->upperPropagation();
    } else if (dir == 1) {
      this->leftchild->willPropagate = true;
      this->leftchild->update(val, lbound, rbound);
    } else if (dir == 2) {
      this->rightchild->willPropagate = true;
      this->rightchild->update(val, lbound, rbound);
    } else if (dir == 3) {
      this->leftchild->willPropagate = true;
      this->rightchild->willPropagate = true;
      this->leftchild->update(val, lbound, this->leftchild->right);
      this->rightchild->update(val, this->rightchild->left, rbound);
    }
  }
  long long int search(int lbound, int rbound) {
    int dir = this->updateDirection(lbound, rbound);
    if (dir == -1)
      throw "Invalid range";
    else if (dir == 0) {
      return min;
    } else if (dir == 1)
      return this->leftchild->search(lbound, rbound) + num;
    else if (dir == 2)
      return this->rightchild->search(lbound, rbound) + num;
    else if (dir == 3) {
      if (this->isMinLeft)
        return leftchild->search(lbound, leftchild->right) + num;
      else
        return rightchild->search(rightchild->left, rbound) + num;
    }
  }
  int findMinimumIndex() {
    if (this->isLeaf())
      return this->left;
    else if (this->isMinLeft)
      return leftchild->findMinimumIndex();
    else
      return rightchild->findMinimumIndex();
  }
  void print(int tabLevel) {
    for (int i = 0; i < tabLevel - 1; i++) printf("|   ");
    if (tabLevel > 0) printf("+-- ");
    printf("Node covering [%d, %d]: num %lld, min %lld, isLeft %c\n",
           this->left, this->right, this->num, this->min,
           isMinLeft ? 'L' : 'R');
    if (!this->isLeaf()) {
      this->leftchild->print(tabLevel + 1);
      this->rightchild->print(tabLevel + 1);
    }
  }
};
int main(void) {
  int n;
  scanf("%d", &n);
  std::vector<long long int> sum(n, 0);
  node *root = new node(0, n - 1, NULL);
  for (int i = 0; i < n; i++) {
    scanf("%lld", &sum[i]);
    root->update(sum[i], i, i);
  }
  std::vector<int> perm(n, -1);
  for (int num = 1; num <= n; num++) {
    int rightmost = root->findMinimumIndex();
    root->update(-num, rightmost, n - 1);
    root->update(1LL << 40, rightmost, rightmost);
    perm[rightmost] = num;
  }
  for (int i = 0; i < n; i++) printf("%d ", perm[i]);
  printf("\n");
  return 0;
}
