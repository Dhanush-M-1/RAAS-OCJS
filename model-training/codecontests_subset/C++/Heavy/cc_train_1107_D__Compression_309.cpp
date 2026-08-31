#include <bits/stdc++.h>
using namespace std;
char s[1500];
bool S[5205][5205];
int N, sum[5205][5205];
int f(char x) {
  if (x <= '9') return x - '0';
  return x - 'A' + 10;
}
bool p(int x) {
  if (x > N) return 1;
  for (int i = 1; i <= N; i += x) {
    for (int j = 1; j <= N; j += x) {
      int a = i + x - 1, b = j + x - 1;
      int t = sum[a][b] - sum[a][j - 1] - sum[i - 1][b] + sum[i - 1][j - 1];
      if (t != x * x && t) return 1;
    }
  }
  return 0;
}
int main() {
  scanf("%d", &N);
  for (int i = 1; i <= N; ++i) {
    scanf("%s", s + 1);
    for (int j = 1; j <= N; ++j) {
      S[i][j] = (f(s[(j + 3) / 4]) >> ((j + 3) % 4)) & 1;
      if (j % 4 == 0)
        swap(S[i][j], S[i][j - 3]), swap(S[i][j - 1], S[i][j - 2]);
    }
  }
  for (int i = 1; i <= N; ++i) {
    for (int j = 1; j <= N; ++j) {
      sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + S[i][j];
    }
  }
  for (int i = N; i; --i)
    if (N % i == 0 && p(i) == 0) return !printf("%d", i);
  return 0;
}
