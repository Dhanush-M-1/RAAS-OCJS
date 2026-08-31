#include <bits/stdc++.h>
using namespace std;
const int inf = 1e9;
const int mo = 1e9 + 7;
const int N = 101010;
vector<int> sx[N], sy[N];
int main() {
  int n;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    int x, y;
    cin >> x >> y;
    sx[x].push_back(y);
    sy[y].push_back(x);
  }
  for (int i = 0; i <= 100000; i++) {
    sort(sx[i].begin(), sx[i].end());
    sort(sy[i].begin(), sy[i].end());
  }
  int ans = 0;
  for (int i = 0; i <= 100000; i++) {
    if (sx[i].size() < 2) continue;
    for (unsigned int j = 0; j < sx[i].size(); j++) {
      int x = i, y = sx[i][j];
      int px = j + 1,
          py = lower_bound(sy[y].begin(), sy[y].end(), x) - sy[y].begin();
      while (px < (int)sx[i].size() && py < (int)sy[y].size()) {
        if (sx[i][px] - y > sy[y][py] - x) {
          py++;
          continue;
        }
        if (sx[i][px] - y < sy[y][py] - x) {
          px++;
          continue;
        }
        int tx = sx[i][px], ty = sy[y][py];
        ans += binary_search(sx[sy[y][py]].begin(), sx[sy[y][py]].end(),
                             sx[x][px]);
        px++;
        py++;
      }
    }
  }
  cout << ans << endl;
  return 0;
}
