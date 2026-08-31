#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  string s;
  cin >> s;
  int n;
  cin >> n;
  set<char> X[2];
  while (n--) {
    string t;
    cin >> t;
    if (t == s) {
      cout << "YES\n";
      return 0;
    }
    X[0].insert(t[0]);
    X[1].insert(t[1]);
  }
  if (X[0].count(s[1]) && X[1].count(s[0])) {
    cout << "YES\n";
  } else
    cout << "NO\n";
}
