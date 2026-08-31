#include <bits/stdc++.h>
using namespace std;
constexpr int INF = 1e9 + 5;
constexpr long long INFL = 1e18;
const int maxn = 200005;
int n, root;
vector<int> graf[maxn];
vector<int> skier[maxn];
int par[maxn], degin[maxn], degout[maxn];
void spierpapier() {
  cout << "NO\n";
  exit(0);
}
void dfs(int a) {
  for (int& v : graf[a]) dfs(v);
  if (degout[a] & 1) {
    if (a == root) spierpapier();
    degout[a]++;
    skier[a].push_back(par[a]);
    degin[par[a]]++;
  } else if (a != root) {
    degin[a]++;
    skier[par[a]].push_back(a);
    degout[par[a]]++;
  }
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin >> n;
  for (int i = 1; i <= n; i++) {
    int p;
    cin >> p;
    if (p) {
      graf[p].push_back(i);
      par[i] = p;
    } else
      root = i;
  }
  dfs(root);
  cout << "YES\n";
  queue<int> q;
  for (int i = 1; i <= n; i++) {
    if (degin[i] == 0) q.push(i);
  }
  while (!q.empty()) {
    int w = q.front();
    q.pop();
    cout << w << "\n";
    for (int& v : skier[w]) {
      if (--degin[v] == 0) q.push(v);
    }
  }
  return 0;
}
