#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  int n;
  cin >> s >> n;
  int res1 = 0, res2 = 0;
  for (int i = 1; i <= n; i++) {
    string s1;
    cin >> s1;
    if (s1 == s) {
      cout << "YES";
      return 0;
    }
    if (s[1] == s1[0]) {
      res1++;
    }
    if (s[0] == s1[1]) {
      res2++;
    }
  }
  if (res1 != 0 && res2 != 0) {
    cout << "YES";
  } else {
    cout << "NO";
  }
}
