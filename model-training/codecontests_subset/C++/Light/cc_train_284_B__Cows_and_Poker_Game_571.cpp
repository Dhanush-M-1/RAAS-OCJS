#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  string s;
  cin >> s;
  int all = 0, in = 0;
  for (int x = 0; x < n; x++) {
    if (s[x] == 'A') all += 1;
    if (s[x] == 'I') in += 1;
  }
  if (in > 1)
    cout << 0;
  else if (in < 1)
    cout << all;
  else if (in == 1)
    cout << 1;
  return 0;
}
