#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 5, INF = 0x3f3f3f3f;
int first[N], h[N];
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) scanf("%d%d", &first[i], &h[i]);
  if (n == 1) {
    puts("1");
    return 0;
  }
  int ans = 2, now = 0;
  for (int i = 2; i < n; i++) {
    now = max(now, first[i - 1]);
    if (first[i] - h[i] > now)
      ans++;
    else if (first[i] + h[i] < first[i + 1]) {
      now = first[i] + h[i];
      ans++;
    }
  }
  printf("%d\n", ans);
  return 0;
}
