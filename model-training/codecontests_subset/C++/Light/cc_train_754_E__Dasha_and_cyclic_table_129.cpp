#include <bits/stdc++.h>
using namespace std;
const int N = 450;
int n, m, r, c;
bitset<N> ans[N], t[26][N];
char s[N];
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 0; i < n; i++) {
    scanf("%s", s);
    for (int j = 0; j < m; j++) {
      ans[i][j] = true;
      t[s[j] - 'a'][i][j] = true;
    }
  }
  scanf("%d%d", &r, &c);
  for (int i = 0; i < r; i++) {
    scanf("%s", s);
    for (int j = 0; j < c; j++) {
      if (s[j] == '?') continue;
      for (int k = 0, nxt = n - i % n; k < n; k++, nxt++) {
        nxt -= n;
        nxt += nxt >> 31 & n;
        ans[nxt] &=
            (t[s[j] - 'a'][k] >> (j % m)) | (t[s[j] - 'a'][k] << (m - (j % m)));
      }
    }
  }
  for (int i = 0; i < n; i++, puts(""))
    for (int j = 0; j < m; j++) {
      bool x = ans[i][j];
      printf("%d", x);
    }
  return 0;
}
