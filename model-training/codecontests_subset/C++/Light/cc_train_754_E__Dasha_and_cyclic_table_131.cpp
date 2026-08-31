#include <bits/stdc++.h>
using namespace std;
const long long N = 405;
const long long mod = 1e9 + 7;
const long long inf = 1e9 + 1;
int dx[] = {0, 0, -1, 1};
int dy[] = {1, -1, 0, 0};
bitset<2 * N> ans[N], a[26][N];
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  cerr.tie(nullptr);
  int n, m;
  cin >> n >> m;
  for (long long i = 0; i <= n - 1; i++)
    for (long long j = 0; j <= m - 1; j++) {
      char ch;
      cin >> ch;
      a[ch - 'a'][i][j] = 1;
      a[ch - 'a'][i][j + m] = 1;
      ans[i][j] = 1;
    }
  int r, c;
  cin >> r >> c;
  for (long long i = 0; i <= r - 1; i++)
    for (long long j = 0; j <= c - 1; j++) {
      char ch;
      cin >> ch;
      if (ch == '?') continue;
      for (long long k = 0; k <= n - 1; k++)
        ans[k] &= a[ch - 'a'][(k + i) % n] >> (j % m);
    }
  for (long long i = 0; i <= n - 1; i++) {
    for (long long j = 0; j <= m - 1; j++) cout << ans[i][j];
    cout << "\n";
  }
}
