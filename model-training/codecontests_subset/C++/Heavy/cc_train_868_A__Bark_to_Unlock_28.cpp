#include <bits/stdc++.h>
using namespace std;
template <typename T>
void read(T& x) {
  x = 0;
  char c;
  int sign = 1;
  do {
    c = getchar();
    if (c == '-') sign = -1;
  } while (c < '0' || c > '9');
  do {
    x = x * 10 + c - '0';
    c = getchar();
  } while (c <= '9' && c >= '0');
  x *= sign;
}
string s, a[103];
int n;
int main() {
  cin >> s;
  read(n);
  for (register int i = 1; i <= n; ++i) cin >> a[i];
  for (register int i = 1; i <= n; ++i)
    if (s == a[i]) return puts("YES"), 0;
  for (register int i = 1; i <= n; ++i)
    for (register int j = 1; j <= n; ++j)
      if (a[i][1] == s[0] && a[j][0] == s[1]) return puts("YES"), 0;
  return puts("NO"), 0;
}
