#include <bits/stdc++.h>
using namespace std;
int main() {
  string pw;
  cin >> pw;
  int n;
  cin >> n;
  string s[n];
  for (int i = 0; i < n; i++) {
    cin >> s[i];
    if (s[i] == pw) {
      cout << "YES";
      return 0;
    }
  }
  int flag = 0, sign = 0;
  for (int i = 0; i < n; i++) {
    if (s[i][1] == pw[0]) {
      flag = 1;
      break;
    }
  }
  for (int i = 0; i < n; i++) {
    if (s[i][0] == pw[1]) {
      sign = 1;
      break;
    }
  }
  if (sign && flag)
    cout << "YES";
  else
    cout << "NO";
}
