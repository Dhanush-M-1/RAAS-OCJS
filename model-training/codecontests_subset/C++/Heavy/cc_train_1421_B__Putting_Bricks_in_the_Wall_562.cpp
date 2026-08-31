#include <bits/stdc++.h>
using namespace std;
void speed() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(0);
}
int main() {
  long long int t;
  cin >> t;
  while (t--) {
    int n;
    cin >> n;
    char a[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        cin >> a[i][j];
      }
    }
    vector<pair<int, int>> ans;
    char x;
    if (a[0][1] == a[1][0]) {
      x = a[0][1];
      if (x == a[n - 1][n - 2]) {
        ans.push_back(make_pair(n, n - 1));
      }
      if (x == a[n - 2][n - 1]) {
        ans.push_back(make_pair(n - 1, n));
      }
    } else if (a[n - 1][n - 2] == a[n - 2][n - 1]) {
      x = a[n - 1][n - 2];
      if (x == a[0][1]) {
        ans.push_back(make_pair(1, 2));
      }
      if (x == a[1][0]) {
        ans.push_back(make_pair(2, 1));
      }
    } else {
      x = a[0][1];
      ans.push_back(make_pair(2, 1));
      if (x == a[n - 1][n - 2]) {
        ans.push_back(make_pair(n, n - 1));
      }
      if (x == a[n - 2][n - 1]) {
        ans.push_back(make_pair(n - 1, n));
      }
    }
    cout << ans.size() << endl;
    for (int i = 0; i < ans.size(); i++) {
      cout << ans[i].first << " " << ans[i].second << endl;
    }
  }
}
