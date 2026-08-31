#include <bits/stdc++.h>
using namespace std;
bitset<423> ans[423], p[423][26];
char q;
int main() {
  int n, m;
  cin >> n >> m;
  for (int(i) = 0; (i) < (n); ++(i))
    for (int(j) = 0; (j) < (m); ++(j))
      scanf(" %c", &q), p[i][q - 'a'][j] = ans[i][j] = 1;
  int r, c;
  cin >> r >> c;
  for (int(i) = 0; (i) < (r); ++(i))
    for (int(j) = 0; (j) < (c); ++(j))
      if (scanf(" %c", &q), q != '?')
        for (int(k) = 0; (k) < (n); ++(k))
          ans[(k + n - i % n) % n] &= p[k][q - 'a'] >> j % m | p[k][q - 'a']
                                                                   << m - j % m;
  for (int(i) = 0; (i) < (n); ++(i))
    for (int(j) = 0; (j) < (m); ++(j))
      printf("%d%s", (int)ans[i][j], j == m - 1 ? "\n" : "");
  return 0;
}
