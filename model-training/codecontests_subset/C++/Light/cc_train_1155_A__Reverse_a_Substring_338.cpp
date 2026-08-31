#include <bits/stdc++.h>
using namespace std;
void solver() {
  int n;
  cin >> n;
  string s;
  cin >> s;
  int l = s.length();
  for (int i = 0; i <= l - 2; i++) {
    if (s[i + 1] < s[i]) {
      cout << "YES \n" << i + 1 << " " << i + 2;
      return;
    }
  }
  cout << "NO\n";
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t = 1;
  while (t--) solver();
  return 0;
}
