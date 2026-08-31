#include <bits/stdc++.h>
using namespace std;
unordered_set<long long> pos;
long long conv(int r, int c) { return r * 1000000000ll + c; }
queue<pair<pair<int, int>, int>> q;
unordered_map<long long, bool> inq;
void chk(int r, int c, int lvl) {
  if (pos.count(conv(r, c)) > 0 && !inq[conv(r, c)])
    q.push({{r, c}, lvl + 1}), inq[conv(r, c)] = true;
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int x0, y0, x1, y1, n;
  scanf("%d%d%d%d%d", &x0, &y0, &x1, &y1, &n);
  x0--, y0--, x1--, y1--;
  for (int i = 0; i < n; i++) {
    int r, a, b;
    scanf("%d%d%d", &r, &a, &b);
    r--, a--, b--;
    for (int j = a; j <= b; j++) pos.insert(conv(r, j));
  }
  q.push({{x0, y0}, 0});
  while (!q.empty()) {
    pair<int, int> cur = q.front().first;
    int lvl = q.front().second;
    q.pop();
    inq[conv(cur.first, cur.second)] = false;
    if (cur.first == x1 && cur.second == y1) {
      printf("%d\n", lvl);
      return 0;
    }
    if (pos.count(conv(cur.first, cur.second)) == 0) continue;
    pos.erase(conv(cur.first, cur.second));
    chk(cur.first + 1, cur.second, lvl);
    chk(cur.first - 1, cur.second, lvl);
    chk(cur.first, cur.second + 1, lvl);
    chk(cur.first, cur.second - 1, lvl);
    chk(cur.first - 1, cur.second - 1, lvl);
    chk(cur.first - 1, cur.second + 1, lvl);
    chk(cur.first + 1, cur.second - 1, lvl);
    chk(cur.first + 1, cur.second + 1, lvl);
  }
  printf("-1\n");
}
