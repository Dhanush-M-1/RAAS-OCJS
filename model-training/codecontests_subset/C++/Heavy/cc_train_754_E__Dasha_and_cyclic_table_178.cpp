#include <bits/stdc++.h>
using namespace std;
const int N = 405;
bitset<2 * N> a[26][N], ans[N];
char s[N][N];
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int n, m;
  cin >> n >> m;
  for (int i = (0); i < (n); i++) {
    for (int j = (0); j < (m); j++) cin >> s[i][j];
  }
  for (int i = (0); i < (n); i++) {
    for (int j = (0); j < (m); j++) {
      a[s[i][j] - 'a'][i][j] = 1;
      a[s[i][j] - 'a'][i][j + m] = 1;
      ans[i][j] = 1;
    }
  }
  int r, c;
  cin >> r >> c;
  for (int i = (0); i < (r); i++) {
    for (int j = (0); j < (c); j++) {
      cin >> s[i][j];
      if (s[i][j] == '?') continue;
      for (int k = (0); k < (n); k++) {
        ans[k] &= (a[s[i][j] - 'a'][(k + i) % n] >> (j % m));
      }
    }
  }
  for (int i = (0); i < (n); i++) {
    for (int j = (0); j < (m); j++) {
      if (ans[i][j])
        cout << "1";
      else
        cout << "0";
    }
    cout << "\n";
  }
  return 0;
}
