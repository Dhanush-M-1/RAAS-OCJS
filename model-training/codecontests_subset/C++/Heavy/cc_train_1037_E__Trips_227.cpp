#include <bits/stdc++.h>
using namespace std;
template <typename T>
void maxtt(T& t1, T t2) {
  t1 = max(t1, t2);
}
template <typename T>
void mintt(T& t1, T t2) {
  t1 = min(t1, t2);
}
bool debug = 0;
int n, m, k;
int dx[4] = {0, 1, 0, -1}, dy[4] = {1, 0, -1, 0};
string direc = "RDLU";
long long ln, lk, lm;
void etp(bool f = 0) {
  puts(f ? "YES" : "NO");
  exit(0);
}
void addmod(long long& x, long long y, long long mod = 998244353) {
  assert(y >= 0);
  x += y;
  if (x >= mod) x -= mod;
  assert(x >= 0 && x < mod);
}
void et(int x = -1) {
  printf("%d\n", x);
  exit(0);
}
long long fastPow(long long x, long long y, long long mod = 998244353) {
  long long ans = 1;
  while (y > 0) {
    if (y & 1) ans = (x * ans) % mod;
    x = x * x % mod;
    y >>= 1;
  }
  return ans;
}
long long gcd1(long long x, long long y) { return y ? gcd1(y, x % y) : x; }
vector<pair<int, int> > mp[200105];
int u[200105], v[200105], d[200105], ans[200105];
bool vis[200105], del[200105];
void fmain(int ID) {
  scanf("%d%d%d", &n, &m, &k);
  for (int(i) = 1; (i) <= (int)(m); (i)++) {
    scanf("%d%d", u + i, v + i);
    d[u[i]]++;
    d[v[i]]++;
    mp[u[i]].push_back({v[i], i});
    mp[v[i]].push_back({u[i], i});
  }
  set<pair<int, int> > q;
  for (int(i) = 1; (i) <= (int)(n); (i)++) q.insert({d[i], i});
  int sz = n;
  for (int i = m; i; i--) {
    while (!q.empty() && q.begin()->first < k) {
      int x = q.begin()->second;
      q.erase(q.begin());
      del[x] = 1;
      sz--;
      for (auto cp : mp[x])
        if (!vis[cp.second] && !del[cp.first]) {
          vis[cp.second] = 1;
          int y = cp.first;
          q.erase({d[y], y});
          d[y]--;
          q.insert({d[y], y});
        }
    }
    ans[i] = sz;
    if (vis[i]) continue;
    vis[i] = 1;
    int y = u[i];
    q.erase({d[y], y});
    d[y]--;
    q.insert({d[y], y});
    y = v[i];
    q.erase({d[y], y});
    d[y]--;
    q.insert({d[y], y});
  }
  for (int(i) = 1; (i) <= (int)(m); (i)++) printf("%d\n", ans[i]);
}
int main() {
  int t = 1;
  for (int(i) = 1; (i) <= (int)(t); (i)++) {
    fmain(i);
  }
  return 0;
}
