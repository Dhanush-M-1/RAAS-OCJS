#include <bits/stdc++.h>
using namespace std;
char a[100005], b[100005];
int main() {
  int n;
  scanf("%d", &n);
  int ans = 0, x;
  for (int i = 1; i <= n; ++i) {
    scanf("%d", &x);
    ans = max(ans, min(x - 1, 1000000 - x));
  }
  printf("%d\n", ans);
}
