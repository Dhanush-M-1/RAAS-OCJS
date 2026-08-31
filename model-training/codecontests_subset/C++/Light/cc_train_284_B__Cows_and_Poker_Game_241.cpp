#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  string s;
  int ans = 0;
  cin >> s;
  if (s.find("I") != -1) {
    for (int i = 0; i < n; i++)
      if (s[i] == 'I') {
        if (!ans)
          ans++;
        else {
          ans = 0;
          break;
        }
      }
  } else {
    for (int i = 0; i < n; i++)
      if (s[i] == 'A') ans++;
  }
  cout << ans << endl;
}
