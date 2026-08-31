#include <bits/stdc++.h>
using namespace std;
int commands[55][55];
bool was[55][55];
int id[55][55];
int color[55 * 56];
pair<int, int> ul[55 * 56], dr[55 * 56];
int edge[55 * 56][8];
pair<int, int> calcUp(pair<int, int> a, pair<int, int> b) {
  pair<int, int> c;
  c.first = min(a.first, b.first);
  c.second = min(a.second, b.second);
  return c;
}
pair<int, int> calcDown(pair<int, int> a, pair<int, int> b) {
  pair<int, int> c;
  c.first = max(a.first, b.first);
  c.second = max(a.second, b.second);
  return c;
}
void dfs(const int i, const int j, const int counter, const int width,
         const int height) {
  if (was[i][j]) return;
  if (commands[i][j] == 0) return;
  was[i][j] = true;
  id[i][j] = counter;
  ul[counter] = calcUp(ul[counter], make_pair(i, j));
  dr[counter] = calcDown(dr[counter], make_pair(i, j));
  color[counter] = commands[i][j];
  for (int dx = -1; dx <= 1; ++dx)
    for (int dy = -1; dy <= 1; ++dy)
      if (dx * dx + dy * dy == 1) {
        int x = i + dx, y = j + dy;
        if (x < 0 || x >= height || y < 0 || y >= width) continue;
        if (commands[i][j] != commands[x][y]) continue;
        dfs(x, y, counter, width, height);
      }
}
int main() {
  int height, N, width;
  cin >> height >> N;
  memset((commands), (0), sizeof(commands));
  for (int _n(height), i(0); i < _n; i++) {
    string s;
    cin >> s;
    width = s.size();
    for (int _n(width), j(0); j < _n; j++)
      commands[i][j] = int(s[j]) - int('0');
  }
  memset((was), (0), sizeof(was));
  memset((color), (0), sizeof(color));
  for (int _n(55 * 56), i(0); i < _n; i++)
    ul[i] = make_pair(1011111111, 1011111111);
  for (int _n(55 * 56), i(0); i < _n; i++) dr[i] = make_pair(-1, -1);
  int counter = 0;
  memset((id), (0), sizeof(id));
  for (int _n(height), i(0); i < _n; i++)
    for (int _n(width), j(0); j < _n; j++)
      if (!was[i][j] && commands[i][j] > 0) {
        counter++;
        dfs(i, j, counter, width, height);
      }
  for (int _n(55 * 56), i(0); i < _n; i++)
    for (int _n(8), k(0); k < _n; k++) edge[i][k] = -1;
  vector<int> mark(counter + 1, 0);
  for (int _n(height), i(0); i < _n; i++)
    for (int _n(width), j(0); j < _n; j++) {
      if (commands[i][j] == 0) continue;
      const int idx = id[i][j];
      if (mark[idx]) continue;
      mark[idx] = 1;
      pair<int, int> links[] = {make_pair(ul[idx].first, dr[idx].second + 1),
                                make_pair(dr[idx].first, dr[idx].second + 1),
                                make_pair(dr[idx].first + 1, dr[idx].second),
                                make_pair(dr[idx].first + 1, ul[idx].second),
                                make_pair(dr[idx].first, ul[idx].second - 1),
                                make_pair(ul[idx].first, ul[idx].second - 1),
                                make_pair(ul[idx].first - 1, ul[idx].second),
                                make_pair(ul[idx].first - 1, dr[idx].second)};
      for (int _n(8), k(0); k < _n; k++) {
        int x = links[k].first, y = links[k].second;
        if (x < 0 || x >= height || y < 0 || y >= width) continue;
        if (commands[x][y] == 0) continue;
        edge[idx][k] = id[x][y];
      }
    }
  int bp = id[0][0];
  int dir = 0;
  for (int _n(N), iter(0); iter < _n; iter++) {
    if (edge[bp][dir] != -1)
      bp = edge[bp][dir];
    else
      dir = (dir + 1) % 8;
  }
  cout << color[bp] << endl;
  return 0;
}
