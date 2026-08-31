#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m, a, b, ans = 0;
  scanf("%d%d%d", &n, &m, &a);
  for (int i = 1; i < n; i++) {
    scanf("%d", &b);
    ans = max(a - b - m, ans);
    a = b;
  }
  printf("%d", ans);
  return 0;
}
