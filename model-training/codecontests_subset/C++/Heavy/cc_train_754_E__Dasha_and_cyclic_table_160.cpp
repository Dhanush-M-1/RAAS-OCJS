#include <bits/stdc++.h>
using namespace std;
const int N = 404;
char str[500];
bitset<N> G[27][N], A[N];
int n, m, r, c;
bitset<N> shift(char c, int i, int x) {
  bitset<N> temp = G[c][i];
  return (temp >> x) | (temp << (m - x));
}
int main() {
  scanf("%d %d", &n, &m);
  for (int i = 0; i < n; i++) {
    scanf("%s", str);
    for (int j = 0; j < m; j++) G[str[j] - 'a'][i][j] = 1, A[i][j] = 1;
  }
  scanf("%d %d", &r, &c);
  for (int i = 0; i < r; i++) {
    scanf("%s", str);
    for (int j = 0; j < c; j++) {
      char ch = str[j];
      if (ch == '?') continue;
      for (int k = 0; k < n; k++)
        A[k] = (A[k] & shift(ch - 'a', (k + i) % n, j % m));
    }
  }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) printf("%d", A[i][j] ? 1 : 0);
    printf("\n");
  }
}
