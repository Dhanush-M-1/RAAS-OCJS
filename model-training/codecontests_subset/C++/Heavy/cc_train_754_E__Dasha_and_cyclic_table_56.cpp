#include <bits/stdc++.h>
using namespace std;
const int N = 410;
bitset<N> ans[N], mat[26][N];
int main() {
  int n, m;
  scanf("%d%d", &n, &m);
  for (int i = 0; i < n; i++)
    for (int j = 0; j < m; j++) {
      char c;
      scanf(" %c", &c);
      ans[i][j] = true;
      mat[c - 'a'][i][j] = true;
    }
  int r, c;
  scanf("%d%d", &r, &c);
  for (int k = 0; k < r; k++)
    for (int l = 0; l < c; l++) {
      char c;
      scanf(" %c", &c);
      if (c == '?') continue;
      for (int i = 0; i < n; i++) {
        int pos = (i - (k % n) + n) % n;
        ans[pos] &=
            (mat[c - 'a'][i] >> (l % m)) | (mat[c - 'a'][i] << (m - (l % m)));
      }
    }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m - 1; j++) cout << ans[i][j];
    cout << ans[i][m - 1] << endl;
  }
  return 0;
}
