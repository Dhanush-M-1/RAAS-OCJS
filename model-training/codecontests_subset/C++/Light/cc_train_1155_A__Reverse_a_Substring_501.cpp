#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int n;
  cin >> n;
  string s;
  cin >> s;
  int gg = -1;
  int l = 0, r = n;
  bool ok = 0;
  for (int i = 0; i < n; i++) {
    int x = s[i] - 'a';
    if (x < gg) {
      ok = 1;
      r = i + 1;
      break;
    }
    if (x > gg) {
      l = i + 1;
      gg = x;
    }
  }
  if (ok) {
    cout << "YES" << endl;
    cout << l << ' ' << r << endl;
  } else
    cout << "NO" << endl;
  return 0;
}
