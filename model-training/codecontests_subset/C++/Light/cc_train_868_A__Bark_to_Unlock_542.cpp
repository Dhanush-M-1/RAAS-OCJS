#include <bits/stdc++.h>
using namespace std;
const double pi = 2 * acos(0.0);
const double eps = 1e-7;
const int IINF = INT_MAX;
const long long LINF = LLONG_MAX;
const int imod = 1e9 + 7;
const long long lmod = 1e18 + 7;
string s[110];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  map<string, int> x;
  string n;
  cin >> n;
  x[n] = 1;
  int m;
  cin >> m;
  int k = 0;
  for (int i = 1; i <= m; i++) {
    cin >> s[i];
    x[s[i]]++;
    if (s[i][0] == n[1] and k == 0) k++;
  }
  if (x[n] > 1) {
    cout << "YES";
    return 0;
  }
  if (k == 0) {
    cout << "NO";
    return 0;
  }
  for (int i = 1; i <= m; i++) {
    if (s[i][1] == n[0]) {
      cout << "YES";
      return 0;
    }
  }
  cout << "NO";
  return 0;
}
