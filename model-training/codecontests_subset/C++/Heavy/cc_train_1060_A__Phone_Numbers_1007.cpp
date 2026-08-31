#include <bits/stdc++.h>
#pragma GCC optimize(2)
using namespace std;
const int inf = 0x3f3f3f3f;
string s;
int len;
int fac[101];
inline char nc() {
  static char buf[100000], *p1 = buf, *p2 = buf;
  if (p1 == p2) {
    p2 = (p1 = buf) + fread(buf, 1, 100000, stdin);
    if (p1 == p2) return EOF;
  }
  return *p1++;
}
inline void read(int &x) {
  char c = getchar();
  int b = 1;
  for (; c < '0' || c > '9'; c = getchar())
    if (c == '-') b = -1;
  for (x = 0; c >= '0' && c <= '9'; x = x * 10 + c - '0', c = getchar())
    ;
  x = x * b;
}
inline void read(long long &x) {
  char c = getchar();
  int b = 1;
  for (; c < '0' || c > '9'; c = getchar())
    if (c == '-') b = -1;
  for (x = 0; c >= '0' && c <= '9'; x = x * 10 + c - '0', c = getchar())
    ;
  x = x * b;
}
int main(int argc, char *argv[]) {
  int flag = 0, sum = 0;
  read(len);
  cin >> s;
  for (int i = (0); i <= (len - 1); i++) {
    if (s[i] == '8') flag = 1, sum++;
  }
  if (!flag || len <= 10) {
    printf("0\n");
    return 0;
  }
  for (int i = (sum); i >= (1); i--)
    if (i + i * 10 <= len) {
      printf("%d\n", i);
      return 0;
    }
  return 0;
}
