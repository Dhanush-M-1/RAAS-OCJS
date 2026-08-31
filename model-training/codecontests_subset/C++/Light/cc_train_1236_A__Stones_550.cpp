#include <bits/stdc++.h>
#pragma GCC optimize("O3")
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t;
  cin >> t;
  for (; t; --t) {
    int a, b, c;
    cin >> a >> b >> c;
    int a2, b2, c2;
    a2 = a, b2 = b, c2 = c;
    int mx1 = min(a, b / 2) * 3;
    b -= 2 * min(a, b / 2);
    mx1 += min(b, c / 2) * 3;
    a = a2, b = b2, c = c2;
    int mx2 = min(b, c / 2) * 3;
    b -= min(b, c / 2);
    mx2 += min(a, b / 2) * 3;
    cout << max(mx1, mx2) << '\n';
  }
  return 0;
}
