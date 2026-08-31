#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 5;
const int inf = 0x3f3f3f3f;
const long long INF = 0x7f7f7f7f7f7f7f7f;
const int mod = 1e9 + 7;
const double PI = acos(-1.0);
const double eps = 1e-5;
int n;
pair<long long, long long> a[maxn];
long long b[maxn];
long long s1[maxn], s2[maxn];
int lb(int x) { return x & (-x); }
void add(int x, long long w) {
  for (int i = x; i <= n; i += lb(i)) {
    s1[i]++;
    s2[i] += w;
  }
}
long long sum1(int x) {
  long long res = 0;
  for (int i = x; i >= 1; i -= lb(i)) res += s1[i];
  return res;
}
long long sum2(int x) {
  long long res = 0;
  for (int i = x; i >= 1; i -= lb(i)) res += s2[i];
  return res;
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%lld", &a[i].first);
  }
  for (int i = 1; i <= n; i++) {
    scanf("%lld", &a[i].second);
    b[i] = a[i].second;
  }
  sort(a + 1, a + 1 + n);
  sort(b + 1, b + 1 + n);
  int len = unique(b + 1, b + 1 + n) - (b + 1);
  long long ans = 0;
  for (int i = 1; i <= n; i++) {
    int pos = lower_bound(b + 1, b + 1 + len, a[i].second) - b;
    long long res1 = sum1(pos);
    long long res2 = sum2(pos);
    ans += res1 * a[i].first - res2;
    add(pos, a[i].first);
  }
  printf("%lld", ans);
}
