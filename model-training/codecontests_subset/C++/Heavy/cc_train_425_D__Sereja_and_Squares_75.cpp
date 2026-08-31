#include <bits/stdc++.h>
using namespace std;
vector<int> row[105000];
vector<int> col[105000];
vector<pair<int, int> > pt;
int n;
int findIndex(vector<int> &v, int k) {
  int s = 0, e = v.size() - 1;
  while (s <= e) {
    int mid = (s + e) / 2;
    if (v[mid] == k) return mid;
    if (v[mid] < k)
      s = mid + 1;
    else
      e = mid - 1;
  }
  while (true)
    ;
}
bool found(int x, int y) {
  int s = 0, e = pt.size() - 1;
  pair<int, int> toFind = make_pair(x, y);
  while (s <= e) {
    int mid = (s + e) / 2;
    if (toFind == pt[mid]) return true;
    if (toFind < pt[mid])
      e = mid - 1;
    else
      s = mid + 1;
  }
  return false;
}
int main() {
  scanf("%d", &n);
  for (int i = 0; i < n; ++i) {
    int x, y;
    scanf("%d %d", &x, &y);
    row[x].push_back(y);
    col[y].push_back(x);
    pt.push_back(make_pair(x, y));
  }
  for (int i = 0; i <= 100000; ++i) {
    if (row[i].size()) sort(row[i].begin(), row[i].end());
    if (col[i].size())
      ;
    sort(col[i].begin(), col[i].end());
  }
  sort(pt.begin(), pt.end());
  int ans = 0;
  for (int i = 0; i < n; ++i) {
    pair<int, int> cur = pt[i];
    int indexY = findIndex(col[cur.second], cur.first);
    int indexX = findIndex(row[cur.first], cur.second);
    indexX++;
    indexY++;
    while (indexX < row[cur.first].size() && indexY < col[cur.second].size()) {
      if (row[cur.first][indexX] - cur.second ==
          col[cur.second][indexY] - cur.first) {
        if (found(col[cur.second][indexY], row[cur.first][indexX])) ans++;
        indexX++;
        indexY++;
      } else if (row[cur.first][indexX] - cur.second <
                 col[cur.second][indexY] - cur.first)
        indexX++;
      else
        indexY++;
    }
  }
  printf("%d\n", ans);
}
