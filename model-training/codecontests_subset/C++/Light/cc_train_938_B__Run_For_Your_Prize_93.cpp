#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e5 + 10;
int a[maxn];
int main() {
  int n;
  cin >> n;
  int ans = 0;
  for (int i = 0; i < n; i++) {
    scanf("%d", &a[i]);
    ans = max(ans, min(a[i] - 1, 1000000 - a[i]));
  }
  printf("%d\n", ans);
  return 0;
}
