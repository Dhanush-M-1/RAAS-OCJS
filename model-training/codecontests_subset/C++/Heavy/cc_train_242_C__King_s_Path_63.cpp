#include <bits/stdc++.h>
using namespace std;
const int inf = 1000000000;
double Time() { return double(clock()) / double(CLOCKS_PER_SEC); }
int n;
map<pair<int, int>, int> m;
pair<int, int> p0, p1;
int dx[8] = {0, 0, 1, 1, 1, -1, -1, -1};
int dy[8] = {1, -1, -1, 0, 1, 1, 0, -1};
queue<pair<int, int> > q;
int main() {
  cin >> p0.first >> p0.second >> p1.first >> p1.second >> n;
  for (int i = 1; i <= n; i++) {
    int r, a, b;
    cin >> r >> a >> b;
    while (a <= b) {
      m[make_pair(r, a)] = -1;
      a++;
    }
  }
  m[p0] = 0;
  q.push(p0);
  while (!q.empty()) {
    pair<int, int> now = q.front();
    q.pop();
    for (int i = 0; i < 8; i++) {
      pair<int, int> j = make_pair(now.first + dx[i], now.second + dy[i]);
      if (m[j] == -1) {
        m[j] = m[now] + 1;
        q.push(j);
      }
    }
  }
  cout << m[p1];
  return 0;
}
