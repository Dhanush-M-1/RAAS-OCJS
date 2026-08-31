#include <bits/stdc++.h>
using namespace std;
template <typename T>
inline void read(T &x) {
  T data = 0, f = 1;
  char ch = getchar();
  while (!isdigit(ch)) {
    if (ch == '-') f = -1;
    ch = getchar();
  }
  while (isdigit(ch)) {
    data = (data << 3) + (data << 1) + ch - '0';
    ch = getchar();
  }
  x = f * data;
}
template <typename T, typename... Args>
inline void read(T &t, Args &...args) {
  read(t);
  read(args...);
}
const int inf = 0x3f3f3f3f;
const double eps = 1e-8;
const int maxn = 1e5 + 9;
char maze[209][209];
signed main() {
  int T;
  scanf("%d", &T);
  while (T--) {
    int n;
    scanf("%d", &n);
    for (int i = 1; i <= n; ++i) {
      scanf("%s", maze[i] + 1);
    }
    if (maze[1][2] == maze[2][1] && maze[n][n - 1] == maze[n - 1][n]) {
      if (maze[1][2] == maze[n][n - 1])
        printf("2\n1 2\n2 1\n");
      else
        printf("0\n");
    } else if (maze[1][2] == maze[2][1]) {
      if (maze[1][2] == maze[n][n - 1])
        printf("1\n%d %d\n", n, n - 1);
      else
        printf("1\n%d %d\n", n - 1, n);
    } else if (maze[n][n - 1] == maze[n - 1][n]) {
      if (maze[1][2] == maze[n][n - 1])
        printf("1\n1 2\n");
      else
        printf("1\n2 1\n");
    } else {
      printf("2\n2 1\n");
      if (maze[1][2] == maze[n][n - 1])
        printf("%d %d\n", n, n - 1);
      else
        printf("%d %d\n", n - 1, n);
    }
  }
  return 0;
}
