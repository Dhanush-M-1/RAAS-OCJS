#include <bits/stdc++.h>
using namespace std;
const int M = 5000005, N = 1000005;
int n, i, w, h, pe, k, j, L, st, erk, b, res, rx, a[N], t[N], d[N];
int as, p[N][23], qa, in, q[N][23];
char c[M];
vector<char> s[N];
vector<int> ma[N];
int main() {
  scanf("%d%d%d", &n, &h, &w);
  w++;
  for (i = 1; i <= n; ++i) {
    c[0] = '\0';
    scanf("%s", c);
    pe = strlen(c);
    for (j = 0; j < pe; ++j) {
      s[i].push_back(c[j]);
    }
    a[i] = pe + 1;
  }
  for (i = 1; i <= n; ++i) {
    d[i] = a[i] + d[i - 1];
  }
  st = 0;
  for (i = 1; i <= n; ++i) {
    while (d[i] - d[st] > w) {
      st++;
    }
    t[i] = st;
  }
  as = 1;
  while (as < n) {
    as = as * 2;
    L++;
  }
  for (i = 1; i <= n; ++i) {
    p[i][0] = t[i];
    q[i][0] = 1;
    if (i == t[i]) q[i][0] = 0;
    for (j = 1; j <= L; ++j) {
      p[i][j] = p[p[i][j - 1]][j - 1];
      q[i][j] = q[i][j - 1] + q[p[i][j - 1]][j - 1];
    }
  }
  res = 0;
  rx = 0;
  for (i = 1; i <= n; ++i) {
    b = i;
    erk = 0;
    for (j = L; j >= 0; --j) {
      if (erk + q[b][j] <= h) {
        erk = erk + q[b][j];
        b = p[b][j];
      }
    }
    if (i - b > res) {
      res = i - b;
      rx = i;
    }
  }
  if (rx != 0) {
    qa = 0;
    for (i = rx;; i = t[i]) {
      if (i == t[i] || qa == h) break;
      qa++;
      for (j = t[i] + 1; j <= i; ++j) {
        ma[qa].push_back(j);
      }
    }
  }
  for (i = qa; i >= 1; --i) {
    in = ma[i][0];
    for (k = 0; k < s[in].size(); ++k) {
      printf("%c", s[in][k]);
    }
    for (j = 1; j < ma[i].size(); ++j) {
      in = ma[i][j];
      printf(" ");
      for (k = 0; k < s[in].size(); ++k) {
        printf("%c", s[in][k]);
      }
    }
    printf("\n");
  }
  return 0;
}
