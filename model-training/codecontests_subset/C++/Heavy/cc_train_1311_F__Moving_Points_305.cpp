#include <bits/stdc++.h>
using namespace std;
long long n;
pair<long long, long long> p[200005];
long long v[200005];
map<long long, long long> m;
long long f0[200005];
long long f1[200005];
void up0(long long x, long long val) {
  for (long long i = x; i <= 200000; i += i & -i) f0[i] += val;
}
void up1(long long x, long long val) {
  for (long long i = x; i <= 200000; i += i & -i) f1[i] += val;
}
long long get0(long long pos) {
  long long ans = 0;
  for (long long i = pos; i > 0; i -= i & -i) ans += f0[i];
  return ans;
}
long long get1(long long pos) {
  long long ans = 0;
  for (long long i = pos; i > 0; i -= i & -i) ans += f1[i];
  return ans;
}
int32_t main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n;
  for (long long i = 1; i <= n; i++) cin >> p[i].first;
  for (long long i = 1; i <= n; i++) {
    cin >> p[i].second;
    v[i] = p[i].second;
  }
  sort(v + 1, v + 1 + n);
  sort(p + 1, p + 1 + n);
  long long c = 0;
  for (long long i = 1; i <= n; i++) {
    if (m[v[i]] == 0) {
      m[v[i]] = ++c;
    }
  }
  long long ans = 0;
  for (long long i = 1; i <= n; i++) {
    long long x = p[i].first;
    long long sp = p[i].second;
    long long c = get0(m[sp]);
    long long cur = get1(m[sp]);
    ans += x * c - cur;
    up0(m[sp], 1);
    up1(m[sp], x);
  }
  cout << ans;
  return 0;
}
