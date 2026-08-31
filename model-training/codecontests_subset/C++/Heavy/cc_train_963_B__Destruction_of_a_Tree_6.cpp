#include <bits/stdc++.h>
using namespace std;
template <class A, class B>
ostream& operator<<(ostream& out, const pair<A, B>& a) {
  return out << "(" << a.first << ", " << a.second << ")";
}
template <class A>
ostream& operator<<(ostream& out, const vector<A>& a) {
  out << "[";
  for (auto it = a.begin(); it != a.end(); ++it) {
    if (it != a.begin()) out << ", ";
    out << *it;
  }
  return out << "]";
}
const int INF = 1e9;
const long long INF64 = 1e18;
const int MOD = 1e9 + 7;
const long double PI = acosl(-1.0);
const long double EPS = 1e-9;
mt19937 rnd(time(NULL));
mt19937_64 rnd64(time(NULL));
const int N = 200 * 1000 + 11;
int n;
int root;
int deg[N];
int dep[N];
bool used[N];
vector<int> g[N];
bool read() {
  if (scanf("%d", &n) != 1) return false;
  for (int i = 0; i < int(n); ++i) {
    int p;
    scanf("%d", &p);
    --p;
    if (p != -1) {
      g[i].push_back(p);
      g[p].push_back(i);
      ++deg[i];
      ++deg[p];
    } else {
      root = i;
    }
  }
  return true;
}
void dfs(int v, int p, int curd) {
  dep[v] = curd;
  for (auto to : g[v])
    if (to != p) dfs(to, v, curd + 1);
}
void solve() {
  dfs(root, -1, 0);
  set<pair<int, int> > cur;
  for (int i = 0; i < int(n); ++i)
    if (deg[i] % 2 == 0) cur.insert(make_pair(-dep[i], i));
  vector<int> ans;
  while (!cur.empty()) {
    int v = cur.begin()->second;
    used[v] = true;
    cur.erase(cur.begin());
    ans.push_back(v + 1);
    for (auto to : g[v]) {
      if (used[to]) continue;
      --deg[to];
      if (deg[to] & 1) {
        cur.erase(make_pair(-dep[to], to));
      } else {
        cur.insert(make_pair(-dep[to], to));
      }
    }
  }
  if (int((ans).size()) != n)
    puts("NO");
  else {
    puts("YES");
    for (auto it : ans) printf("%d\n", it);
  }
}
int main() {
  cout << fixed << setprecision(10);
  cerr << fixed << setprecision(10);
  while (read()) {
    solve();
  }
}
