#include <bits/stdc++.h>
using namespace std;
const int NMAX = 2 * 1e5 + 1e3;
int n;
int res;
int a, b, d, k, p, q, ai, pcase;
int v1[1 + NMAX];
int v2[1 + NMAX];
int ap[1 + NMAX];
int bp[1 + NMAX];
void update(int i, int v, int bit[]) {
  for (; i <= n; i += i & (-i)) bit[i] += v;
}
int query(int i, int bit[]) {
  int res;
  for (res = 0; i > 0; i -= i & (-i)) res += bit[i];
  return res;
}
int main() {
  ios::sync_with_stdio(false);
  cin >> n >> k >> a >> b >> q;
  for (int test = 1; test <= q; test++) {
    cin >> pcase;
    if (pcase == 1) {
      cin >> d >> ai;
      update(d, min(a - ap[d], ai), v1);
      ap[d] += min(a - ap[d], ai);
      update(d, min(b - bp[d], ai), v2);
      bp[d] += min(b - bp[d], ai);
    } else {
      cin >> p;
      res = query(p - 1, v2) + query(n, v1) - query(p + k - 1, v1);
      cout << res << '\n';
    }
  }
  return 0;
}
