#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c, x[105], m = 0;
  x[0] = 0;
  scanf("%d%d", &n, &c);
  for (int i = 1; i <= n; ++i) {
    scanf("%d", &x[i]);
    m = max(m, x[i - 1] - x[i]);
  }
  printf("%d", max(0, m - c));
}
