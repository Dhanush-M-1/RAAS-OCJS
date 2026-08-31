#include <bits/stdc++.h>
using namespace std;
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  int n;
  cin >> n;
  vector<int> h(n), coor(n);
  for (int i = 0; i < n; i++) cin >> coor[i] >> h[i];
  int c = 2;
  if (n == 1) c--;
  for (int i = 1; i < n - 1; i++) {
    if (coor[i] - coor[i - 1] - h[i] > 0) {
      c++;
    } else if (coor[i + 1] - coor[i] - h[i] > 0) {
      coor[i] = coor[i] + h[i];
      c++;
    }
  }
  cout << c;
  return 0;
}
