#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i, j, st = 0, st1 = 0, st2 = 0;
  string s[200], pass;
  cin >> pass >> n;
  for (i = 0; i < n; i++) {
    cin >> s[i];
    string t = s[i];
    reverse(t.begin(), t.end());
    if (t == pass || s[i] == pass) {
      st = 1;
    }
    if (s[i][0] == pass[1]) st1 = 1;
    if (s[i][1] == pass[0]) st2 = 1;
  }
  if (st1 && st2) st = 1;
  if (st) {
    cout << "YES" << endl;
  } else
    cout << "NO" << endl;
  return 0;
}
