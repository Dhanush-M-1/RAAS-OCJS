#include <bits/stdc++.h>
using namespace std;
const int N = 1e3 + 5, mod = 1e9 + 7, len = 30;
void run_case() {
  int n;
  cin >> n;
  char c[n][n];
  for (int i = 0; i < n; i++)
    for (int j = 0; j < n; j++) cin >> c[i][j];
  vector<pair<int, int>> vec;
  if (c[0][1] == c[1][0]) {
    if (c[n - 1][n - 2] == c[0][1]) vec.push_back({n - 1, n - 2});
    if (c[n - 2][n - 1] == c[0][1]) vec.push_back({n - 2, n - 1});
  } else {
    if (c[0][1] == c[n - 1][n - 2]) vec.push_back({0, 1});
    if (c[1][0] == c[n - 1][n - 2]) vec.push_back({1, 0});
    if (c[n - 1][n - 2] != c[n - 2][n - 1]) vec.push_back({n - 2, n - 1});
  }
  cout << vec.size() << endl;
  for (auto i : vec) cout << i.first + 1 << " " << i.second + 1 << endl;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int t;
  cin >> t;
  while (t--) run_case();
}
