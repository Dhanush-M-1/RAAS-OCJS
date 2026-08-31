#include <bits/stdc++.h>
const int inf = (1 << 30);
const int mod = 1000000007;
using ll = long long;
using namespace std;
const int bound = 200010;
int n, z, cnt;
vector<int> graph[bound];
bool bscht[bound];
void init(int ziel) {
  for (int i = 0; i < n; ++i) bscht[i] = false;
  cnt = 1;
  z = ziel;
  bscht[z] = true;
}
void del() {
  for (int i = 0; i < n; ++i) {
    auto &v = graph[i];
    v.erase(v.begin(), v.end());
  }
}
void dfs(int jetzt) {
  bscht[jetzt] = true;
  ++cnt;
  for (auto next : graph[jetzt]) {
    if (!bscht[next]) dfs(next);
  }
}
int main() {
  int t;
  cin >> t;
  while (t--) {
    int m, a, b;
    cin >> n >> m >> a >> b;
    --a;
    --b;
    del();
    while (m--) {
      int x, y;
      cin >> x >> y;
      --x;
      --y;
      graph[x].push_back(y);
      graph[y].push_back(x);
    }
    init(b);
    dfs(a);
    ll x = n - cnt;
    init(a);
    dfs(b);
    ll y = n - cnt;
    cout << x * y << endl;
  }
}
