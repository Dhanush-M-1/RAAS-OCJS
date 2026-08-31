#include <bits/stdc++.h>
using namespace std;
void solve() {
  int n;
  cin >> n;
  vector<pair<int, int> > arr;
  pair<int, int> tmpp;
  for (int i = 0; i < n; i++) {
    cin >> tmpp.first >> tmpp.second;
    arr.push_back(tmpp);
  }
  if (n == 1) {
    cout << "1" << '\n';
    return;
  }
  int ans = 2;
  int last = arr[0].first;
  int x = 0, h = 0, nx = 0;
  for (int i = 1; i < n - 1; i++) {
    x = arr[i].first;
    h = arr[i].second;
    nx = arr[i + 1].first;
    if (x - last > h)
      ans++, last = x;
    else if (nx - x > h)
      ans++, last = x + h;
    else
      last = x;
  }
  cout << ans << '\n';
}
int main() {
  solve();
  return 0;
}
