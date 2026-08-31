#include <bits/stdc++.h>
using namespace std;
int n, m, r, c;
char str[500];
bitset<500> ans[500], mp[500][26];
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 0; i < n; ++i) {
    scanf("%s", str);
    for (int j = 0; j < m; ++j) {
      mp[i][str[j] - 'a'][j] = ans[i][j] = true;
    }
  }
  for (int i = 0; i < 499; ++i) str[i] = 0;
  scanf("%d%d", &r, &c);
  for (int i = 0; i < r; ++i) {
    scanf("%s", str);
    for (int j = 0; j < c; ++j) {
      if (str[j] == '?') continue;
      for (int k = 0; k < n; ++k)
        ans[(k - i % n + n) % n] &=
            mp[k][str[j] - 'a'] >> j % m | mp[k][str[j] - 'a'] << m - j % m;
    }
  }
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < m; ++j) printf("%d", (int)ans[i][j]);
    puts("");
  }
  return 0;
}
