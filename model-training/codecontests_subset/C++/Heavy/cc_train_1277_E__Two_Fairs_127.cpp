#include <bits/stdc++.h>
const long base = 151;
const long long MM = 1ll * 1000000007 * 1000000007;
using namespace std;
int BIT(int i, long long x) { return (x & (1 << i)); }
long long ONBIT(int i, long long x) { return (x | (1 << i)); }
long long OFFBIT(int i, long long x) { return (x & ~(1 << i)); }
long long FLIPBIT(int i, long long x) { return (x ^ (1 << i)); }
long long NUMBIT(long long x) { return __builtin_popcount(x); }
template <class T>
T GCD(T a, T b) {
  T r;
  while (b != 0) {
    r = a % b;
    a = b;
    b = r;
  }
  return a;
}
template <class T>
T LCM(T a, T b) {
  return a / GCD(a, b) * b;
}
long n, m, x, y;
vector<long> a[600005];
long va[600005], vb[600005];
long used[600005];
void read() {
  cin >> n >> m >> x >> y;
  for (long i = 1; i <= n; i++) a[i].clear(), used[i] = 0, va[i] = 0, vb[i] = 0;
  for (long i = 1; i <= m; i++) {
    long u, v;
    cin >> u >> v;
    a[u].push_back(v);
    a[v].push_back(u);
  }
}
bool av[600005];
void DFS(long u, long k) {
  av[u] = true;
  if (k == x && u == y) return;
  if (k == y && u == x) return;
  used[u]++;
  if (k == x) va[u]++;
  if (k == y) vb[u]++;
  for (long i = 0; i < a[u].size(); i++) {
    long v = a[u][i];
    if (av[v] == false) DFS(v, k);
  }
}
void solve() {
  memset(av, 0, sizeof(av));
  DFS(x, x);
  memset(av, 0, sizeof(av));
  DFS(y, y);
  long long da = 0, db = 0;
  for (long i = 1; i <= n; i++) {
    if (used[i] != 2 && va[i] == 1 && i != x) da++;
    if (used[i] != 2 && vb[i] == 1 && i != y) db++;
  }
  cout << da * db << endl;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(NULL);
  cout.tie(NULL);
  long te;
  cin >> te;
  while (te--) {
    read();
    solve();
  }
}
