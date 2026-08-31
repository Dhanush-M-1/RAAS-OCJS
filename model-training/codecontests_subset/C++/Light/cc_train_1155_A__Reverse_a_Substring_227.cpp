#include <bits/stdc++.h>
using namespace std;
string s;
int n;
int main() {
  ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0), cout.precision(15);
  cin >> n >> s;
  for (int i = (0); i <= (((int)(s).size() - 1) - 1); i += (+1)) {
    if (s[i] > s[i + 1]) {
      cout << "YES\n";
      cout << i + 1 << ' ' << i + 2 << '\n';
      return 0;
    }
  }
  cout << "NO\n";
  return 0;
}
