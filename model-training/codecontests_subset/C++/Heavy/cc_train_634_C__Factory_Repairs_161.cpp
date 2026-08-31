#include <bits/stdc++.h>
using namespace std;
long long n, k, a, b;
struct bitch {
  long long b[200100];
  bitch() { memset(b, 0, sizeof b); }
  void reset() { memset(b, 0, sizeof b); }
  void update(int at, int val) {
    for (int i = at; i < 200100; i += (i & (-i))) b[i] += val;
  }
  long long query(int at) {
    long long ret = 0;
    for (int i = at; i > 0; i -= (i & (-i))) ret += b[i];
    return ret;
  }
  long long query(int i, int j) { return query(j) - query(i - 1); }
};
bitch A, B;
int main() {
  int q;
  scanf("%lld %lld %lld %lld %d", &n, &k, &a, &b, &q);
  A.reset();
  B.reset();
  while (q--) {
    int o;
    scanf("%d", &o);
    if (o == 1) {
      long long d, val;
      scanf("%lld %lld", &d, &val);
      long long addA = min(a - A.query(d, d), val);
      A.update(d, addA);
      long long addB = min(b - B.query(d, d), val);
      B.update(d, addB);
    } else {
      long long d;
      scanf("%lld", &d);
      cout << B.query(d - 1) + A.query(d + k, n + 1) << endl;
    }
  }
  return 0;
}
