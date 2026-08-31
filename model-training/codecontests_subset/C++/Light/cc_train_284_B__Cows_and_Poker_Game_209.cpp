#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n;
  cin >> n;
  string s;
  cin >> s;
  int a = 0, f = 0, i = 0;
  for (int j = 0; j < n; j++) {
    if (s[j] == 'A') ++a;
    if (s[j] == 'F') ++f;
    if (s[j] == 'I') ++i;
  }
  if (i == 1) cout << 1 << '\n';
  if (i == 0) cout << a << '\n';
  if (i > 1) cout << 0 << '\n';
  return 0;
}
