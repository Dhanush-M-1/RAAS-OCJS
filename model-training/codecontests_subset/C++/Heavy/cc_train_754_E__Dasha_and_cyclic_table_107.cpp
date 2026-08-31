#include <bits/stdc++.h>
using namespace std;
const int INF = 1 << 30, maxn = 400 + 10;
int N, M, r, c;
char A[maxn][maxn], B[maxn][maxn];
bitset<maxn> s[26][maxn], ans[maxn];
bitset<maxn> work(const bitset<maxn> &b, int len, int kk) {
  return (b >> kk) | (b << (len - kk));
}
void Init() {
  scanf("%d%d", &N, &M);
  for (int i = 0; i < N; ++i) {
    scanf("%s", A[i]);
    for (int j = 0; j < M; ++j) s[A[i][j] - 'a'][i][j] = true;
  }
  scanf("%d%d", &r, &c);
  for (int i = 0; i < r; ++i) scanf("%s", B[i]);
}
void Solve() {
  for (int i = 0; i < N; ++i) ans[i] = ~ans[i];
  for (int i = 0; i < r; ++i)
    for (int j = 0; j < c; ++j) {
      if (B[i][j] == '?') continue;
      int C = B[i][j] - 'a', y = j % M;
      for (int k = 0; k < N; ++k) ans[k] &= work(s[C][(k + i) % N], M, y);
    }
  for (int i = 0; i < N; ++i) {
    for (int j = 0; j < M; ++j) putchar(ans[i][j] + '0');
    puts("");
  }
}
int main() {
  Init();
  Solve();
  return 0;
}
