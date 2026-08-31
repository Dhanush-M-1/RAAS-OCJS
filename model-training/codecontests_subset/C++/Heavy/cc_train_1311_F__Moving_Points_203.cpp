#include <bits/stdc++.h>
using namespace std;
const long long N = 2e6 + 7;
const long long INF = 1e18;
long long n, k, q, st[N][2];
pair<long long, long long> p[N];
map<long long, bool> m;
bool comp(pair<long long, long long>& a, pair<long long, long long>& b) {
  if (a.second == b.second) return a.first < b.first;
  return a.second < b.second;
}
void compress() {
  long long cnt = 0;
  for (long long i = 1; i <= n; i++) {
    cnt += (m[p[i].second] == 0);
    m[p[i].second] = 1;
    p[i].second = cnt;
  }
}
void update(long long node, long long s, long long e, long long ind,
            long long val, bool type) {
  if (s == e) {
    st[node][type] += val;
  } else {
    long long mid = s + (e - s) / 2;
    if (ind <= mid) {
      update(node * 2, s, mid, ind, val, type);
    } else {
      update(node * 2 + 1, mid + 1, e, ind, val, type);
    }
    st[node][type] = st[node * 2][type] + st[node * 2 + 1][type];
  }
}
long long query(long long node, long long s, long long e, long long l,
                long long r, bool type) {
  if (s >= l && e <= r) {
    return st[node][type];
  }
  if (s > r || e < l) {
    return 0;
  }
  long long mid = s + (e - s) / 2;
  return query(node * 2, s, mid, l, r, type) +
         query(node * 2 + 1, mid + 1, e, l, r, type);
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  cin >> n;
  for (long long i = 1; i <= n; i++) {
    cin >> p[i].first;
  }
  for (long long i = 1; i <= n; i++) {
    cin >> p[i].second;
  }
  sort(p + 1, p + n + 1, comp);
  compress();
  sort(p + 1, p + n + 1);
  long long ans = 0;
  for (long long i = 1; i <= n; i++) {
    ans += p[i].first * query(1, 1, n, 1, p[i].second, 0) -
           query(1, 1, n, 1, p[i].second, 1);
    update(1, 1, n, p[i].second, 1, 0);
    update(1, 1, n, p[i].second, p[i].first, 1);
  }
  cout << ans << endl;
}
