#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  string p, other[200];
  cin >> p;
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    string s;
    cin >> s;
    other[i] = s;
    other[i + n] = s;
  }
  string ans = "NO";
  for (int i = 0; i < 2 * n; i++) {
    for (int j = 0; j < 2 * n; j++) {
      if (other[i] == p || (other[i][1] == p[0] && other[j][0] == p[1])) {
        ans = "YES";
      }
    }
  }
  cout << ans;
  return 0;
}
