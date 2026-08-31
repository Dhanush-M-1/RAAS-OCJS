#include <bits/stdc++.h>
using namespace std;
const int maxn = 100 + 10;
int n, k;
int a, ans = 10000;
int main() {
  scanf("%d%d", &n, &k);
  for (int i = 0; i < n; i++) {
    scanf("%d", &a);
    if (k % a == 0) ans = min(k / a, ans);
  }
  printf("%d\n", ans);
  return 0;
}
