#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  int n;
  string s;
  cin >> n >> s;
  for (int i = 0; i < (int)s.size() - 1; i++) {
    if (s[i] > s[i + 1]) {
      cout << "YES\n";
      cout << i + 1 << " " << i + 2;
      return 0;
    }
  }
  cout << "NO\n";
  return 0;
}
