#include <bits/stdc++.h>
using namespace std;
inline int getint() {
  int res = 0, fh = 1;
  char ch = getchar();
  while ((ch < '0' || ch > '9') && ch != '-') ch = getchar();
  if (ch == '-') fh = -1, ch = getchar();
  while (ch <= '9' && ch >= '0') res = res * 10 + ch - '0', ch = getchar();
  return res * fh;
}
int n, m, N, M, R, C, len;
int rev[5000001];
struct cp {
  double x, y;
  friend inline cp operator+(cp a, cp b) { return (cp){a.x + b.x, a.y + b.y}; }
  friend inline cp operator-(cp a, cp b) { return (cp){a.x - b.x, a.y - b.y}; }
  friend inline cp operator*(cp a, cp b) {
    return (cp){a.x * b.x - a.y * b.y, a.x * b.y + a.y * b.x};
  }
};
cp x[5000001], y[5000001];
void fft(cp *a, int f) {
  for (int i = 0; i < n; i++)
    if (i < rev[i]) swap(a[i], a[rev[i]]);
  for (int i = 1; i < n; i <<= 1) {
    cp dw = (cp){cos(acos(-1) / i), sin(f * acos(-1) / i)};
    for (int j = 0; j < n; j += i << 1) {
      cp w = (cp){1, 0};
      for (int k = 0; k < i; k++, w = w * dw) {
        cp x = a[j + k], y = a[j + k + i] * w;
        a[j + k] = x + y;
        a[j + k + i] = x - y;
      }
    }
  }
  if (f == -1)
    for (int i = 0; i < n; i++) a[i].x /= n;
}
char a[1001][1001], b[1001][1001];
long long hav[5000001];
int main() {
  N = getint();
  M = getint();
  for (int i = 1; i <= N; i++) scanf("%s", a[i] + 1);
  R = getint();
  C = getint();
  for (int i = 1; i <= R; i++) scanf("%s", b[i] + 1);
  for (int i = 1; i <= N + N; i++)
    for (int j = 1; j <= M + M; j++)
      a[i][j] = a[(i - 1) % N + 1][(j - 1) % M + 1];
  n = 1;
  len = 0;
  while (n <= (M * 2 + C) * (N * 2 + R)) n <<= 1, len++;
  for (int i = 0; i < n; i++)
    rev[i] = (rev[i >> 1] >> 1) | ((i & 1) << (len - 1));
  for (int i = 1; i <= N + N; i++)
    for (int j = 1; j <= M + M; j++)
      x[((i - 1) * (M * 2 + C) + j)] =
          (cp){(double)(1LL * (a[i][j] - 'a' + 1) * (a[i][j] - 'a' + 1)), 0};
  for (int i = 1; i <= R; i++)
    for (int j = 1; j <= C; j++)
      y[((i - 1) * (M * 2 + C) + j)] = (cp){(double)(b[i][j] != '?'), 0};
  reverse(y + 1, y + 1 + R * (M * 2 + C));
  fft(x, 1);
  fft(y, 1);
  for (int i = 0; i < n; i++) x[i] = x[i] * y[i];
  fft(x, -1);
  for (int i = 1; i <= N; i++)
    for (int j = 1; j <= M; j++)
      hav[((i - 1) * (M * 2 + C) + j)] +=
          (long long)(x[((i - 1) * (M * 2 + C) + j) + (M * 2 + C) * R].x + 0.5);
  for (int i = 0; i < n; i++) x[i].x = x[i].y = y[i].x = y[i].y = 0;
  for (int i = 1; i <= N + N; i++)
    for (int j = 1; j <= M + M; j++)
      x[((i - 1) * (M * 2 + C) + j)] = (cp){(double)(a[i][j] - 'a' + 1), 0};
  for (int i = 1; i <= R; i++)
    for (int j = 1; j <= C; j++)
      y[((i - 1) * (M * 2 + C) + j)] =
          (cp){(double)(b[i][j] != '?') * (b[i][j] - 'a' + 1), 0};
  reverse(y + 1, y + 1 + R * (M * 2 + C));
  fft(x, 1);
  fft(y, 1);
  for (int i = 0; i < n; i++) x[i] = x[i] * y[i];
  fft(x, -1);
  for (int i = 1; i <= N; i++)
    for (int j = 1; j <= M; j++)
      hav[((i - 1) * (M * 2 + C) + j)] -=
          2LL *
          (long long)(x[((i - 1) * (M * 2 + C) + j) + (M * 2 + C) * R].x + 0.5);
  for (int i = 0; i < n; i++) x[i].x = x[i].y = y[i].x = y[i].y = 0;
  for (int i = 1; i <= N + N; i++)
    for (int j = 1; j <= M + M; j++)
      x[((i - 1) * (M * 2 + C) + j)] = (cp){1, 0};
  for (int i = 1; i <= R; i++)
    for (int j = 1; j <= C; j++)
      y[((i - 1) * (M * 2 + C) + j)] =
          (cp){(double)(b[i][j] != '?') *
                   (1LL * (b[i][j] - 'a' + 1) * (b[i][j] - 'a' + 1)),
               0};
  reverse(y + 1, y + 1 + R * (M * 2 + C));
  fft(x, 1);
  fft(y, 1);
  for (int i = 0; i < n; i++) x[i] = x[i] * y[i];
  fft(x, -1);
  for (int i = 1; i <= N; i++)
    for (int j = 1; j <= M; j++)
      hav[((i - 1) * (M * 2 + C) + j)] +=
          (long long)(x[((i - 1) * (M * 2 + C) + j) + (M * 2 + C) * R].x + 0.5);
  for (int i = 1; i <= N; i++) {
    for (int j = 1; j <= M; j++) {
      if (!hav[((i - 1) * (M * 2 + C) + j)])
        printf("1");
      else
        printf("0");
    }
    printf("\n");
  }
  return 0;
}
