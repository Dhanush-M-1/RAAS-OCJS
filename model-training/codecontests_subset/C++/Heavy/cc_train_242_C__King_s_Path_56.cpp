#include <bits/stdc++.h>
using namespace std;
long long x, y, x2, y2;
map<long long, pair<long long, long long> > v;
set<pair<long long, long long> > st;
map<pair<long long, long long>, long long> m;
map<pair<long long, long long>, long long> dist;
long long xx[8] = {1, 1, 1, 0, -1, -1, -1, 0},
          yy[8] = {-1, 0, 1, 1, 1, 0, -1, -1};
long long f = 0;
void bfs() {
  queue<pair<long long, long long> > q;
  dist[make_pair(x, y)] = 0;
  q.push(make_pair(x, y));
  while (!q.empty()) {
    pair<long long, long long> p = q.front();
    q.pop();
    for (int i = 0; i < 8; i++) {
      long long l = p.first + xx[i], k = p.second + yy[i];
      if (!m[make_pair(l, k)] && st.count(make_pair(l, k))) {
        if (l == x2 && k == y2) {
          f = 1;
        }
        m[make_pair(l, k)] = 1;
        q.push(make_pair(l, k));
        dist[make_pair(l, k)] = dist[p] + 1;
      }
    }
  }
}
int main() {
  cin >> x >> y >> x2 >> y2;
  long long n;
  cin >> n;
  long long cnt = 0;
  for (int i = 0; i < n; i++) {
    long long r, a, b;
    cin >> r >> a >> b;
    for (int j = a; j <= b; j++) {
      st.insert(make_pair(r, j));
    }
  }
  bfs();
  if (f) {
    cout << dist[make_pair(x2, y2)] << endl;
  } else
    cout << -1 << endl;
  return 0;
}
