#include <bits/stdc++.h>
using namespace std;
const int MXN = 5e4 + 5;
const int INF = 1e9;
const long long P = 29;
const long long MOD = 1e9 + 7;
int t;
int main() {
  srand(time(0));
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cout << fixed << setprecision(10);
  cin >> t;
  while (t--) {
    int n, x1, x2, x3;
    cin >> n;
    cin >> x1 >> x2;
    for (int i = 2; i < n; i++) {
      cin >> x3;
    }
    if (x1 + x2 <= x3)
      cout << 1 << ' ' << 2 << ' ' << n << '\n';
    else
      cout << -1 << '\n';
  }
  return 0;
}
