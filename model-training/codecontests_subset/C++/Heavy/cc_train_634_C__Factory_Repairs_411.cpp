#include <bits/stdc++.h>
using namespace std;
const int MAX_N = 200100;
int cnt[MAX_N];
int tree_a[MAX_N];
int tree_b[MAX_N];
int GetSum(int x, int tree[]) {
  int result = 0;
  for (int i = x; i >= 0; i = (i & (i + 1)) - 1) {
    result += tree[i];
  }
  return result;
}
int GetSum(int left, int right, int tree[]) {
  return GetSum(right, tree) - ((left == 0) ? 0 : GetSum(left - 1, tree));
}
void Update(int x, int delta, int tree[]) {
  for (int i = x; i < MAX_N; i = (i | (i + 1))) {
    tree[i] += delta;
  }
}
int main() {
  int n, k, a, b, q;
  scanf("%d %d %d %d %d", &n, &k, &b, &a, &q);
  for (int i = 0; i < q; ++i) {
    int type;
    scanf("%d", &type);
    if (type == 1) {
      int d, x;
      scanf("%d %d", &d, &x);
      if (cnt[d] + x <= a) {
        Update(d, x, tree_a);
      } else if (cnt[d] < a) {
        Update(d, a - cnt[d], tree_a);
      }
      if (cnt[d] + x <= b) {
        Update(d, x, tree_b);
      } else if (cnt[d] < b) {
        Update(d, b - cnt[d], tree_b);
      }
      cnt[d] += x;
    } else if (type == 2) {
      int p;
      scanf("%d", &p);
      printf("%d\n",
             GetSum(0, p - 1, tree_a) + GetSum(p + k, MAX_N - 1, tree_b));
    } else {
      throw 1;
    }
  }
  return 0;
}
