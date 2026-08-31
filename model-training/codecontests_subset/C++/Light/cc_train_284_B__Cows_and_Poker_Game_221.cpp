#include <bits/stdc++.h>
using namespace std;
int n, ans, c[3];
string s;
int main() {
  cin >> n >> s;
  for (int i = 0; i < n; ++i) {
    if (s[i] == 'A')
      ++c[0];
    else if (s[i] == 'F')
      ++c[1];
    else
      ++c[2];
  }
  for (int i = 0; i < n; ++i) {
    if (s[i] == 'A')
      --c[0];
    else if (s[i] == 'F')
      --c[1];
    else
      --c[2];
    if (s[i] != 'F') {
      if (!c[2]) ++ans;
    }
    if (s[i] == 'A')
      ++c[0];
    else if (s[i] == 'F')
      ++c[1];
    else
      ++c[2];
  }
  cout << ans << endl;
  return 0;
}
