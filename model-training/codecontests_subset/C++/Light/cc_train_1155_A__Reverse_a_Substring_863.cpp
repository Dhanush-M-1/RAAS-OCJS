#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  int n;
  string s;
  cin >> n >> s;
  for (int x = 1; x < n; x++) {
    if (s[x - 1] > s[x]) {
      cout << "YES\n";
      cout << x << ' ' << x + 1 << '\n';
      return 0;
    }
  }
  cout << "NO\n";
  return 0;
}
