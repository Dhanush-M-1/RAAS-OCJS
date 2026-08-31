#include <bits/stdc++.h>
using namespace std;
long long int n, i, c, j, f;
char a;
string x, s[105];
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  ;
  cin >> x;
  cin >> n;
  for (i = 0; i < n; i++) {
    cin >> s[i];
  }
  for (i = 0; i < n; i++) {
    if (s[i][0] == x[0] && s[i][1] == x[1]) {
      cout << "YES";
      f = 1;
      return 0;
    }
    if (s[i][1] == x[0]) {
      for (j = 0; j < n; j++) {
        if (s[j][0] == x[1]) {
          cout << "YES";
          f = 1;
          return 0;
        }
      }
    }
    cout << endl;
  }
  if (f == 0) cout << "NO";
  return 0;
}
