#include <bits/stdc++.h>
using namespace std;
struct BIT {
  int bit[200005];
  void init() { memset(bit, 0, sizeof(bit)); }
  void add(int k, int x) {
    k++;
    while (k < 200005) {
      bit[k] += x;
      k += k & -k;
    }
  }
  int get(int k) {
    k++;
    int ret = 0;
    while (k > 0) {
      ret += bit[k];
      k -= k & -k;
    }
    return ret;
  }
  int get(int s, int t) { return get(t) - get(s - 1); }
};
BIT bit1, bit2;
int cnt[200005];
int A, B;
int main() {
  int n, k, q;
  scanf("%d %d %d %d %d", &n, &k, &A, &B, &q);
  bit1.init();
  bit2.init();
  for (int i = 0; i < q; i++) {
    int t;
    scanf("%d", &t);
    if (t == 1) {
      int a, b;
      scanf("%d %d", &a, &b);
      a--;
      bit1.add(a, -min(B, cnt[a]));
      bit2.add(a, -min(A, cnt[a]));
      cnt[a] += b;
      bit1.add(a, min(B, cnt[a]));
      bit2.add(a, min(A, cnt[a]));
    } else {
      int v;
      scanf("%d", &v);
      v--;
      printf("%d\n", bit1.get(0, v - 1) + bit2.get(v + k, n - 1));
    }
  }
  return 0;
}
