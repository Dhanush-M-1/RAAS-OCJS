#include <bits/stdc++.h>
using namespace std;
const int SZ = 400;
int main() {
  int N, M;
  scanf("%d %d", &N, &M);
  vector<array<bitset<SZ>, 26>> positions(N);
  vector<bitset<SZ>> ans(N);
  for (auto &x : ans) x.set();
  for (int i = 0; i < N; i++)
    for (int j = 0; j < M; j++) {
      char c;
      scanf(" %c", &c);
      positions[i][c - 'a'].set(j);
    }
  int R, C;
  scanf("%d %d", &R, &C);
  for (int i = 0; i < R; i++)
    for (int j = 0; j < C; j++) {
      char c;
      scanf(" %c", &c);
      if (c == '?') continue;
      for (int row = 0; row < N; row++) {
        const auto &tmp = positions[row][c - 'a'];
        ans[((row - i) % N + N) % N] &=
            (tmp >> (j % M)) | (tmp << (M - (j % M)));
      }
    }
  for (auto &x : ans) {
    for (int j = 0; j < M; j++) printf("%c", x.test(j) ? '1' : '0');
    printf("\n");
  }
  return 0;
}
