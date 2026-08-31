#include <bits/stdc++.h>
using namespace std;
const int N = 405;
bitset<N> a[26][N], ans[N];
char s[N];
int n, m, r, w;
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 0; i < n; i++) {
    scanf("%s", s);
    for (int j = 0; j < m; j++) a[s[j] - 'a'][i][j] = ans[i][j] = 1;
  }
  scanf("%d%d", &r, &w);
  for (int i = 0; i < r; i++) {
    scanf("%s", s);
    for (int j = 0; j < w; j++) {
      if (s[j] == '?') continue;
      for (int k = 0; k < n; k++)
        ans[k] &= (a[s[j] - 'a'][(k + i) % n] >> (j % m)) |
                  (a[s[j] - 'a'][(k + i) % n] << ((m - j) % m + m) % m);
    }
  }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) putchar(ans[i][j] + 48);
    puts("");
  }
}
