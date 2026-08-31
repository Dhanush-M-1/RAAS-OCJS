#include <bits/stdc++.h>
using namespace std;
const int n = 1e5 + 500;
int dx[]{0, 1, 0, -1, -1, 1, 1, -1};
int dy[]{1, 0, -1, 0, 1, 1, -1, -1};
int Q;
int Xs, Ys, Xe, Ye;
map<pair<int, int>, bool> ava, visit;
int main() {
  scanf("%d %d %d %d %d", &Xs, &Ys, &Xe, &Ye, &Q);
  while (Q--) {
    int row, l, r;
    scanf("%d %d %d", &row, &l, &r);
    for (int i = l; i <= r; i++) {
      ava[{row, i}] = 1;
    }
  }
  queue<pair<pair<int, int>, int> > q;
  q.push({{Xs, Ys}, 0});
  while (!q.empty()) {
    int x = q.front().first.first;
    int y = q.front().first.second;
    int dist = q.front().second;
    if (x == Xe && y == Ye) {
      printf("%d\n", dist);
      return 0;
    }
    q.pop();
    if (visit[{x, y}]) continue;
    visit[{x, y}] = 1;
    for (int d = 0; d < 8; d++) {
      if (ava[{x + dx[d], y + dy[d]}])
        q.push({{x + dx[d], y + dy[d]}, dist + 1});
    }
  }
  puts("-1");
}
