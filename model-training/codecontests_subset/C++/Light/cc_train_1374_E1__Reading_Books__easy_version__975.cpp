#include <bits/stdc++.h>
using namespace std;
int main() {
  int k, n;
  cin >> n >> k;
  int aa[n], ba[n], ra[n];
  int r = 0, a = 0, b = 0;
  for (int i = 0, v, m, u; i < n; ++i) {
    cin >> v >> m >> u;
    if (m && u)
      ra[r++] = v;
    else if (u)
      ba[b++] = v;
    else if (m)
      aa[a++] = v;
  }
  sort(ba, ba + b);
  sort(aa, aa + a);
  for (int i = 0, s = min(a, b); i < s; ++i) ra[r++] = (aa[i] + ba[i]);
  if (r < k) {
    cout << "-1\n";
    return 0;
  }
  sort(ra, ra + r);
  long long an = 0;
  for (int i = 0; i < k; ++i) an += ra[i];
  cout << an << '\n';
}
