#include <bits/stdc++.h>
using namespace std;
int tryFirstState(vector<vector<char> > &a, int n) {
  int sol = 0;
  vector<vector<int> > ans(5, vector<int>(2, 0));
  if (a[1][0] != '0') {
    ans[sol][0] = 2;
    ans[sol][1] = 1;
    sol++;
  }
  if (a[0][1] != '0') {
    ans[sol][0] = 1;
    ans[sol][1] = 2;
    sol++;
  }
  if (a[n - 1][n - 2] != '1') {
    ans[sol][0] = n;
    ans[sol][1] = n - 1;
    sol++;
  }
  if (a[n - 2][n - 1] != '1') {
    ans[sol][0] = n - 1;
    ans[sol][1] = n;
    sol++;
  }
  if (sol > 2) {
    return 0;
  }
  cout << sol << endl;
  for (int i = 0; i < sol; i++) {
    cout << ans[i][0] << " " << ans[i][1] << endl;
  }
  return 1;
}
int trySecondState(vector<vector<char> > &a, int n) {
  int sol = 0;
  vector<vector<int> > ans(5, vector<int>(2, 0));
  if (a[1][0] != '1') {
    ans[sol][0] = 2;
    ans[sol][1] = 1;
    sol++;
  }
  if (a[0][1] != '1') {
    ans[sol][0] = 1;
    ans[sol][1] = 2;
    sol++;
  }
  if (a[n - 1][n - 2] != '0') {
    ans[sol][0] = n;
    ans[sol][1] = n - 1;
    sol++;
  }
  if (a[n - 2][n - 1] != '0') {
    ans[sol][0] = n - 1;
    ans[sol][1] = n;
    sol++;
  }
  if (sol > 2) {
    return 0;
  }
  cout << sol << endl;
  for (int i = 0; i < sol; i++) {
    cout << ans[i][0] << " " << ans[i][1] << endl;
  }
  return 1;
}
int main() {
  int t;
  cin >> t;
  int n;
  while (t--) {
    cin >> n;
    vector<vector<char> > a(n, vector<char>(n, 0));
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        cin >> a[i][j];
      }
    }
    int result = tryFirstState(a, n);
    if (result) {
      continue;
    }
    trySecondState(a, n);
  }
  return 0;
}
