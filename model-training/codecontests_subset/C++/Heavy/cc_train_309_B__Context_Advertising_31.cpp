#include <bits/stdc++.h>
using namespace std;
void _fill_int(int* p, int val, int rep) {
  int i;
  for (i = 0; i < rep; i++) p[i] = val;
}
int GETi() {
  int i;
  scanf("%d", &i);
  return i;
}
template <class T>
T sqr(T val) {
  return val * val;
}
int N, R, C;
int I[1000010], W[1000010];
int MW[23][1000010];
char S[7000010];
void solve() {
  int f, r, i, j, k, l, x, y, tx, ty, aa[5];
  cin >> N >> R >> C;
  C++;
  j = 0;
  for (i = 0; i < N; i++) {
    string s;
    cin >> s;
    I[i] = j;
    W[i] = 1 + s.size();
    strcpy(S + j, s.c_str());
    j += W[i];
  }
  int tl, tw = -1;
  for (i = 0; i < N; i++) {
    if (tw <= i) {
      if (W[i] > C) {
        MW[0][i] = i;
        continue;
      }
      tw = i + 1;
      tl = W[i];
    }
    while (tw < N && tl + W[tw] <= C) tl += W[tw++];
    MW[0][i] = tw;
    tl -= W[i];
  }
  MW[0][N] = N;
  for (i = 0; i < 21; i++)
    for (x = 0; x < N + 1; x++) MW[i + 1][x] = MW[i][MW[i][x]];
  int ma = 0, id = -1;
  for (x = 0; x < N + 1; x++) {
    y = x;
    for (i = 20; i >= 0; i--)
      if (R & (1 << i)) y = MW[i][y];
    if (y - x > ma) ma = y - x, id = x;
  }
  if (ma == 0) return;
  for (x = id, r = 0; x < id + ma && r < R;) {
    y = 0;
    while (x < id + ma && y + W[x] <= C) {
      if (y != 0) printf(" ");
      printf("%s", S + I[x]);
      y += W[x];
      x++;
    }
    if (y == 0) break;
    r++;
    printf("\n");
  }
  return;
}
int main(int argc, char** argv) {
  if (argc > 1) freopen(argv[1], "r", stdin);
  solve();
  return 0;
}
