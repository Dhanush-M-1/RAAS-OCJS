#include <bits/stdc++.h>
using namespace std;
int n, c, x[112], ans;
int main(int argc, char const *argv[]) {
  scanf("%d %d", &n, &c);
  for (int i = 0; i < n; i++) scanf("%d", &x[i]);
  for (int i = 0; i < n - 1; i++) {
    ans = max(ans, x[i] - x[i + 1] - c);
  }
  printf("%d\n", ans);
  return 0;
}
