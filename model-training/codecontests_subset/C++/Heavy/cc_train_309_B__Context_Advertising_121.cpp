#include <bits/stdc++.h>
using namespace std;
inline int read() {
  int x = 0, f = 1, c = getchar();
  for (; !isdigit(c); c = getchar())
    if (c == '-') f ^= 1;
  for (; isdigit(c); c = getchar()) x = x * 10 + c - '0';
  return f ? x : -x;
}
int n, r, c;
string text;
string s;
int st[1000005];
char tmp[5000005];
int table[1000005][20];
int main() {
  n = read(), r = read(), c = read();
  for (int i = 0; i < (int)(n); ++i) {
    scanf("%s", tmp);
    s = tmp;
    st[i] = text.size();
    text += s + ' ';
  }
  st[n] = text.size();
  for (int i = 0; i < (int)(n); ++i) {
    int lb = 0, rb = n - i;
    while (lb < rb) {
      int md = (lb + rb + 1) >> 1;
      if (st[i + md] - st[i] - 1 <= c)
        lb = md;
      else
        rb = md - 1;
    }
    table[i][0] = lb;
  }
  for (int j = 1; j < 20; ++j) {
    for (int i = 0; i < (int)(n); ++i) {
      table[i][j] = table[i][j - 1] + table[i + table[i][j - 1]][j - 1];
    }
  }
  int ans = 0, ansn = -1;
  for (int i = 0; i < (int)(n); ++i) {
    int cnt = 0;
    int x = i;
    for (int j = 0; j < (int)(20); ++j)
      if (r & 1 << j) {
        cnt += table[x][j];
        x += table[x][j];
      }
    if (cnt > ans) ans = cnt, ansn = i;
  }
  int x = ansn;
  for (int i = 0; i < (int)(r); ++i) {
    if (table[x][0] != 0)
      printf("%s\n",
             text.substr(st[x], st[x + table[x][0]] - st[x] - 1).c_str());
    x += table[x][0];
  }
  return 0;
}
