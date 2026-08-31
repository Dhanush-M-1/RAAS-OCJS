#include <bits/stdc++.h>
using namespace std;
template <typename T>
using minpq = priority_queue<T, vector<T>, greater<T>>;
template <typename T>
using maxpq = priority_queue<T, vector<T>, less<T>>;
template <typename T1, typename T2>
struct pair_hash {
  size_t operator()(const pair<T1, T2> &p) const {
    return 31 * hash<T1>{}(p.first) + hash<T2>{}(p.second);
  }
};
int N, dep[200005], deg[200005], root;
bool done[200005];
unordered_set<int> adj[200005];
vector<int> ord;
set<pair<int, int>, greater<pair<int, int>>> even;
void dfs(int v, int prev, int d) {
  dep[v] = d;
  for (int w : adj[v])
    if (w != prev) dfs(w, v, d + 1);
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> N;
  int p;
  for (auto i = (1); i < (N + 1); i++) {
    deg[i] = 0;
    done[i] = false;
  }
  for (auto i = (1); i < (N + 1); i++) {
    cin >> p;
    if (p == 0)
      root = i;
    else {
      adj[p].insert(i);
      adj[i].insert(p);
      deg[p]++;
      deg[i]++;
    }
  }
  dfs(root, -1, 0);
  for (auto i = (1); i < (N + 1); i++)
    if (deg[i] % 2 == 0) even.insert({dep[i], i});
  while (!even.empty()) {
    int v = even.begin()->second;
    even.erase(even.begin());
    ord.push_back(v);
    done[v] = true;
    for (int w : adj[v]) {
      if (--deg[w] % 2 == 0)
        even.insert({dep[w], w});
      else
        even.erase({dep[w], w});
      adj[w].erase(v);
    }
    adj[v].clear();
  }
  for (auto i = (1); i < (N + 1); i++) {
    if (!done[i]) {
      cout << "NO" << '\n';
      return 0;
    }
  }
  cout << "YES" << '\n';
  for (int v : ord) cout << v << '\n';
  return 0;
}
