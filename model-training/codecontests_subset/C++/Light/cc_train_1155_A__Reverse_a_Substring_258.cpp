#include <bits/stdc++.h>
using namespace std;
const int mod = 1e9 + 7;
const int maxn = 1e5 + 10;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  string s;
  int n = 0;
  cin >> n;
  cin >> s;
  for (int i = 0; i < n - 1; i++) {
    if (s[i] > s[i + 1]) {
      cout << "YES" << endl;
      cout << i + 1 << " " << i + 2;
      return 0;
    }
  }
  cout << "NO";
  return 0;
}
