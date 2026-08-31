#include <bits/stdc++.h>
using namespace std;
int a[1000007];
int b[1000007];
int f[1000007];
bool vist[1000007];
int m, n;
int R, C;
int ans;
string cc;
int main() {
  char ch;
  int i, j, k, p;
  int len;
  scanf("%d%d%d", &n, &R, &C);
  scanf("%c", &ch);
  m = 0;
  j = 0;
  a[0] = -1;
  getline(cin, cc);
  len = cc.length();
  for (i = 0; i < len; ++i) {
    ch = cc[i];
    if (ch == ' ') {
      a[++j] = i;
    }
  }
  a[++j] = i;
  j = 1;
  for (i = 0; i < n; ++i) {
    while (j <= n && a[j] - a[i] - 1 <= C) ++j;
    b[i] = j - 1;
  }
  memset(vist, 0, sizeof(vist));
  memset(f, 128, sizeof(128));
  b[n] = n;
  for (i = 0; i < n; ++i) {
    if (vist[i]) continue;
    k = i;
    for (j = 0; j < R; ++j) {
      if (b[k] == k) break;
      k = b[k];
    }
    j = i;
    while (true) {
      f[j] = k;
      if (vist[j] || j == b[j]) break;
      vist[j] = true;
      j = b[j];
      k = b[k];
    }
  }
  ans = -1;
  for (i = 0; i < n; ++i) {
    if (f[i] < 0) continue;
    if (ans < 0 || f[i] - i > f[ans] - ans) ans = i;
  }
  if (ans < 0) {
    for (i = 0; i < R; ++i) {
      for (j = 0; j < C; ++j) printf(" ");
      printf("\n");
    }
  } else {
    j = ans;
    for (i = 0; i < R; ++i) {
      k = b[j];
      for (p = a[j] + 1; p < a[k]; ++p) printf("%c", cc[p]);
      j = b[j];
      if (i < R - 1) printf("\n");
    }
  }
  return 0;
}
