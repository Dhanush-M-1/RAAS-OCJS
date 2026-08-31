#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, ans = 0, l = 0;
  string s;
  bool tI = 1;
  cin >> n >> s;
  for (int i = 0; i < ((int)s.size()); i++) {
    if (s[i] == 'A' && tI == 1) {
      ans++;
    }
    if (s[i] == 'I') {
      tI = 0;
      ans = 1;
      l++;
    }
  }
  if (l > 1) ans = 0;
  cout << ans << endl;
  return 0;
}
