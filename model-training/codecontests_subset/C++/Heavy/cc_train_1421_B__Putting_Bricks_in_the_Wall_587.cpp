#include <bits/stdc++.h>
using namespace std;
const int INF = 0x3f3f3f3f;
const double Pi = acos(-1);
namespace {
template <typename T>
inline void read(T &x) {
  x = 0;
  T f = 1;
  char s = getchar();
  for (; !isdigit(s); s = getchar())
    if (s == '-') f = -1;
  for (; isdigit(s); s = getchar()) x = (x << 3) + (x << 1) + (s ^ 48);
  x *= f;
}
}  // namespace
const int N = 205;
char s[N][N];
int main() {
  int t;
  read(t);
  while (t--) {
    int n;
    read(n);
    for (int i = 1; i <= n; i++) {
      scanf("%s", s[i] + 1);
    }
    if (s[1][2] == s[2][1]) {
      if (s[n][n - 1] == s[n - 1][n] && s[1][2] != s[n][n - 1])
        puts("0");
      else if (s[n][n - 1] == s[n - 1][n]) {
        printf("2\n%d %d\n%d %d\n", n, n - 1, n - 1, n);
      } else {
        printf("1\n");
        if (s[1][2] == s[n][n - 1]) {
          printf("%d %d\n", n, n - 1);
        } else
          printf("%d %d\n", n - 1, n);
      }
    } else {
      if (s[n][n - 1] != s[n - 1][n]) {
        printf("2\n");
        if (s[1][2] == s[n][n - 1])
          printf("1 2\n%d %d\n", n - 1, n);
        else
          printf("1 2\n%d %d\n", n, n - 1);
      } else {
        printf("1\n");
        if (s[1][2] == s[n][n - 1])
          printf("1 2\n");
        else
          printf("2 1\n");
      }
    }
  }
}
