#include <bits/stdc++.h>
using namespace std;
const int N = 410;
bitset<4 * N * N> vis[30], sta;
char s[2 * N][2 * N], w[N][N];
int main() {
  int n1, m1, n2, m2, tot = 0;
  scanf("%d%d", &n1, &m1);
  for (int i = 0; i < n1; i++) scanf("%s", s[i]);
  scanf("%d%d", &n2, &m2);
  for (int i = 0; i < n2; i++) scanf("%s", w[i]);
  for (int i = 0; i < n1 + n2; i++) {
    for (int j = 0; j < m1 + m2; j++) {
      s[i][j] = s[i % n1][j % m1];
      vis[s[i][j] - 'a'].set(i * (m1 + m2) + j);
    }
  }
  sta.set();
  for (int i = 0; i < n2; i++) {
    for (int j = 0; j < m2; j++) {
      if (w[i][j] == '?') continue;
      sta &= (vis[w[i][j] - 'a'] >> (i * (m1 + m2) + j));
    }
  }
  for (int i = 0; i < n1; i++) {
    for (int j = 0; j < m1; j++) printf("%d", sta[i * (m1 + m2) + j] ? 1 : 0);
    printf("\n");
  }
  return 0;
}
