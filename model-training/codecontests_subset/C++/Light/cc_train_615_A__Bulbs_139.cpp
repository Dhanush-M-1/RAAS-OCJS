#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m;
  cin >> n >> m;
  vector<int> arr(m, 0);
  while (n--) {
    int k;
    cin >> k;
    vector<int> ys(k);
    for (auto &y : ys) {
      cin >> y;
      arr[y - 1]++;
    }
  }
  for (auto &x : arr) {
    if (x <= 0) {
      cout << "NO" << endl;
      return 0;
    }
  }
  cout << "YES" << endl;
  return 0;
}
