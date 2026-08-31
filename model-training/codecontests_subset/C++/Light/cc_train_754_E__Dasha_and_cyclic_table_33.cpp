#include <bits/stdc++.h>
using namespace std;
const int N = 401;
bitset<N> bs[26][N][N];
char a[N][N], b[N][N];
int n, m, r, c, ans[N][N];
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cin >> n >> m;
  for (int i = 0; i < n; i++)
    for (int j = 0; j < m; j++) cin >> a[i][j];
  cin >> r >> c;
  for (int i = 0; i < r; i++)
    for (int j = 0; j < c; j++) cin >> b[i][j];
  for (int i = 0; i < n; i++)
    for (int j = 0; j < m; j++)
      for (int l = 0; l < c; l++) bs[a[i][(j + l) % m] - 'a'][i][l].set(j);
  for (int i = 0; i < n; i++) {
    bitset<N> k;
    k.set();
    for (int j = 0; j < r; j++)
      for (int l = 0; l < c; l++)
        if (b[j][l] != '?') k &= bs[b[j][l] - 'a'][(j + i) % n][l];
    for (int j = 0; j < m; j++) ans[i][j] = k[j];
  }
  for (int i = 0; i < n; i++, cout << endl)
    for (int j = 0; j < m; j++) cout << ans[i][j];
  return 0;
}
