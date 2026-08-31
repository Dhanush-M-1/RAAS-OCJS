#include <bits/stdc++.h>
using namespace std;
const int MAXN = 405;
char G[405][405], P[405][405];
bitset<MAXN> nolet[405][27];
int main() {
  int N, M;
  scanf("%d%d", &N, &M);
  for (int i = 0; i < N; ++i) {
    scanf("%s", G[i]);
    for (int c = 0; c < 26; ++c)
      for (int j = 0; j < M; ++j)
        if (G[i][j] - 'a' != c) nolet[i][c].set(j);
  }
  int R, C;
  scanf("%d%d", &R, &C);
  for (int i = 0; i < R; ++i) {
    scanf("%s", P[i]);
  }
  for (int i = 0; i < N; ++i) {
    bitset<MAXN> no;
    for (int r = 0; r < R; ++r)
      for (int c = 0; c < C; ++c) {
        if (P[r][c] == '?') continue;
        int ii = (i + r) % N;
        auto b = nolet[ii][P[r][c] - 'a'];
        no |= (b >> c) | (b << (M - c));
      }
    for (int j = 0; j < M; ++j) printf("%d", !no[j]);
    printf("\n");
  }
}
