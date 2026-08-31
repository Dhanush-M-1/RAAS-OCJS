#include <bits/stdc++.h>
template <class T>
inline T gcd(T a, T b) {
  return a % b ? gcd(b, a % b) : b;
}
using namespace std;
class ppp {
 public:
  long long val;
  long long tree[4 * 200010];
  void update(int node, int low, int hi, int i, long long value) {
    if (low == hi) {
      tree[node] = min(val, tree[node] + value);
      return;
    }
    int mid = (low + hi) / 2;
    int left = 2 * node;
    int right = left + 1;
    if (i <= mid)
      update(left, low, mid, i, value);
    else
      update(right, mid + 1, hi, i, value);
    tree[node] = tree[left] + tree[right];
  }
  long long query(int node, int low, int hi, int i, int j) {
    if (i > hi || j < low) return 0;
    if (low >= i && hi <= j) return tree[node];
    int mid = (low + hi) / 2;
    int left = 2 * node;
    int right = left + 1;
    int x = query(left, low, mid, i, j);
    int y = query(right, mid + 1, hi, i, j);
    return x + y;
  }
} s1, s2;
int main() {
  int n, k, a, b, q;
  ;
  scanf("%d%d%d%d", &n, &k, &a, &b);
  ;
  ;
  scanf("%d", &q);
  ;
  s1.val = b;
  s2.val = a;
  while (q--) {
    int x;
    ;
    scanf("%d", &x);
    ;
    if (x == 1) {
      int p, q;
      ;
      scanf("%d%d", &p, &q);
      ;
      s1.update(1, 1, n, p, q);
      s2.update(1, 1, n, p, q);
    } else {
      int p;
      ;
      scanf("%d", &p);
      ;
      long long ans;
      if (p == 1)
        ans = 0;
      else
        ans = s1.query(1, 1, n, 1, p - 1);
      ans += s2.query(1, 1, n, p + k, n);
      printf("%I64d\n", ans);
    }
  }
  return 0;
}
