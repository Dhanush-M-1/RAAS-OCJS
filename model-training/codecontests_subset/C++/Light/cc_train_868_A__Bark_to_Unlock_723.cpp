#include <bits/stdc++.h>
using namespace std;
int main() {
  string s, str, ans;
  cin >> s;
  string rev = s;
  reverse(s.begin(), s.end());
  int n;
  cin >> n;
  string x;
  while (n) {
    cin >> x;
    if (s == x) {
      cout << "YES" << endl;
      return 0;
    } else if (x == rev) {
      cout << "YES" << endl;
      return 0;
    } else if (x[1] == rev[0]) {
      ans[0] = x[1];
    } else if (x[0] == rev[1]) {
      ans[1] = x[0];
    }
    n--;
  }
  if (ans[0] == rev[0] && ans[1] == rev[1]) {
    cout << "YES" << endl;
  } else {
    cout << "NO" << endl;
  }
  return 0;
}
