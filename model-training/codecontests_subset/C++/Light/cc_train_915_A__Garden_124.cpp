#include <bits/stdc++.h>
using namespace std;
void XsliferX() {
  ios::sync_with_stdio(0);
  ios_base::sync_with_stdio(0);
  cin.tie(0), cout.tie(0);
}
int dx[9] = {1, -1, 0, 0, 1, -1, 1, -1, 0};
int dy[9] = {0, 0, 1, -1, 1, -1, -1, 1, 0};
int main() {
  XsliferX();
  int n, l, x;
  cin >> n >> l;
  int mn = 10000;
  for (int i = 0; i < n; i++) {
    cin >> x;
    if (l % x == 0) {
      mn = min(mn, l / x);
    }
  }
  cout << mn;
  return 0;
}
