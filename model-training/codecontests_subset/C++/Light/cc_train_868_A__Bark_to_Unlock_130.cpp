#include <bits/stdc++.h>
using namespace std;
mt19937 rnd(chrono::high_resolution_clock::now().time_since_epoch().count());
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  string s;
  cin >> s;
  int n;
  cin >> n;
  bool x = false, y = false;
  for (int i = 0; i < n; i++) {
    string t;
    cin >> t;
    if (t == s) {
      cout << "YES\n";
      return 0;
    }
    if (t[0] == s[1] && t[1] == s[0]) {
      cout << "YES\n";
      return 0;
    }
    if (t[0] == s[1]) x = 1;
    if (t[1] == s[0]) y = 1;
  }
  if (x && y) {
    cout << "YES\n";
  } else {
    cout << "NO\n";
  }
  return 0;
}
