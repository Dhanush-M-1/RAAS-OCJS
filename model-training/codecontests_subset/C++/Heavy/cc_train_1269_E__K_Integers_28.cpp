#include <bits/stdc++.h>
using namespace std;
const int maxd = 4e5 + 10;
long long t1[maxd], t2[maxd], pos[maxd], a[maxd], n;
void add(long long* t, long long x, long long v) {
  for (; x < maxd; x += (x & -x)) t[x] += v;
}
long long query(long long* t, long long x) {
  long long ans = 0;
  for (; x; x -= (x & -x)) ans += t[x];
  return ans;
}
int solve(long long* t, int v) {
  int i = 0;
  for (int j = 19; j >= 0; j--)
    if ((i | 1 << j) < maxd)
      if (t[i | (1 << j)] <= v) v -= t[i |= (1 << j)];
  return i;
}
int main() {
  scanf("%lld", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%lld", &a[i]);
    pos[a[i]] = i;
  }
  long long ans = 0ll;
  for (int i = 1; i <= n; i++) {
    int p = pos[i];
    add(t1, p, 1);
    ans += i - query(t1, p);
    add(t2, p, p);
    int mid = solve(t1, i / 2) + 1;
    long long sum = 0;
    long long aa = i / 2;
    long long bb = i - i / 2 - 1;
    sum += (long long)aa * mid - aa * (aa + 1) / 2 - query(t2, mid - 1);
    sum += (query(t2, maxd - 1) - query(t2, mid)) - (long long)bb * mid -
           1ll * bb * (bb + 1) / 2;
    printf("%lld ", sum + ans);
  }
  return 0;
}
