#include <bits/stdc++.h>
using namespace std;
mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
const long long maxn = 1e5 + 10;
const long long mod = 1e9 + 7;
const long double PI = acos((long double)-1);
long long pw(long long a, long long b, long long md = mod) {
  long long res = 1;
  while (b) {
    if (b & 1) {
      res = (a * res) % md;
    }
    a = (a * a) % md;
    b >>= 1;
  }
  return (res);
}
long long n;
long long boz = 0;
struct node {
  long long par;
  vector<long long> ch;
  long long zarib;
  long long val, target;
} m[maxn];
void dfs(long long v) {
  for (auto u : m[v].ch) dfs(u);
  m[v].val -= m[v].target;
  if (v == 1) return;
  if (m[v].val >= 0) {
    m[m[v].par].val += m[v].val;
    return;
  }
  if (1e17 / m[v].zarib < abs(m[v].val)) boz = 1;
  m[m[v].par].val += m[v].zarib * m[v].val;
  if (m[m[v].par].val < -1e17) boz = 1;
}
int32_t main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n;
  for (long long i = 1; i <= n; i++) cin >> m[i].val;
  for (long long i = 1; i <= n; i++) cin >> m[i].target;
  for (long long i = 2; i <= n; i++) {
    cin >> m[i].par;
    cin >> m[i].zarib;
    m[m[i].par].ch.push_back(i);
  }
  dfs(1);
  if (boz) return (cout << "NO", 0);
  ;
  cout << ((m[1].val >= 0) ? "YES" : "NO");
  return (0);
}
