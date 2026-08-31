#include <bits/stdc++.h>
using namespace std;
int main() {
  char s[2];
  cin >> s;
  int n;
  cin >> n;
  char b[101][2];
  for (int i = 0; i < n; i++) {
    cin >> b[i];
    if (b[i][0] == s[0] && b[i][1] == s[1]) {
      cout << "YES";
      return 0;
    }
  }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      if (b[i][1] == s[0] && b[j][0] == s[1]) {
        cout << "YES";
        return 0;
      }
    }
  }
  cout << "NO";
  return 0;
}
