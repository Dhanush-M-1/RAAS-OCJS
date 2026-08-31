#include <bits/stdc++.h>
using namespace std;
int r1, r2, c1, c2, d1, d2;
int main() {
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  vector<int> nums;
  if (r1 + r2 == c1 + c2 && c1 + c2 == d1 + d2) {
    int x = (d1 + r1 - c2);
    int y = (c2 + d2 - r2);
    int w = (d1 + c2 - r1);
    int z = (2 * c1 - d1 - r1 + c2);
    if (x % 2 || y % 2 || z % 2 || w % 2) {
      cout << -1;
      return 0;
    }
    nums.push_back(x / 2);
    nums.push_back(y / 2);
    nums.push_back(z / 2);
    nums.push_back(w / 2);
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        if (i != j && nums[i] == nums[j]) {
          cout << -1;
          return 0;
        }
      }
    }
    for (int i = 0; i < 4; i++) {
      if (nums[i] >= 10 || nums[i] <= 0) {
        cout << -1;
        return 0;
      }
    }
    cout << x / 2 << ' ' << y / 2 << '\n';
    cout << z / 2 << ' ' << w / 2 << '\n';
    return 0;
  }
  cout << -1;
}
