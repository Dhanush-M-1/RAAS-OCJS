#include <bits/stdc++.h>
using namespace std;
const int BOARD_SIZE = 1e9;
template <typename T, typename MAX = int>
struct dynamic_fenwick_tree {
 private:
  unordered_map<MAX, T> a;
  MAX n;

 public:
  dynamic_fenwick_tree() {
    a.clear();
    n = BOARD_SIZE;
  }
  void initialize(MAX k) {
    n = k;
    a.clear();
  }
  void update(MAX pos, T val) {
    for (; pos <= n; pos += pos & (-pos)) a[pos] += val;
  }
  T query(MAX pos) {
    T ans = 0;
    for (; pos >= 1; pos -= pos & (-pos)) ans += a[pos];
    return ans;
  }
};
int x0, iuadoghasdgj, x1, taklahgjkla;
unordered_map<int, dynamic_fenwick_tree<int> > it;
unordered_map<int, unordered_map<int, int> > used;
unordered_map<int, unordered_map<int, int> > dist;
int n;
queue<pair<int, int> > q;
bool allowed(int r, int c) {
  if (r < 1 || r > BOARD_SIZE || c < 1 || c > BOARD_SIZE) return false;
  if (it.find(r) == it.end()) return false;
  return (it[r].query(c) > 0);
}
void bfs(int r, int c) {
  int p, t, i, j;
  q.push(make_pair(r, c));
  used[r][c] = true;
  dist[r][c] = 0;
  while (!q.empty()) {
    i = q.front().first;
    j = q.front().second;
    q.pop();
    p = i + 1;
    t = j;
    if (allowed(p, t))
      if (!used[p][t]) {
        used[p][t] = true;
        dist[p][t] = dist[i][j] + 1;
        q.push(make_pair(p, t));
      }
    p = i - 1;
    t = j;
    if (allowed(p, t))
      if (!used[p][t]) {
        used[p][t] = true;
        dist[p][t] = dist[i][j] + 1;
        q.push(make_pair(p, t));
      }
    p = i;
    t = j + 1;
    if (allowed(p, t))
      if (!used[p][t]) {
        used[p][t] = true;
        dist[p][t] = dist[i][j] + 1;
        q.push(make_pair(p, t));
      }
    p = i;
    t = j - 1;
    if (allowed(p, t))
      if (!used[p][t]) {
        used[p][t] = true;
        dist[p][t] = dist[i][j] + 1;
        q.push(make_pair(p, t));
      }
    p = i + 1;
    t = j + 1;
    if (allowed(p, t))
      if (!used[p][t]) {
        used[p][t] = true;
        dist[p][t] = dist[i][j] + 1;
        q.push(make_pair(p, t));
      }
    p = i + 1;
    t = j - 1;
    if (allowed(p, t))
      if (!used[p][t]) {
        used[p][t] = true;
        dist[p][t] = dist[i][j] + 1;
        q.push(make_pair(p, t));
      }
    p = i - 1;
    t = j + 1;
    if (allowed(p, t))
      if (!used[p][t]) {
        used[p][t] = true;
        dist[p][t] = dist[i][j] + 1;
        q.push(make_pair(p, t));
      }
    p = i - 1;
    t = j - 1;
    if (allowed(p, t))
      if (!used[p][t]) {
        used[p][t] = true;
        dist[p][t] = dist[i][j] + 1;
        q.push(make_pair(p, t));
      }
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int i, r, x, y;
  scanf("%d %d %d %d", &x0, &iuadoghasdgj, &x1, &taklahgjkla);
  scanf("%d", &n);
  for (i = 1; i <= n; i++) {
    scanf("%d %d %d", &r, &x, &y);
    it[r].update(x, 1);
    it[r].update(y + 1, -1);
  }
  bfs(x0, iuadoghasdgj);
  if (!used[x1][taklahgjkla])
    printf("-1\n");
  else
    printf("%d\n", dist[x1][taklahgjkla]);
  return 0;
}
