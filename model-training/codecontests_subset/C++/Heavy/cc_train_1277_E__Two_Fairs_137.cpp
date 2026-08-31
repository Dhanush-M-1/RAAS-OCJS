#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
using namespace std;
const double PI = acos(-1);
const long long MOD = 1000000007;
template <class T>
inline bool chmax(T &a, T b) {
  if (a < b) {
    a = b;
    return true;
  }
  return false;
}
template <class T>
inline bool chmin(T &a, T b) {
  if (a > b) {
    a = b;
    return true;
  }
  return false;
}
using Graph = vector<vector<int>>;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  int Q;
  cin >> Q;
  for (int q = 0; q < (int)(Q); q++) {
    int N, M, a, b;
    cin >> N >> M >> a >> b;
    a--;
    b--;
    Graph G(N);
    for (int i = 0; i < (int)(M); i++) {
      int x, y;
      cin >> x >> y;
      x--;
      y--;
      G[x].emplace_back(y);
      G[y].emplace_back(x);
    }
    vector<bool> check(N, false);
    check[a] = true;
    queue<int> que;
    que.emplace(b);
    while (!que.empty()) {
      int v = que.front();
      que.pop();
      check[v] = true;
      for (auto nv : G[v]) {
        if (check[nv]) continue;
        que.emplace(nv);
      }
    }
    long long c1 = 0;
    for (int i = 0; i < (int)(N); i++)
      if (!check[i]) c1++;
    fill((check).begin(), (check).end(), false);
    check[b] = true;
    que.emplace(a);
    while (!que.empty()) {
      int v = que.front();
      que.pop();
      check[v] = true;
      for (auto nv : G[v]) {
        if (check[nv]) continue;
        que.emplace(nv);
      }
    }
    long long c2 = 0;
    for (int i = 0; i < (int)(N); i++)
      if (!check[i]) c2++;
    cout << c1 * c2 << endl;
  }
}
