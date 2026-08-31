#include <bits/stdc++.h>
using namespace std;
int main() {
  int n = 0;
  cin >> n;
  map<int, int> home_color_count;
  map<int, int> away_color_count;
  map<int, vector<int>> team_to_color;
  for (int i = 0; i < n; i++) {
    int x = 0, y = 0;
    cin >> x >> y;
    team_to_color[i].push_back(x);
    team_to_color[i].push_back(y);
    home_color_count[x] += 1;
    away_color_count[y] += 1;
  }
  int ans = 0;
  for (auto item : team_to_color) {
    int home_color = item.second[0];
    int away_color = item.second[1];
    ans += home_color_count[away_color];
  }
  cout << ans << endl;
}
