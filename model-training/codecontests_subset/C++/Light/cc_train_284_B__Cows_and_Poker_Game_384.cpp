#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  int n;
  cin >> n;
  cin >> s;
  int a = 0, b = 0, c = 0;
  for (int i = 0; i < s.length(); i++) {
    if (s[i] == 'I') {
      a++;
    } else if (s[i] == 'A') {
      b++;
    } else {
      c++;
    }
  }
  int ans = 0;
  for (int i = 0; i < n; i++) {
    if (s[i] == 'A') {
      b--;
      if (b + c == n - 1) {
        ans++;
      }
      b++;
    } else if (s[i] == 'I') {
      a--;
      if (b + c == n - 1) {
        ans++;
      }
      a++;
    }
  }
  cout << ans;
  return 0;
}
