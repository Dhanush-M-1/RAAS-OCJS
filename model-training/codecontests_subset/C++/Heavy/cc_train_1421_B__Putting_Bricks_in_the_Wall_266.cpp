#include <bits/stdc++.h>
using namespace std;
void solve() {
  int n;
  cin >> n;
  char arr[n][n];
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) cin >> arr[i][j];
  }
  char temp = arr[0][1];
  vector<pair<int, int>> v;
  if (arr[1][0] != temp) v.push_back({2, 1});
  if (arr[n - 1][n - 2] == temp) v.push_back({n, n - 1});
  if (arr[n - 2][n - 1] == temp) v.push_back({n - 1, n});
  if (v.size() >= 3) {
    v.clear();
    v.push_back({1, 2});
  }
  cout << v.size() << "\n";
  for (auto i : v) cout << i.first << " " << i.second << "\n";
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int t;
  cin >> t;
  while (t--) solve();
}
