#include <bits/stdc++.h>
using namespace std;
const double PI = 4 * atan(1.0);
void fast_stream() { std::ios_base::sync_with_stdio(0); }
vector<string> field;
const int lt = 2;
const int rt = 0;
const int up = 3;
const int down = 1;
const int dy[] = {-1, 0, 0, 1};
const int dx[] = {0, -1, 1, 0};
int h, w;
int color[101][101];
struct block {
  pair<int, int> ru, rd, lu, ld;
  int cl;
};
block blocks[10000];
void dfs(int x, int y, int cl) {
  color[y][x] = cl;
  if (blocks[cl].lu.first >= y && blocks[cl].lu.second >= x)
    blocks[cl].lu = make_pair(y, x);
  if (blocks[cl].ru.first >= y && blocks[cl].ru.second <= x)
    blocks[cl].ru = make_pair(y, x);
  if (blocks[cl].rd.first <= y && blocks[cl].rd.second <= x)
    blocks[cl].rd = make_pair(y, x);
  if (blocks[cl].ld.first <= y && blocks[cl].ld.second >= x)
    blocks[cl].ld = make_pair(y, x);
  for (int i = 0; i < 4; i++) {
    int ny = y + dy[i];
    int nx = x + dx[i];
    if (ny >= 0 && nx >= 0 && ny < h && nx < w) {
      char c1 = field[y][x];
      char c2 = field[ny][nx];
      if (color[ny][nx] == -1 && field[y][x] == field[ny][nx]) {
        dfs(nx, ny, cl);
      }
    }
  }
}
const int INF = 1000000000;
void solve() {
  int m, n;
  cin >> m >> n;
  string s;
  getline(cin, s);
  for (int i = 0; i < 10000; i++) {
    block &b = blocks[i];
    b.lu.first = INF;
    b.lu.second = INF;
    b.ru.first = INF;
    b.ru.second = -INF;
    b.rd.first = -INF;
    b.rd.second = -INF;
    b.ld.first = -INF;
    b.ld.second = INF;
  }
  for (int i = 0; i < m; i++) {
    getline(cin, s);
    field.push_back(s);
  }
  h = field.size();
  w = field[0].size();
  int num = 0;
  memset(color, -1, sizeof(color));
  for (int i = 0; i < h; i++) {
    for (int j = 0; j < w; j++) {
      if (color[i][j] == -1 && field[i][j] != '0') {
        dfs(j, i, num);
        num++;
      }
    }
  }
  pair<int, int> bp = make_pair(0, 0);
  int cp = lt;
  int dp = rt;
  for (int i = 0; i < n; i++) {
    int nb = color[bp.first][bp.second];
    pair<int, int> nbp;
    if (dp == 0) {
      if (cp == lt) {
        nbp = blocks[nb].ru;
      } else
        nbp = blocks[nb].rd;
      nbp.second++;
    } else if (dp == 1) {
      if (cp == lt) {
        nbp = blocks[nb].rd;
      } else
        nbp = blocks[nb].ld;
      nbp.first++;
    } else if (dp == 2) {
      if (cp == lt) {
        nbp = blocks[nb].ld;
      } else
        nbp = blocks[nb].lu;
      nbp.second--;
    } else if (dp == 3) {
      if (cp == lt) {
        nbp = blocks[nb].lu;
      } else
        nbp = blocks[nb].ru;
      nbp.first--;
    }
    int ny = nbp.first;
    int nx = nbp.second;
    if (!(ny >= 0 && nx >= 0 && ny < h && nx < w) || field[ny][nx] == '0') {
      if (cp == lt) {
        cp = rt;
      } else {
        cp = lt;
        dp++;
        dp %= 4;
      }
    } else {
      bp = nbp;
    }
  }
  int res = field[bp.first][bp.second];
  cout << res - '0' << endl;
}
int main() {
  solve();
  return 0;
}
