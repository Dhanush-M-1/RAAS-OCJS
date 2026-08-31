#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t) {
    int n;
    cin >> n;
    vector<int> vec;
    int flag = 1;
    for (int j = 0; j < n; j++) {
      int x;
      cin >> x;
      vec.push_back(x);
    }
    for (int i = 2; i < n; i++) {
      if (vec[0] + vec[1] <= vec[i]) {
        flag = 0;
        cout << 1 << " " << 2 << " " << i + 1 << "\n";
        break;
      }
    }
    if (flag) cout << -1 << "\n";
    t--;
  }
  return 0;
}
