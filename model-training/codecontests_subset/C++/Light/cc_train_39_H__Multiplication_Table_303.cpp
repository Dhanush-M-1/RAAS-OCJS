#include <bits/stdc++.h>
using namespace std;
inline int read() {
  long long s = 0;
  bool w = 1;
  char ch = getchar();
  while (ch < '0' || ch > '9') {
    if (ch == '-') w = -1;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') s = s * 10 + ch - '0', ch = getchar();
  return s * w;
}
int n;
int zh(int a) {
  int x = 0, y = 0, z[1005] = {0};
  while (a > 0) {
    z[++y] = a % n;
    a /= n;
  }
  for (int i = y; i >= 1; i--) x = x * 10 + z[i];
  return x;
}
int main() {
  n = read();
  for (int i = 1; i < n; i++) {
    for (int j = 1; j < n; j++) printf("%d ", zh(i * j));
    printf("\n");
  }
  return 0;
}
