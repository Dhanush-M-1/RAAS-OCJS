#include <bits/stdc++.h>
using namespace std;
void faster() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
}
const int MAXN = 3e5 + 10;
const long long INF = 1e18;
const long long MOD = 1e8;
long long T, a, b, c, ans;
int main() {
  faster();
  cin >> T;
  while (T--) {
    cin >> a >> b >> c;
    ans += min(b, (c / 2)) * 3;
    b -= min(b, (c / 2));
    ans += min(a, b / 2) * 3;
    cout << ans << '\n';
    ans = 0;
  }
  return 0;
}
