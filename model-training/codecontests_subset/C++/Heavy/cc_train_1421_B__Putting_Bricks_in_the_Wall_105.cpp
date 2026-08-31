#include <bits/stdc++.h>
using namespace std;
int solve() {
  int n;
  cin >> n;
  string s[n];
  for (int i = 0; i < n; i++) cin >> s[i];
  if (s[0][1] == s[1][0] and s[n - 2][n - 1] == s[n - 1][n - 2] and
      s[0][1] != s[n - 2][n - 1]) {
    puts("0");
    return 0;
  }
  if (s[0][1] == s[1][0]) {
    if (s[n - 1][n - 2] == s[0][1] and s[n - 2][n - 1] == s[0][1]) {
      puts("2");
      puts("1 2");
      puts("2 1");
    } else {
      puts("1");
      if (s[n - 2][n - 1] == s[0][1])
        cout << n - 1 << " " << n << "\n";
      else
        cout << n << " " << n - 1 << "\n";
    }
    return 0;
  }
  if (s[n - 1][n - 2] == s[n - 2][n - 1]) {
    puts("1");
    if (s[n - 2][n - 1] == s[0][1])
      puts("1 2");
    else
      puts("2 1");
    return 0;
  }
  puts("2");
  if (s[0][1] == '1')
    puts("1 2");
  else
    puts("2 1");
  if (s[n - 2][n - 1] == '0')
    cout << n - 1 << " " << n << "\n";
  else
    cout << n << " " << n - 1 << "\n";
  return 0;
}
int main() {
  int t;
  cin >> t;
  while (t--) {
    solve();
  }
}
