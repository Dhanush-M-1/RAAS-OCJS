#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i, f = 0, p;
  cin >> n;
  string s;
  cin >> s;
  for (i = 1; i < n; i++) {
    if (s[i] < s[i - 1]) {
      f = 1;
      p = i - 1;
      break;
    }
  }
  if (f == 1)
    cout << "YES\n" << p + 1 << " " << p + 2 << "\n";
  else
    cout << "NO\n";
}
