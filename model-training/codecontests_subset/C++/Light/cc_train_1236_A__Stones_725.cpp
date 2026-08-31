#include <bits/stdc++.h>
using namespace std;
using LL = long long;
constexpr int N = 1e5 + 5;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  int t;
  cin >> t;
  while (t--) {
    int a, b, c;
    cin >> a >> b >> c;
    int res = 0;
    res += min(b, c / 2);
    b -= min(b, c / 2);
    res += min(a, b / 2);
    cout << res * 3 << "\n";
  }
}
