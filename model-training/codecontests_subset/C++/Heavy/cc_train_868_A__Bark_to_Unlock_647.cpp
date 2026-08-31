#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int test = 1;
  while (test--) {
    string s;
    int p = 0;
    cin >> s;
    int t, i, j;
    cin >> t;
    vector<string> vec;
    string s0;
    for (i = 0; i < t; i++) {
      cin >> s0;
      vec.push_back(s0);
    }
    int flag = 0;
    for (i = 0; i < t; i++) {
      string s2 = vec[i];
      if (s2 == s || (s2[0] == s[1] && s2[1] == s[0])) {
        flag = 1;
        break;
      }
    }
    if (flag == 1)
      cout << "YES";
    else {
      for (i = 0; i < t; i++) {
        string a = vec[i];
        for (j = 0; j < i; j++) {
          string b = vec[j];
          if ((s[0] == a[1] && s[1] == b[0]) ||
              (s[0] == b[1] && s[1] == a[0])) {
            p = 1;
            break;
          }
        }
        if (p == 1) break;
      }
      if (p == 1)
        cout << "YES";
      else
        cout << "NO";
    }
  }
  return 0;
}
