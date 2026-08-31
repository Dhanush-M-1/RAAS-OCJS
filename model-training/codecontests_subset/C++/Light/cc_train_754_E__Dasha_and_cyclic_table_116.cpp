#include <bits/stdc++.h>
using namespace std;
const int N = 4e2 + 5;
char s[N][N], pt[N][N];
int n, m, r, c;
bitset<N << 1> B1[26][N], ANS[N];
int main() {
  scanf("%d %d", &n, &m);
  for (int i = 0; i < n; i++) scanf("%s", &s[i]);
  for (int i = 0; i < n; i++)
    for (int j = 0; j < m; j++)
      B1[s[i][j] - 'a'][i][j] = B1[s[i][j] - 'a'][i][j + m] = ANS[i][j] = 1;
  scanf("%d %d", &r, &c);
  for (int i = 0; i < r; i++) scanf("%s", &pt[i]);
  for (int i = 0; i < r; i++)
    for (int j = 0; j < c; j++)
      if (pt[i][j] != '?') {
        for (int k = 0; k < n; k++)
          ANS[k] &= B1[pt[i][j] - 'a'][(i + k) % n] >> (j % m);
      }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) printf(ANS[i][j] ? "1" : "0");
    puts("");
  }
}
