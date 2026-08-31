#include <bits/stdc++.h>
using namespace std;
const int Maxn = 1000 + 10;
const int INF = 0x7f7f7f7f;
const int MOD = 1000000007;
const double eps = 1e-10;
const double pi = acos(-1.0);
inline int compareTo(double a, double b) {
  return (a > b + eps) ? 1 : ((a + eps < b) ? -1 : 0);
}
int dx[] = {1, -1, 0, 0, 1, 1, -1, -1};
int dy[] = {0, 0, 1, -1, -1, 1, 1, -1};
int main() {
  int n, x[2], y[2], r, a, b;
  set<pair<int, int> > allow;
  ios::sync_with_stdio(0);
  for (int i = 0; i < 2; i++) cin >> x[i] >> y[i];
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> r >> a >> b;
    for (int j = a; j <= b; j++) allow.insert(pair<int, int>(r, j));
  }
  queue<pair<int, int> > que;
  map<pair<int, int>, int> dist;
  que.push(pair<int, int>(x[0], y[0]));
  dist[pair<int, int>(x[0], y[0])] = 0;
  while (!que.empty()) {
    pair<int, int> t = que.front();
    que.pop();
    for (int i = 0; i < 8; i++) {
      pair<int, int> it(t.first + dx[i], t.second + dy[i]);
      if (allow.find(it) != allow.end() && dist.find(it) == dist.end()) {
        que.push(it);
        dist[it] = dist[t] + 1;
      }
    }
  }
  if (dist.find(pair<int, int>(x[1], y[1])) == dist.end())
    printf("-1\n");
  else
    printf("%d\n", dist[pair<int, int>(x[1], y[1])]);
  return 0;
}
