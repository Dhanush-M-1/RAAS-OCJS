#include <bits/stdc++.h>
using namespace std;
pair<int, int> start;
pair<int, int> endd;
int dx[] = {1, 0, -1};
int dy[] = {1, 0, -1};
struct node {
  pair<int, int> p;
  int s;
};
map<pair<int, int>, bool> visi;
int bfs(int x, int y) {
  struct node star;
  star.p = make_pair(x, y);
  star.s = 0;
  visi[star.p] = true;
  queue<struct node> q;
  q.push(star);
  while (q.empty() == false) {
    struct node ay = q.front();
    q.pop();
    if (ay.p == endd) {
      return ay.s;
    }
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        pair<int, int> xx = make_pair(ay.p.first + dx[i], ay.p.second + dy[j]);
        if (visi.count(xx)) {
          if (visi[xx] == false) {
            visi[xx] = true;
            struct node xxx;
            xxx.p = xx;
            xxx.s = ay.s + 1;
            q.push(xxx);
          }
        }
      }
    }
  }
  return -1;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cin >> start.first >> start.second >> endd.first >> endd.second;
  int m;
  cin >> m;
  while (m--) {
    int r;
    int a, b;
    cin >> r >> a >> b;
    for (int i = a; i <= b; i++) {
      pair<int, int> x = make_pair(r, i);
      visi[x] = false;
    }
  }
  cout << bfs(start.first, start.second) << endl;
  return 0;
}
