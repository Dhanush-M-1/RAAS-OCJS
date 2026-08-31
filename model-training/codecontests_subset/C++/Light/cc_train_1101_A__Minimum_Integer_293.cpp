#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e6;
long long l, r, d;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  if (fopen(""
            ".INP",
            "r"))
    freopen(
        ""
        ".INP",
        "r", stdin),
        freopen(
            ""
            ".OUT",
            "w", stdout);
  int q;
  cin >> q;
  while (q--) {
    cin >> l >> r >> d;
    long long res1 = d;
    long long res2 = (r / d + 1) * d;
    if (res1 > 0 && (res1 < l || res1 > r))
      cout << res1 << '\n';
    else
      cout << res2 << '\n';
  }
}
