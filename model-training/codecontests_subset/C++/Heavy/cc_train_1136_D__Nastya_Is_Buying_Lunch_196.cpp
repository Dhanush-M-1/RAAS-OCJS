#include <bits/stdc++.h>
using namespace std;
namespace std {
template <>
struct hash<pair<int, int>> {
  size_t operator()(const pair<int, int> &x) const {
    long long P = 38923, Q = 109797901;
    return (size_t)((x.first * P + x.second) % Q);
  }
};
};  // namespace std
template <class T>
using pqg = priority_queue<T, vector<T>, greater<T>>;
template <typename T>
void print(T t) {
  cout << t << endl;
}
template <typename T, typename... Args>
void print(T t, Args... args) {
  cout << t << " ";
  print(args...);
}
const int MAXN = 300005;
int n, m, p[MAXN], u, v;
vector<set<int>> g(MAXN, set<int>());
set<int> blockers;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cin >> n >> m;
  for (int i = min((int)0, (int)n); i < max((int)0, (int)n); i += 1) {
    cin >> p[i];
    p[i]--;
  }
  for (int i = min((int)0, (int)m); i < max((int)0, (int)m); i += 1) {
    cin >> u >> v;
    u--;
    v--;
    g[u].emplace(v);
  }
  blockers.emplace(p[n - 1]);
  int c = 0;
  for (int i = n - 1; i >= 0; i--) {
    int u = p[i];
    bool pos = true;
    if ((int)(g[u]).size() < (int)(blockers).size()) pos = false;
    if (pos) {
      for (auto &v : blockers) {
        if (g[u].find(v) == g[u].end()) {
          pos = false;
          break;
        }
      }
    }
    if (pos) {
      c++;
    } else {
      blockers.emplace(u);
    }
  }
  cout << c << endl;
  return 0;
}
