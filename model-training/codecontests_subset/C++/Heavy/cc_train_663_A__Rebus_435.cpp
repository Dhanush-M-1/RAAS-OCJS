#include <bits/stdc++.h>
using namespace std;
const int N = 1010101;
inline char get(void) {
  static char buf[100000], *S = buf, *T = buf;
  if (S == T) {
    T = (S = buf) + fread(buf, 1, 100000, stdin);
    if (S == T) return EOF;
  }
  return *S++;
}
template <typename T>
inline void read(T &x) {
  static char c;
  x = 0;
  int sgn = 0;
  for (c = get(); c < '0' || c > '9'; c = get())
    if (c == '-') sgn = 1;
  for (; c >= '0' && c <= '9'; c = get()) x = x * 10 + c - '0';
  if (sgn) x = -x;
}
inline char Get(void) {
  static char c;
  for (c = get(); c != '+' && c != '-' && c != '?' && c != '=' && !isdigit(c);
       c = get())
    ;
  return c;
}
int now, n, m, cnt1, cnt2, res, x;
char c;
char opt[N];
int ans[N];
inline void Godie(void) {
  puts("Impossible");
  exit(0);
}
int main(void) {
  cnt1 = 1;
  while (1) {
    c = Get();
    c = Get();
    if (c == '+')
      cnt1++;
    else if (c == '-')
      cnt2++;
    else if (c == '=')
      break;
    opt[++m] = c;
  }
  read(n);
  now = cnt1 - cnt2;
  opt[0] = '+';
  for (int i = 0; i <= m; i++) ans[i] = 1;
  for (int i = 0; i <= m; i++) {
    if (opt[i] == '+') {
      while (now < n && ans[i] < n) {
        now++;
        ans[i]++;
      }
    }
  }
  for (int i = 0; i <= m; i++) {
    if (opt[i] == '-') {
      while (now > n && ans[i] < n) {
        now--;
        ans[i]++;
      }
    }
  }
  if (now != n) Godie();
  puts("Possible");
  printf("%d ", ans[0]);
  for (int i = 1; i <= m; i++) printf("%c %d ", opt[i], ans[i]);
  printf("= %d", n);
  return 0;
}
