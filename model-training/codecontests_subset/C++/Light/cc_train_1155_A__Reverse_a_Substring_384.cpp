#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using ld = long double;
const int MAXN = 1e6 + 5, inf = 1e9, mod = 1e9 + 7;
const ll INF = 1e18, MOD = 1e15 + 37;
const ld PI = acos(-1);
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout << setprecision(13) << fixed;
  int n;
  cin >> n;
  string s;
  cin >> s;
  for (int i = 0; i < n - 1; i++) {
    if (s[i] > s[i + 1]) {
      cout << "YES\n";
      cout << i + 1 << " " << i + 2 << "\n";
      return 0;
    }
  }
  cout << "NO\n";
}
