#include <bits/stdc++.h>
using namespace std;
char s[423];
bitset<423> ans[423], p[423][26];
int main() {
  int n, m;
  cin >> n >> m;
  for (int(i) = 0; (i) < (n); ++(i)) {
    scanf("%s", s);
    for (int(j) = 0; (j) < (m); ++(j)) {
      p[i][s[j] - 'a'][j] = 1;
      ans[i][j] = 1;
    }
  }
  int r, c;
  cin >> r >> c;
  for (int(i) = 0; (i) < (r); ++(i)) {
    scanf("%s", s);
    for (int(j) = 0; (j) < (c); ++(j)) {
      if (s[j] == '?') continue;
      int ii = i % n, jj = j % m;
      for (int(k) = 0; (k) < (n); ++(k)) {
        ans[(k + n - ii) % n] &= p[k][s[j] - 'a'] >> jj | p[k][s[j] - 'a']
                                                              << m - jj;
      }
    }
  }
  for (int(i) = 0; (i) < (n); ++(i)) {
    for (int(j) = 0; (j) < (m); ++(j)) printf("%d", (int)ans[i][j]);
    putchar('\n');
  }
  return 0;
}
