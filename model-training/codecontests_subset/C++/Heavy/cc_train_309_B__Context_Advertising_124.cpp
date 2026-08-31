#include <bits/stdc++.h>
using namespace std;
const int N = 6000000 + 9;
const int M = 1000000 + 9;
char pat[N];
int n, r, c, sta[M], len[M], trans[M][18], position, vout;
inline int read() {
  char c = getchar();
  int ret = 0, f = 1;
  while (c < '0' || c > '9') {
    if (c == '-') f = -1;
    c = getchar();
  }
  while (c <= '9' && c >= '0') {
    ret = ret * 10 + c - '0';
    c = getchar();
  }
  return ret * f;
}
int main() {
  n = read();
  r = read();
  c = read();
  gets(pat + 1);
  for (int i = 1, tmp = strlen(pat + 1); i <= tmp; i++)
    if (pat[i] == ' ') {
      pat[i] = 0;
    }
  for (int i = 1, w = 0; i <= n; i++) {
    sta[i] = ++w;
    len[i] = strlen(pat + w);
    w += len[i];
  }
  for (int i = 1, tail = 1, tmp = len[1]; i <= n; i++) {
    if (len[i] > c) {
      tail = (i + 1) % (n + 1);
      tmp = len[tail];
    } else {
      while (tail < n && tmp + len[tail + 1] + 1 <= c) {
        tmp += len[++tail] + 1;
      }
      trans[i][0] = tail + 1;
      tmp -= len[i] + (tail > i);
      if (!tmp) {
        tail = (i + 1) % (n + 1);
        tmp = len[tail];
      }
    }
  }
  trans[n][0] = n;
  for (int t = 1; t <= 17; t++) {
    for (int i = 1; i <= n; i++) {
      trans[i][t] = max(trans[i][t - 1], trans[trans[i][t - 1]][t - 1]);
    }
  }
  for (int i = 1, tmp = 0, p = i; i <= n; tmp = 0, p = ++i) {
    for (int j = 17, w = 1 << 17; ~j; j--, w >>= 1)
      if (tmp + w <= r) {
        tmp += w;
        p = max(p, trans[p][j]);
        if (p == n + 1) break;
      }
    if (p - i > vout) {
      vout = p - i;
      position = i;
    }
  }
  if (vout)
    for (int i = 1, beg = position, end; i <= r && beg <= n; i++) {
      end = trans[beg][0] - (beg != n || len[trans[beg][0]] > c);
      if (end < beg) break;
      for (int j = beg; j <= end; j++) {
        printf("%s%c", pat + sta[j], j == end ? '\n' : ' ');
      }
      beg = end + 1;
    }
  return 0;
}
