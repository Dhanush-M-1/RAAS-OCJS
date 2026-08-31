#include <bits/stdc++.h>
using namespace std;
const int INF = 0x3f3f3f3f;
const int MOD = 1e9 + 7;
const int MAXN = 2e2 + 5;
const long long INFLL = 1e18;
int n;
int h[100], a[100];
int main() {
  scanf("%d", &n);
  int ans = 0;
  for (int i = 0; i < n; i++) scanf("%d %d", &h[i], &a[i]);
  for (int i = 0; i < n; i++)
    for (int j = 0; j < n; j++) {
      if (h[i] == a[j]) ans++;
    }
  printf("%d\n", ans);
  return 0;
}
