#include <bits/stdc++.h>
using namespace std;
vector<int> L[100010];
int n;
int x0, y00, x1, y11;
bool used[100010];
int d[100010];
int F[100010], C[100010];
queue<int> Q;
map<pair<int, int>, int> m;
int dx[8] = {1, 1, 0, -1, -1, -1, 0, 1};
int dy[8] = {0, 1, 1, 1, 0, -1, -1, -1};
void bfs(int source) {
  Q.push(source);
  used[source] = true;
  while (!Q.empty()) {
    int u = Q.front();
    Q.pop();
    for (int i = 0; i < 8; ++i) {
      int xo = F[u] + dx[i];
      int yo = C[u] + dy[i];
      pair<int, int> p;
      p.first = xo;
      p.second = yo;
      int to = m[p];
      if (used[to] || m[p] == 0) continue;
      used[to] = true;
      Q.push(to);
      d[to] = d[u] + 1;
    }
  }
}
int buscd(int r, int a, int b) {
  if (a == b) return a;
  int mid = (a + b) / 2;
  pair<int, int> p;
  p.first = r;
  p.second = mid;
  if (m[p] == 0)
    return buscd(r, a, mid);
  else
    return buscd(r, mid + 1, b);
}
int busci(int r, int a, int b) {
  if (a == b) return a;
  int mid = (a + b + 1) / 2;
  pair<int, int> p;
  p.first = r;
  p.second = mid;
  if (m[p] == 0)
    return buscd(r, mid, b);
  else
    return buscd(r, a, mid - 1);
}
int main() {
  memset(used, false, sizeof(used));
  memset(d, -1, sizeof(d));
  cin >> x0 >> y00 >> x1 >> y11;
  int pos1, pos2;
  cin >> n;
  int ct = 1;
  for (int i = 0; i < n; i++) {
    int r, a, b;
    cin >> r >> a >> b;
    int x = a, y = b;
    pair<int, int> p1, p2;
    p1.first = r;
    p1.second = a;
    p2.first = r;
    p2.second = b;
    if (m[p1] != 0 && m[p2] == 0) x = buscd(r, a, b);
    if (m[p1] == 0 && m[p2] != 0) y = busci(r, a, b);
    if (m[p1] == 0 || m[p2] == 0) {
      for (int j = x; j <= y; j++) {
        pair<int, int> p;
        p.first = r;
        p.second = j;
        m[p] = ct;
        F[ct] = r;
        C[ct] = j;
        if (r == x0 && j == y00) pos1 = ct;
        if (r == x1 && j == y11) pos2 = ct;
        ct++;
      }
    }
  }
  bfs(pos1);
  if (pos1 == pos2)
    cout << "0" << endl;
  else {
    if (d[pos2] == -1)
      cout << d[pos2] << endl;
    else
      cout << d[pos2] + 1 << endl;
  }
}
