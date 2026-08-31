#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
#pragma GCC target("avx,avx2,fma")
#pragma GCC optimization("unroll-loops")
using namespace std;
char mat[201][201];
void solve() {
  int n;
  cin >> n;
  for (int i = 0; i < n; i++)
    for (int j = 0; j < n; j++) cin >> mat[i][j];
  int a = mat[0][1] - '0';
  int b = mat[1][0] - '0';
  int c = mat[n - 1][n - 2] - '0';
  int d = mat[n - 2][n - 1] - '0';
  int cnt = 0;
  vector<pair<int, int>> ans;
  if (a == b) {
    if (c == a) {
      cnt++;
      ans.push_back({n - 1, n - 2});
    }
    if (d == a) {
      cnt++;
      ans.push_back({n - 2, n - 1});
    }
  } else {
    int cnt0 = 0, cnt1 = 0;
    if (a == 0)
      cnt0++;
    else
      cnt1++;
    if (b == 0)
      cnt0++;
    else
      cnt1++;
    if (c == 0)
      cnt0++;
    else
      cnt1++;
    if (d == 0)
      cnt0++;
    else
      cnt1++;
    if (cnt0 == cnt1) {
      if (a == 0) {
        cnt++;
        ans.push_back({1, 0});
      } else {
        cnt++;
        ans.push_back({0, 1});
      }
      if (c == 1) {
        cnt++;
        ans.push_back({n - 2, n - 1});
      } else {
        cnt++;
        ans.push_back({n - 1, n - 2});
      }
    } else {
      if (cnt0 == 1) {
        if (a == 0) {
          cnt++;
          ans.push_back({1, 0});
        } else {
          cnt++;
          ans.push_back({0, 1});
        }
      } else {
        if (a == 1) {
          cnt++;
          ans.push_back({1, 0});
        } else {
          cnt++;
          ans.push_back({0, 1});
        }
      }
    }
  }
  cout << cnt << "\n";
  for (auto x : ans) cout << x.first + 1 << " " << x.second + 1 << "\n";
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int t = 1;
  cin >> t;
  while (t--) solve();
  return 0;
}
