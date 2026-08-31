#include <bits/stdc++.h>
const long long INF = 2e18;
const long long N = 1e6 + 1;
const long long mod = 1e9 + 1;
const long double eps = 1E-7;
using namespace std;
void solve() {
  int n;
  string s;
  cin >> n;
  cin >> s;
  sort(s.begin(), s.end());
  int x = 0;
  for (int i = n - 1; i >= 0; --i) {
    if (s[i] == '8') x++;
    if (x * 11 > n) {
      x--;
      break;
    }
  }
  cout << x << endl;
}
bool mtest = false;
int main() {
  ios_base::sync_with_stdio(0);
  int TE = 1;
  if (mtest) cin >> TE;
  while (TE--) solve();
  return 0;
}
