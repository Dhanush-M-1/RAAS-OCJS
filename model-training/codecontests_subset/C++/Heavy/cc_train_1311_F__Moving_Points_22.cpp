#include <bits/stdc++.h>
using namespace std;
const long long inf = 1e9;
long long f[200005], ans, bit[200005], s[200005];
map<long long, long long> m;
long long t, n;
pair<long long, long long> a[200005];
long long get(long long first, long long second) {
  long long re = 0, cnt = 0;
  for (long long i = second; i > 0; i -= (i & (-i))) {
    cnt += bit[i];
    re += s[i];
  }
  return first * cnt - re;
}
void update(long long first, long long second) {
  for (long long i = second; i <= n; i += (i & (-i))) {
    bit[i]++;
    s[i] += first;
  }
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin >> n;
  for (long long i = 1; i <= n; i++) cin >> a[i].first;
  for (long long i = 1; i <= n; i++) cin >> a[i].second, m[a[i].second] = 0;
  long long k = 1;
  for (map<long long, long long>::iterator it = m.begin(); it != m.end();
       it++, k++)
    it->second = k;
  sort(a + 1, a + n + 1);
  for (long long i = 1; i <= n; i++) a[i].second = m[a[i].second];
  for (long long i = 1; i <= n; i++) {
    ans += get(a[i].first, a[i].second);
    update(a[i].first, a[i].second);
  }
  cout << ans << endl;
  return 0;
}
