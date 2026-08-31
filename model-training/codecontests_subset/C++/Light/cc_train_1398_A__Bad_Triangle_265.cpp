#include <bits/stdc++.h>
using namespace std;
int main() {
  int t, n, val;
  vector<int> v;
  cin >> t;
  for (int i = 0; i < t; i++) {
    cin >> n;
    for (int j = 0; j < n; j++) {
      cin >> val;
      v.push_back(val);
    }
    if (v[0] + v[1] > v[n - 1]) {
      cout << -1 << endl;
    } else {
      cout << "1 "
           << "2 " << n << endl;
    }
    v.clear();
  }
  return 0;
}
