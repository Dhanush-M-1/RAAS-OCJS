#include <bits/stdc++.h>
using namespace std;
const int maxn = (int)2e5 + 100;
const int mod = (int)1e9 + 7;
int n, c[maxn];
long long ans;
pair<int, int> a[maxn];
int main() {
  scanf("%d", &n);
  for (auto i = (1); i <= (n); ++i)
    scanf("%d", &a[i].second), c[i] = a[i].second;
  for (auto i = (1); i <= (n); ++i) scanf("%d", &a[i].first);
  sort(a + 1, a + 1 + n);
  sort(c + 1, c + 1 + n);
  for (auto i = (1); i <= (n); ++i)
    ans += (i - 1 - n + lower_bound(c + 1, c + 1 + n, a[i].second) - c) *
           (long long)a[i].second;
  printf("%lld\n", ans);
}
