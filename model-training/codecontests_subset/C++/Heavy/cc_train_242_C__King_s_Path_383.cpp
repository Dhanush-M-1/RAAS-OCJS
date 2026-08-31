#include <bits/stdc++.h>
using namespace std;
int cm[] = {-1, 1, -1, 1, 0, -1, 0, 1};
int rm[] = {-1, 1, 1, -1, -1, 0, 1, 0};
int main() {
  int x0, y0, x1, y1;
  cin >> x0 >> y0 >> x1 >> y1;
  int n;
  cin >> n;
  map<pair<int, int>, int> m;
  for (int i = 0; i < n; i++) {
    int r, a, b;
    cin >> r >> a >> b;
    for (int j = a; j <= b; j++) {
      m[{r, j}] = -1;
    }
  }
  queue<pair<int, int>> q;
  m[{x0, y0}] = 0;
  q.push({x0, y0});
  while (not q.empty()) {
    auto p = q.front();
    q.pop();
    for (int i = 0; i < 8; i++) {
      pair<int, int> np = {p.first + rm[i], p.second + cm[i]};
      if (m.count(np) != 0 && m[np] == -1) {
        m[np] = m[p] + 1;
        q.push(np);
      }
    }
  }
  cout << m[{x1, y1}] << endl;
}
