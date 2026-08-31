#include <bits/stdc++.h>
using namespace std;
int n, m, r, c;
bitset<444> ans[444], G[26][444];
int main() {
  scanf("%d %d", &n, &m);
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      char ch;
      scanf(" %c", &ch);
      ans[i][j] = true;
      G[ch - 'a'][i][j] = true;
    }
  }
  scanf("%d %d", &r, &c);
  for (int i = 0; i < r; i++) {
    for (int j = 0; j < c; j++) {
      char ch;
      scanf(" %c", &ch);
      if (ch == '?') continue;
      for (int k = 0; k < n; k++) {
        int next = ((k + n) - (i % n)) % n;
        ans[next] &=
            (G[ch - 'a'][k] >> (j % m)) | (G[ch - 'a'][k] << (m - (j % m)));
      }
    }
  }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      cout << ans[i][j];
    }
    puts("");
  }
  return 0;
}
