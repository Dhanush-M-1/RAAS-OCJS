#include <bits/stdc++.h>
using namespace std;
const long long int INF = (long long int)(8e18);
const long long int MOD = 1e9 + 7;
const int maxn = 100010;
int main() {
  ios ::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  string a, b;
  cin >> a >> b;
  int n;
  cin >> n;
  cout << a << ' ' << b << '\n';
  for (int i = 0; i < n; i++) {
    string x, y;
    cin >> x >> y;
    if (x == a || x == b) {
      if (x == a) {
        cout << y << ' ' << b << '\n';
        a = y;
      } else {
        cout << y << ' ' << a << '\n';
        b = y;
      }
    } else {
      if (y == a) {
        cout << x << ' ' << b << '\n';
        a = x;
      } else {
        cout << x << ' ' << a << '\n';
        b = x;
      }
    }
  }
}
