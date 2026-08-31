#include <bits/stdc++.h>
using namespace std;
int main() {
  string t;
  int n;
  cin >> t >> n;
  string s[105];
  for (int i = 1; i <= n; i++) cin >> s[i];
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++)
      if ((s[i] + s[j]).find(t) != string::npos) {
        cout << "YES";
        return 0;
      }
  }
  cout << "NO";
  return 0;
}
