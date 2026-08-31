#include <bits/stdc++.h>
using namespace std;
class Solution {
  int m, n;
  int grid[52][52] = {0};
  const int dx[4] = {0, -1, 0, 1}, dy[4] = {1, 0, -1, 0};
  bool inside(int x, int y) {
    return x >= 0 and y >= 0 and x < 50 and y < 50 and grid[x][y] > 0;
  }
  map<tuple<pair<int, int>, int, int>, int> vis;
  vector<tuple<pair<int, int>, int, int>> st;

 public:
  void run() {
    cin >> m >> n;
    for (int i = 0; i < m; ++i) {
      string s;
      cin >> s;
      for (int j = 0; j < s.size(); ++j) {
        grid[i][j] = s[j] - '0';
      }
    }
    pair<int, int> BP = {0, 0};
    int DP = 0, CP = 1;
    for (int i = 0; i < n; ++i) {
      int x, y;
      tie(x, y) = BP;
      if (vis.count({{x, y}, DP, CP})) {
        int len = i - vis[{{x, y}, DP, CP}];
        int left = (n - i) % len;
        int j = vis[{{x, y}, DP, CP}] + left;
        tie(x, y) = get<0>(st[j]);
        cout << grid[x][y] << '\n';
        return;
      }
      vis[{{x, y}, DP, CP}] = i;
      st.emplace_back(BP, DP, CP);
      while (inside(x + dx[DP], y + dy[DP]) and
             grid[x + dx[DP]][y + dy[DP]] == grid[x][y]) {
        x += dx[DP], y += dy[DP];
      }
      while (inside(x + dx[CP], y + dy[CP]) and
             grid[x + dx[CP]][y + dy[CP]] == grid[x][y]) {
        x += dx[CP], y += dy[CP];
      }
      if (inside(x + dx[DP], y + dy[DP]) and grid[x + dx[DP]][y + dy[DP]]) {
        x += dx[DP], y += dy[DP];
      } else if (CP == ((1 + DP) & 3)) {
        CP = (2 + CP) & 3;
      } else {
        DP = (3 + DP) & 3;
        CP = (1 + DP) & 3;
      }
      BP = {x, y};
    }
    int x, y;
    tie(x, y) = BP;
    cout << grid[x][y] << '\n';
  }
};
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  Solution().run();
}
