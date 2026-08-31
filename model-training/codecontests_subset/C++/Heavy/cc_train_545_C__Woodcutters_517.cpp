#include <bits/stdc++.h>
using namespace std;
int location[1000005], height[1000004];
int main() {
  int trees;
  cin >> trees;
  for (int i = 0; i < trees; i++) cin >> location[i] >> height[i];
  if (trees <= 2)
    cout << trees;
  else {
    int ans = 2, flag = 0, m = 0;
    for (int i = 1; i < trees - 1; i++) {
      m = 1;
      if (location[i] - height[i] > location[i - 1]) {
        m = 0;
        ans++;
        if (flag &&
            location[i - 1] + height[i - 1] >= location[i] - height[i]) {
          ans--;
          m = 1;
        }
        flag = 0;
      }
      if (m && location[i] + height[i] < location[i + 1]) {
        flag = 1;
        ans++;
      } else
        flag = 0;
    }
    cout << ans;
  }
  return 0;
}
