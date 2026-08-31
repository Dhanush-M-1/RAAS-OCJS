#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  bool match = 0;
  bool match0 = 0;
  bool match1 = 0;
  string pw, t;
  cin >> pw;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> t;
    match |= t == pw;
    match0 |= t[1] == pw[0];
    match1 |= t[0] == pw[1];
  }
  cout << (match || (match0 && match1) ? "YES\n" : "NO\n");
  return 0;
}
