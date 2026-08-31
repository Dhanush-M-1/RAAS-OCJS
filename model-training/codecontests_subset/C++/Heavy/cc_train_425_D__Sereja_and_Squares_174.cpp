#include <bits/stdc++.h>
using namespace std;
const int S = 1e5 + 1;
int n;
vector<pair<int, int> > arr;
vector<int> atx[S], aty[S];
int stx[S], sty[S];
bool exists(int x, int y) {
  int lo = 0, hi = n, mid;
  while (lo < hi) {
    mid = (lo + hi) / 2;
    if (arr[mid].first <= x && (arr[mid].first < x || arr[mid].second < y))
      lo = mid + 1;
    else
      hi = mid;
  }
  if (arr[lo].first == x && arr[lo].second == y) return true;
  return false;
}
int main() {
  ios_base::sync_with_stdio(false);
  for (int i = 0; i < S; ++i) stx[i] = sty[i] = 1;
  cin >> n;
  arr.resize(n);
  for (int i = 0; i < n; ++i) {
    cin >> arr[i].first >> arr[i].second;
    atx[arr[i].first].push_back(arr[i].second);
    aty[arr[i].second].push_back(arr[i].first);
  }
  sort(arr.begin(), arr.end());
  for (int i = 0; i < S; ++i) {
    sort(atx[i].begin(), atx[i].end());
    sort(aty[i].begin(), aty[i].end());
  }
  int ans = 0;
  for (int i = 0; i < n; ++i) {
    int x = arr[i].first, y = arr[i].second;
    int q = min(atx[x].size() - stx[x], aty[y].size() - sty[y]);
    int ix = stx[x], iy = sty[y];
    while (ix < atx[x].size() && iy < aty[y].size()) {
      if (atx[x][ix] - y < aty[y][iy] - x)
        ix++;
      else if (atx[x][ix] - y > aty[y][iy] - x)
        iy++;
      else {
        if (exists(aty[y][iy], atx[x][ix])) {
          ans++;
        }
        ix++;
        iy++;
      }
    }
    stx[x]++;
    sty[y]++;
  }
  cout << ans << '\n';
}
