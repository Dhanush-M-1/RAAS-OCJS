#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n, v, mx = 0, all = 0, check = 0, ans;
  cin >> n;
  vector<int> vec;
  for (int x = 0; x < n; x++) {
    cin >> v;
    all += v;
    vec.push_back(v);
    mx = max(mx, v);
  }
  for (int x = mx; x <= 10001; x++) {
    check = 0;
    for (int y = 0; y < n; y++) {
      check += x - vec[y];
    }
    if (check > all) {
      ans = x;
      break;
    }
  }
  cout << ans << endl;
  return 0;
}
