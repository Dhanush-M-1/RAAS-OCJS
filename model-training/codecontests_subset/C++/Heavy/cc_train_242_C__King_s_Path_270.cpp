#include <bits/stdc++.h>
using namespace std;
pair<int, int> point;
map<pair<int, int>, int> S, S1;
int X0, Y0, X1, Y1;
int bfs(void) {
  S1.clear();
  queue<pair<int, int> > Q;
  Q.push(make_pair(X0, Y0));
  S[make_pair(X0, Y0)] = 0;
  while (!Q.empty()) {
    int xx = Q.front().first;
    int yy = Q.front().second;
    Q.pop();
    for (int i = (-1); i <= (1); i++)
      for (int j = (-1); j <= (1); j++) {
        if (!i && !j) continue;
        pair<int, int> next = make_pair(xx + i, yy + j);
        if (!S.count(next) || S1.count(next)) continue;
        Q.push(next);
        S1[next] = S1[make_pair(xx, yy)] + 1;
        if (next.first == X1 && next.second == Y1) return S1[next];
      }
  }
  return -1;
}
int main() {
  while (cin >> X0 >> Y0 >> X1 >> Y1) {
    int n;
    cin >> n;
    int r, a, b;
    S.clear();
    for (int i = 0; i < (n); i++) {
      cin >> r >> a >> b;
      for (int i = (a); i <= (b); i++) {
        S[make_pair(r, i)]++;
      }
    }
    printf("%d\n", bfs());
  }
  return 0;
}
