#include <bits/stdc++.h>
using namespace std;
int main() {
  int trees;
  cin >> trees;
  int ans = 0;
  int x, y;
  vector<int> height;
  vector<int> location;
  for (int i = 0; i < trees; i++) {
    cin >> x >> y;
    location.push_back(x);
    height.push_back(y);
  }
  int it = 0;
  for (int i = 0; i < trees; i++) {
    if (i == 0) {
      it = location[i];
      ans++;
    } else if (i == trees - 1) {
      ans++;
    } else if (location[i] - it > height[i]) {
      it = location[i];
      ans++;
    } else if (location[i + 1] - location[i] > height[i]) {
      it = location[i] + height[i];
      ans++;
    } else {
      it = location[i];
    }
  }
  cout << ans;
}
