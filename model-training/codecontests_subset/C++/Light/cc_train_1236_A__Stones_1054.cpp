#include <bits/stdc++.h>
using namespace std;
int main() {
  int t, a, b, c;
  cin >> t;
  int ans[t];
  for (int i = 0; i < t; i++) {
    cin >> a >> b >> c;
    ans[i] = ((min(c / 2, b)) * 3 + (min(a, (b - min(c / 2, b)) / 2)) * 3);
  }
  for (int z = 0; z < t; z++) {
    cout << ans[z] << endl;
  }
  return 0;
}
