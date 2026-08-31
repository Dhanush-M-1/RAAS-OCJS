#include <bits/stdc++.h>
using std::min;
using std::vector;
struct indexed_tree {
  int k = 1;
  vector<long long> tree;
  indexed_tree(int n) {
    while (k < n) {
      k *= 2;
    }
    tree.resize(k * 2, 0);
    k--;
  }
  void update(int i, long long a) {
    tree[k + i] = a;
    int temp = (k + i) / 2;
    while (temp != 0) {
      tree[temp] = tree[temp * 2] + tree[temp * 2 + 1];
      temp /= 2;
    }
  }
  long long range_sum(int i, int j) {
    int left = k + i;
    int right = k + j;
    long long ret = 0;
    while (1) {
      if (left > right) {
        break;
      }
      if (left == right) {
        ret += tree[left];
        break;
      }
      if (left % 2 == 1) {
        ret += tree[left];
      }
      if (right % 2 == 0) {
        ret += tree[right];
      }
      left = (left + 1) / 2;
      right = (right - 1) / 2;
    }
    return ret;
  }
};
long long arr[200010];
int main() {
  int n, k, a, b, q;
  scanf("%d%d%d%d%d", &n, &k, &a, &b, &q);
  indexed_tree one(n), two(n);
  for (int i = 0; i < q; i++) {
    int qe;
    scanf("%d", &qe);
    if (qe == 1) {
      int d, ai;
      scanf("%d%d", &d, &ai);
      arr[d] += ai;
      one.update(d, min(arr[d], (long long)b));
      two.update(d, min(arr[d], (long long)a));
    } else if (qe == 2) {
      int p;
      scanf("%d", &p);
      long long ans = 0;
      ans = one.range_sum(1, p - 1) + two.range_sum(p + k, n);
      printf("%lld\n", ans);
    }
  }
}
