#include <bits/stdc++.h>
using namespace std;
const int NUM = 400 + 10;
int n, m;
char table[NUM][NUM];
int r, c;
char pattern[NUM][NUM];
bitset<(NUM * 2) * (NUM * 2)> bs[26], ans;
int N, M;
void output() {
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < m; ++j) {
      putchar(ans[i * M + j] + '0');
    }
    putchar('\n');
  }
}
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 0; i < n; ++i) {
    scanf("%s", table[i]);
  }
  scanf("%d%d", &r, &c);
  for (int i = 0; i < r; ++i) {
    scanf("%s", pattern[i]);
  }
  ans.set();
  N = r + n;
  M = c + m;
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < m; ++j) {
      int a = table[i][j] - 'a';
      for (int x = i; x < N; x += n)
        for (int y = j; y < M; y += m) bs[a].set(x * M + y);
    }
  }
  for (int i = 0; i < r; ++i) {
    for (int j = 0; j < c; ++j) {
      if (pattern[i][j] == '?') continue;
      int a = pattern[i][j] - 'a';
      ans &= bs[a] >> (i * M + j);
    }
  }
  output();
  return 0;
}
