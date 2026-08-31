#include <bits/stdc++.h>
using namespace std;
const int MOD = 1e9 + 7;
const int MAX = 100010;
int dx[] = {0, 0, 1, 1, 1, -1, -1, -1};
int dy[] = {-1, 1, 0, -1, 1, 0, -1, 1};
queue<pair<pair<int, int>, int> > q;
int sx, sy, ex, ey, r, a, b, n;
pair<int, int> target, curpos;
pair<pair<int, int>, int> cur;
map<pair<int, int>, long long int> mmap;
bool vis[1 << 20];
int ind = 1;
int main() {
  ios_base::sync_with_stdio(0);
  scanf("%d", &(sx));
  scanf("%d", &(sy));
  scanf("%d", &(ex));
  scanf("%d", &(ey));
  target = make_pair(ex, ey);
  scanf("%d", &(n));
  for (int i = 0, _n = (n); i < _n; ++i) {
    scanf("%d", &(r));
    scanf("%d", &(a));
    scanf("%d", &(b));
    for (int x = a, _n = (b + 1); x < _n; ++x) {
      if (mmap.find(make_pair(r, x)) == mmap.end()) {
        mmap[make_pair(r, x)] = ind++;
      }
    }
  }
  q.push(make_pair(make_pair(sx, sy), 0));
  int ans = -1;
  while (!q.empty()) {
    cur = q.front();
    q.pop();
    curpos = cur.first;
    vis[mmap[curpos]] = 1;
    if (curpos == target) {
      ans = cur.second;
      break;
    }
    for (int i = 0, _n = (8); i < _n; ++i) {
      pair<int, int> nxt =
          make_pair(curpos.first + dx[i], curpos.second + dy[i]);
      if (mmap[nxt]) {
        if (!vis[mmap[nxt]]) {
          vis[mmap[nxt]] = 1;
          q.push(make_pair(nxt, cur.second + 1));
        }
      }
    }
  }
  cout << ans << endl;
  return 0;
}
