#include <bits/stdc++.h>
using namespace std;
const long long mod = 1e9 + 7;
const long long INF = 4e18 + 10;
long long power(long long a, long long b, long long in_mod) {
  long long ans = 1;
  long long prod = a;
  while (b) {
    if (b % 2) ans = (ans * prod) % in_mod;
    prod = (prod * prod) % in_mod;
    b /= 2;
  }
  return ans;
}
long long mod_inv(long long q, long long in_mod) {
  return power(q, in_mod - 2, in_mod);
}
long long gcd(long long a, long long b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
long long fact(long long n, long long in_mod) {
  long long f = 1;
  for (long long i = 1; i <= n; i++) f = (f * i) % in_mod;
  return f;
}
long long ncr(long long n, long long r, long long in_mod) {
  return (((fact(n, in_mod) * mod_inv(fact(r, in_mod), in_mod)) % in_mod) *
          mod_inv(fact(n - r, in_mod), in_mod)) %
         in_mod;
}
long long A[200005] = {};
long long tree[4 * 200005] = {};
long long cnt[4 * 200005] = {};
void update(long long node, long long start, long long end, long long idx,
            long long val) {
  if (start == end) {
    A[idx] += val;
    tree[node] += val;
    cnt[node] += 1;
  } else {
    long long mid = (start + end) / 2;
    if (start <= idx and idx <= mid) {
      update(2 * node, start, mid, idx, val);
    } else {
      update(2 * node + 1, mid + 1, end, idx, val);
    }
    tree[node] = tree[2 * node] + tree[2 * node + 1];
    cnt[node] = cnt[2 * node] + cnt[2 * node + 1];
  }
}
long long query1(long long node, long long start, long long end, long long l,
                 long long r) {
  if (r < start or end < l) {
    return 0;
  }
  if (l <= start and end <= r) {
    return tree[node];
  }
  long long mid = (start + end) / 2;
  long long p1 = query1(2 * node, start, mid, l, r);
  long long p2 = query1(2 * node + 1, mid + 1, end, l, r);
  return (p1 + p2);
}
long long query2(long long node, long long start, long long end, long long l,
                 long long r) {
  if (r < start or end < l) {
    return 0;
  }
  if (l <= start and end <= r) {
    return cnt[node];
  }
  long long mid = (start + end) / 2;
  long long p1 = query2(2 * node, start, mid, l, r);
  long long p2 = query2(2 * node + 1, mid + 1, end, l, r);
  return (p1 + p2);
}
void solve() {
  long long n;
  cin >> n;
  map<long long, long long> mp;
  vector<long long> dis(n);
  vector<pair<long long, long long> > v(n);
  for (long long i = 0; i < n; i++) {
    cin >> v[i].second;
    dis[i] = v[i].second;
  }
  for (long long i = 0; i < n; i++) cin >> v[i].first;
  sort((v).begin(), (v).end());
  sort((dis).begin(), (dis).end());
  for (long long i = 0; i < n; i++) mp[dis[i]] = i;
  update(1, 0, 200005 - 1, mp[v[0].second], v[0].second);
  long long ans = 0;
  for (long long i = 1; i < n; i++) {
    long long _sum = query1(1, 0, 200005 - 1, 0, mp[v[i].second]);
    long long _cnt = query2(1, 0, 200005 - 1, 0, mp[v[i].second]);
    ans += _cnt * (v[i].second) - _sum;
    update(1, 0, 200005 - 1, mp[v[i].second], v[i].second);
  }
  cout << ans << '\n';
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  cout << fixed << setprecision(10);
  auto clk = clock();
  mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
  long long t = 1;
  for (long long test = 1; test <= t; test++) {
    solve();
  }
  clk = clock() - clk;
  cerr << fixed << setprecision(6)
       << "Time: " << ((long double)clk) / CLOCKS_PER_SEC << "\n";
  return 0;
}
