#include <bits/stdc++.h>
using namespace std;
long long binpow(long long a, long long n, long long mod) {
  long long ans = 1;
  while (n) {
    if (n & 1) ans = (ans * a) % mod;
    a = (a * a) % mod;
    n >>= 1;
  }
  return ans;
}
long long binpow(long long a, long long n) {
  long long ans = 1;
  while (n) {
    if (n & 1) ans *= a;
    a *= a;
    n >>= 1;
  }
  return ans;
}
vector<long long> pr;
void PrDoX(long long x) {
  if (pr.size() > 0) return;
  vector<long long> p(x + 1);
  for (long long i = 2; i <= x; i++) {
    if (p[i] == 0) {
      pr.push_back(i);
      for (long long j = i + i; j <= x; j += i) p[j] = 1;
    }
  }
}
vector<long long> fact(long long x) {
  PrDoX(sqrt(1e10));
  vector<long long> ans;
  long long i = 0, c = sqrt(x), n = pr.size();
  while (x > 1 and pr[i] <= c and i < n) {
    if (x % pr[i] == 0) {
      x /= pr[i];
      ans.push_back(pr[i]);
      c = sqrt(x);
    } else
      i++;
  }
  if (x != 1) ans.push_back(x);
  return ans;
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  long long n, m, k;
  cin >> n >> m >> k;
  vector<long long> p(n + 1);
  vector<pair<long long, long long> > v;
  vector<vector<long long> > g(n + 1);
  long long ans = 0;
  for (long long i = 0; i < m; i++) {
    long long a, b;
    cin >> a >> b;
    g[a].push_back(b);
    g[b].push_back(a);
    p[a]++;
    p[b]++;
    v.push_back({a, b});
    ans += (p[a] == k) + (p[b] == k);
  }
  queue<long long> q;
  for (long long i = 1; i <= n; i++)
    if (p[i] > 0 and p[i] < k) q.push(i);
  vector<bool> fl(n + 1);
  while (!q.empty()) {
    long long a = q.front();
    q.pop();
    if (fl[a] == 1) continue;
    fl[a] = 1;
    vector<long long> v = g[a];
    long long n = v.size();
    for (long long i = 0; i < n; i++) {
      long long b = v[i];
      if (fl[b] == 1) continue;
      p[b]--;
      if (p[b] == k - 1) ans--, q.push(b);
    }
  }
  vector<long long> an;
  an.push_back(ans);
  for (long long i = 1; i <= n; i++) sort(g[i].begin(), g[i].end());
  for (long long i = m - 1; i > 0; i--) {
    long long a = v[i].first, b = v[i].second;
    if (fl[a] or fl[b] == 1) {
      an.push_back(ans);
      continue;
    }
    p[a]--;
    p[b]--;
    g[a].erase(lower_bound(g[a].begin(), g[a].end(), b));
    g[b].erase(lower_bound(g[b].begin(), g[b].end(), a));
    queue<long long> q;
    bool F = 0;
    if (p[a] == k - 1) q.push(a), ans--;
    if (p[b] == k - 1) q.push(b), ans--;
    while (!q.empty()) {
      long long a0 = q.front();
      q.pop();
      if (fl[a0] == 1) continue;
      fl[a0] = 1;
      vector<long long> v = g[a0];
      long long n = v.size();
      for (long long i = 0; i < n; i++) {
        long long b0 = v[i];
        if ((a0 == a and b0 == b) or (a0 == b and b0 == a)) continue;
        if (fl[b0] == 1) continue;
        p[b0]--;
        if (p[b0] == k - 1) ans--, q.push(b0);
      }
    }
    an.push_back(ans);
  }
  for (long long i = m - 1; i >= 0; i--) cout << an[i] << "\n";
  return 0;
}
