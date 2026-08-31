#include <bits/stdc++.h>
using namespace std;
const long double PI = 3.141592653589793238462643383;
long long int gcd(long long int a, long long int b) {
  if (a == 0) return b;
  return gcd(b % a, a);
}
long long int Ceil(long long int a, long long int b) {
  if (a % b == 0)
    return a / b;
  else
    return a / b + 1;
}
const int MAX = 400009;
const int MOD = 1e9 + 7;
const int inf = 1e9 + 10;
long long int deg[MAX], vis[MAX], dep[MAX];
vector<long long int> adj[MAX];
void dfs(int i, int d) {
  vis[i] = 1;
  dep[i] = d++;
  for (int j = 0; j < ((int)((adj[i]).size())); ++j) {
    int u = adj[i][j];
    if (!vis[u]) dfs(u, d);
  }
}
priority_queue<pair<long long int, pair<long long int, long long int> > > pq;
set<pair<long long int, pair<long long int, long long int> > > st;
vector<long long int> ans;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n;
  cin >> n;
  for (int i = 0; i < (n); ++i) {
    int p;
    cin >> p;
    p--;
    if (p == -1) continue;
    adj[i].push_back(p), adj[p].push_back(i);
    deg[i]++, deg[p]++;
  }
  dfs(0, 1);
  (memset((vis), 0, sizeof(vis)));
  for (int i = 0; i < (n); ++i)
    if (deg[i] % 2 == 0)
      pq.push((make_pair((dep[i]), ((make_pair((i), (deg[i])))))));
  long long int cnt = 0;
  while (!pq.empty()) {
    pair<long long int, pair<long long int, long long int> > c = pq.top();
    pq.pop();
    if (st.find(c) != st.end()) {
      st.erase(c);
      continue;
    }
    int i = c.second.first;
    vis[i] = 1;
    cnt++;
    ans.push_back(i);
    for (int j = 0; j < ((int)((adj[i]).size())); ++j) {
      int u = adj[i][j];
      if (vis[u]) continue;
      deg[u]--;
      if (deg[u] % 2 == 0)
        pq.push((make_pair((dep[u]), ((make_pair((u), (deg[u])))))));
      else
        st.insert((make_pair((dep[u]), ((make_pair((u), (deg[u] + 1)))))));
    }
  }
  if (cnt == n) {
    cout << "YES\n";
    for (auto&(it) : (ans)) cout << it + 1 << '\n';
  } else
    cout << "NO\n";
  return 0;
}
