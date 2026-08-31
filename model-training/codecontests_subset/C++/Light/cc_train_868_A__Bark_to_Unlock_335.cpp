#include <bits/stdc++.h>
using namespace std;
const int inf = 1e5 + 10;
string s;
string q[110];
int main() {
  int n;
  cin >> s;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> q[i];
    if (q[i] == s) {
      cout << "YES" << endl;
      return 0;
    }
  }
  for (int i = 1; i <= n; i++) {
    for (int j = i; j <= n; j++) {
      if ((q[i][1] == s[0] && q[j][0] == s[1]) ||
          (q[j][1] == s[0] && q[i][0] == s[1])) {
        cout << "YES" << endl;
        return 0;
      }
    }
  }
  cout << "NO" << endl;
}
