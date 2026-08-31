#include <bits/stdc++.h>
using namespace std;
int main() {
  cin.sync_with_stdio(0);
  cin.tie(0);
  int n;
  cin >> n;
  int ans[3];
  int m;
  for (int i = 0; i < 3; i++) {
    ans[i] = 0;
    for (int j = 0; j < n - i; j++) {
      cin >> m;
      ans[i] += m;
    }
  }
  cout << ans[0] - ans[1] << endl;
  cout << ans[1] - ans[2] << endl;
}
