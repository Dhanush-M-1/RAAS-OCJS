#include <bits/stdc++.h>
using namespace std;
int main() {
  vector<string> v;
  vector<string>::iterator it;
  string s, p;
  cin >> s;
  int n, c = 0;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> p;
    v.push_back(p);
    if (s[0] == p[0] && s[1] == p[1]) {
      cout << "YES";
      return 0;
    }
    if (s[0] == p[1] && s[1] == p[0]) {
      cout << "YES";
      return 0;
    }
  }
  for (int i = 0; i < n; i++) {
    if (v[i][1] == s[0]) {
      c = 1;
    }
  }
  for (int i = 0; i < n; i++) {
    if (v[i][0] == s[1] && c == 1) {
      cout << "YES";
      return 0;
    }
  }
  cout << "NO";
}
