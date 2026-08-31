#include <bits/stdc++.h>
using namespace std;
const int N = 4e5 + 20;
const long long MOD2 = 998244353;
const long long MOD = 1e9 + 7;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  ;
  int ttt;
  cin >> ttt;
  while (ttt--) {
    int a, b, c;
    cin >> a >> b >> c;
    int ans = min(b, c / 2) * 3;
    b -= min(b, c / 2);
    ans += min(a, b / 2) * 3;
    cout << ans << endl;
  }
  return 0;
}
