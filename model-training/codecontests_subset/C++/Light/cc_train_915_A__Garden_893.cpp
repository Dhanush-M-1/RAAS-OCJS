#include <bits/stdc++.h>
using namespace std;
int n, k, ans;
inline int GetInt() {
  int num = 0, k = 1;
  char ch = getchar();
  while (!isdigit(ch)) {
    if (ch == '-') k = -1;
    ch = getchar();
  }
  while (isdigit(ch)) {
    num = num * 10 + ch - '0';
    ch = getchar();
  }
  return num * k;
}
int main() {
  n = GetInt(), k = GetInt();
  ans = k;
  for (int i = 1; i <= n; i++) {
    int x = GetInt();
    if (k % x) continue;
    ans = min(ans, k / x);
  }
  printf("%d", ans);
  return 0;
}
