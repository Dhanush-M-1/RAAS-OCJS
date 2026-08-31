#include <bits/stdc++.h>
using namespace std;
const double PI =
    3.141592653589793238462643383279502884197169399375105820974944592307816406286;
class SegmentTree {
  long long int T[2 * 200002], N;

 public:
  int F(int A, int B) { return A + B; }
  void build(int size, long long int *V) {
    N = size;
    for (int i = N; i < 2 * N; i++) T[i] = V[i - N];
    for (int i = N - 1; i > 0; i--) T[i] = F(T[i << 1], T[i << 1 | 1]);
  }
  void set(int pos, long long int val) {
    pos += N;
    for (T[pos] = val; pos > 1; pos >>= 1) T[pos >> 1] = F(T[pos], T[pos ^ 1]);
  }
  long long int query(int i, int j) {
    i += N;
    j += N + 1;
    long long int ret = 0;
    while (i < j) {
      if (i % 2) ret = F(ret, T[i++]);
      if (j % 2) ret = F(ret, T[--j]);
      i >>= 1;
      j >>= 1;
    }
    return ret;
  }
};
SegmentTree TA, TB;
long long int VA[200002], VB[200002];
long long int n, k, a, b, q, o, x, y;
int main() {
  ios_base::sync_with_stdio(false);
  scanf("%I64d %I64d %I64d %I64d %I64d", &n, &k, &a, &b, &q);
  memset(VA, 0, sizeof(VA));
  memset(VB, 0, sizeof(VB));
  TA.build(n, VA);
  TB.build(n, VB);
  for (int i = 0; i < q; i++) {
    scanf("%I64d", &o);
    if (o == 1) {
      scanf("%I64d %I64d", &x, &y);
      x--;
      TA.set(x, -VA[x]);
      TB.set(x, -VB[x]);
      VA[x] = min(a, VA[x] + y);
      VB[x] = min(b, VB[x] + y);
      TA.set(x, VA[x]);
      TB.set(x, VB[x]);
    } else {
      scanf("%I64d", &x);
      x--;
      long long ret = 0;
      if (x > 0) ret += TB.query(0, x - 1);
      if (x + k < n) ret += TA.query(x + k, n - 1);
      printf("%I64d\n", ret);
    }
  }
}
