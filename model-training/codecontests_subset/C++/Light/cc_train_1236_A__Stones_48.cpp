#include <bits/stdc++.h>
using namespace std;
const int MOD = 1e9 + 7;
const int INF = INT_MAX;
const long long int LINF = LLONG_MAX;
int main() {
  ios_base::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL);
  int t;
  cin >> t;
  while (t--) {
    int a, b, c, res = 0;
    cin >> a >> b >> c;
    while (c >= 2 && b >= 1) {
      res += 3;
      c -= 2;
      b -= 1;
    }
    while (b >= 2 && a >= 1) {
      res += 3;
      b -= 2;
      a -= 1;
    }
    cout << res << "\n";
  }
  return 0;
}
