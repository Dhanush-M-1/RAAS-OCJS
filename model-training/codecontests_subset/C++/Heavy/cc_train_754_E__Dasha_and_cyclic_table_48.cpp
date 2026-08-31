#include <bits/stdc++.h>
using namespace std;
const int N = 410;
int n, m, r, c, fail[N << 1], len, h;
bool match[N << 1][N];
char A[N << 1][N << 1], M[N][N];
bitset<N << 1> G[30][N << 1], T;
void Init() {
  scanf("%d%d", &n, &m);
  for (int i = 0; i < n; ++i) scanf("%s", A[i]);
  scanf("%d%d", &r, &c);
  for (int i = 0; i < r; ++i) scanf("%s", M[i]);
  len = m + c;
  h = n + r;
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < len - m; ++j) A[i][j + m] = A[i][j];
  }
  for (int i = n; i < h; ++i)
    for (int j = 0; j < len; ++j) A[i][j] = A[i - n][j];
}
void Getfail(char *A) {
  fail[0] = 0;
  fail[1] = 0;
  int k = 0;
  for (int i = 1; i < c; ++i) {
    while ((A[i] != A[k] && A[k] != '?' && A[i] != '?') && k) k = fail[k];
    if (A[i] == A[k] || A[k] == '?' || A[i] == '?') k++;
    fail[i + 1] = k;
  }
}
void KMP(char *A, char *B, int id) {
  Getfail(B);
  int k = 0;
  for (int i = 0; i < len; ++i) {
    while ((A[i] != B[k] && B[k] != '?') && k) k = fail[k];
    if (A[i] == B[k] || B[k] == '?') k++;
    if (k == c) match[i - c + 1][id] = 1, k = fail[k];
  }
}
void Solve() {
  for (int i = 0; i < h; ++i)
    for (int j = 0; j < len; ++j) {
      G[A[i][j] - 'a'][i].set(j);
      G[26][i].set(j);
    }
  for (int i = 0; i < len; ++i) T.set(i);
  for (int i = 0; i < n; ++i) {
    bitset<N << 1> ans = T;
    for (int x = 0; x < r; ++x)
      for (int y = 0; y < c; ++y) {
        if (M[x][y] == '?') continue;
        ans = ans & (G[(M[x][y] - 'a')][x + i] >> y);
      }
    for (int j = 0; j < m; ++j) printf("%d", ans.test(j));
    putchar('\n');
  }
}
int main() {
  Init();
  Solve();
  return 0;
}
