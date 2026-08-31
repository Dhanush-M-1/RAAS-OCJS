#include <bits/stdc++.h>
using namespace std;
template <typename Arg1>
void __f(const char* name, Arg1&& arg1) {
  cout << name << " : " << arg1 << "\n";
}
template <typename Arg1, typename... Args>
void __f(const char* names, Arg1&& arg1, Args&&... args) {
  const char* comma = strchr(names + 1, ',');
  cout.write(names, comma - names) << " : " << arg1 << " | ";
  __f(comma + 1, args...);
}
int mpow(int base, int exp);
void ipgraph(int n, int m);
void dfs(int u, int par);
const int N = 5000, M = 100005;
vector<long long> g[N];
int a[N];
bool isvalid(pair<long long, long long> A) {
  if (A.first < 1 || A.first > 1000000000) return false;
  if (A.second < 1 || A.second > 1000000000) return false;
  return true;
}
long long dx[] = {1, 0, -1, -1, 1, 0, -1, 1};
long long dy[] = {1, 1, 0, -1, 0, -1, 1, -1};
void solve() {
  long long i, j, n, m, k;
  long long x, y, x1, y1;
  cin >> x >> y >> x1 >> y1;
  map<pair<long long, long long>, bool> make_pair;
  cin >> n;
  for (i = 0; i < n; ++i) {
    long long a, b, r;
    cin >> r >> a >> b;
    for (j = a; j <= b; j++) make_pair[{r, j}] = 1;
  }
  queue<pair<long long, long long> > q;
  q.push({x, y});
  map<pair<long long, long long>, long long> res;
  res[{x, y}] = 0;
  while (!q.empty()) {
    pair<long long, long long> temp = q.front();
    q.pop();
    if (temp.first == x1 && temp.second == y1) {
      cout << res[{temp}] << "\n";
      return;
    }
    for (i = 0; i < 8; i++) {
      pair<long long, long long> temp2;
      temp2.first = temp.first + dx[i];
      temp2.second = temp.second + dy[i];
      if (isvalid(temp2) && make_pair.find({temp2}) != make_pair.end() &&
              res.find({temp2}) == res.end() ||
          res[temp2] > res[temp] + 1) {
        res[{temp2}] = res[{temp}] + 1;
        q.push({temp2});
      }
    }
  }
  cout << -1 << "\n";
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  solve();
}
int mpow(int base, int exp) {
  base %= (int)1e9 + 7;
  int result = 1;
  while (exp > 0) {
    if (exp & 1) result = ((long long)result * base) % (int)1e9 + 7;
    base = ((long long)base * base) % (int)1e9 + 7;
    exp >>= 1;
  }
  return result;
}
void ipgraph(int n, int m) {
  int i, u, v;
  while (m--) {
    cin >> u >> v;
    u--, v--;
    g[u].emplace_back(v);
    g[v].emplace_back(u);
  }
}
void dfs(int u, int par) {
  for (int v : g[u]) {
    if (v == par) continue;
    dfs(v, u);
  }
}
