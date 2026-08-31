#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a, b, c;
  scanf("%d%d%d%d", &n, &a, &b, &c);
  int cnt = 0;
  for (int i = (0); i <= (a); ++i) {
    for (int j = (0); j <= (b); ++j) {
      if ((2 * n - i - 2 * j) % 4 == 0 && (2 * n - i - 2 * j) / 4 <= c &&
          (2 * n - i - 2 * j) >= 0)
        ++cnt;
    }
  }
  printf("%d\n", cnt);
  return 0;
}
