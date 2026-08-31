#include <bits/stdc++.h>
using namespace std;
long long va[300300];
long long vb[300300];
long long T[2][300300];
void update(int idx, int val, int r) {
  idx++;
  while (idx < 300300) {
    T[r][idx] += val;
    idx += idx & -idx;
  }
}
long long query(int idx, int r) {
  if (idx < 0) return 0;
  long long ret = 0;
  idx++;
  while (idx) {
    ret += T[r][idx];
    idx -= idx & -idx;
  }
  return ret;
}
int main() {
  int n, k, a, b, q;
  scanf("%d%d%d%d%d", &n, &k, &a, &b, &q);
  while (q--) {
    int t;
    scanf("%d", &t);
    if (t == 1) {
      int d, s;
      scanf("%d%d", &d, &s), d--;
      int old = va[d];
      va[d] = min((long long)a, va[d] + s);
      update(d, va[d] - old, 0);
      old = vb[d];
      vb[d] = min((long long)b, vb[d] + s);
      update(d, vb[d] - old, 1);
    } else {
      int d;
      scanf("%d", &d), d--;
      long long ans = query(d - 1, 1) + query(n, 0) - query(d + k - 1, 0);
      cout << ans << endl;
    }
  }
}
