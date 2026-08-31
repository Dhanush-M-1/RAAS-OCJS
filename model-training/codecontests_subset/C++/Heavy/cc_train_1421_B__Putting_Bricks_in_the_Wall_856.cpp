#include <bits/stdc++.h>
using namespace std;
const int nax = 203;
char a[nax][nax];
void run_case() {
  int n;
  cin >> n;
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < n; ++j) {
      cin >> a[i][j];
    }
  }
  vector<pair<int, int>> ans;
  if (a[n - 1][n - 2] != '1') {
    ans.push_back({n, n - 1});
  }
  if (a[n - 2][n - 1] != '1') {
    ans.push_back({n - 1, n});
  }
  if (a[0][1] != '0') {
    ans.push_back({1, 2});
  }
  if (a[1][0] != '0') {
    ans.push_back({2, 1});
  }
  if (ans.size() <= 2) {
    cout << ans.size() << "\n";
    for (auto& x : ans) {
      cout << x.first << " " << x.second << "\n";
    }
  } else {
    ans.clear();
    if (a[n - 1][n - 2] != '0') {
      ans.push_back({n, n - 1});
    }
    if (a[n - 2][n - 1] != '0') {
      ans.push_back({n - 1, n});
    }
    if (a[0][1] != '1') {
      ans.push_back({1, 2});
    }
    if (a[1][0] != '1') {
      ans.push_back({2, 1});
    }
    cout << ans.size() << "\n";
    for (auto& x : ans) {
      cout << x.first << " " << x.second << "\n";
    }
  }
}
int main() {
  using namespace std;
  ios ::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int T;
  cin >> T;
  for (; T--;) {
    run_case();
  }
}
