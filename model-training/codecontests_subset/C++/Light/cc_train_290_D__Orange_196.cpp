#include <bits/stdc++.h>
using namespace std;
const long long mod = 1e9 + 7;
inline int read() {
  int res, ok = 1;
  char ch;
  for (ch = getchar(); ch < '0' || ch > '9'; ch = getchar())
    if (ch == '-') ok = -1;
  res = ch - '0';
  for (ch = getchar(); ch >= '0' && ch <= '9'; ch = getchar())
    res = res * 10 + ch - '0';
  return res * ok;
}
int x, n;
char s[55];
int main() {
  scanf("%s", s + 1);
  x = read();
  n = strlen(s + 1);
  for (int i = 1; i <= n; i++)
    if (s[i] < 'a') s[i] += 'a' - 'A';
  for (int i = 1; i <= n; i++) {
    int t = s[i];
    if (t < x + 97) s[i] -= 'a' - 'A';
  }
  printf("%s", s + 1);
  return 0;
}
