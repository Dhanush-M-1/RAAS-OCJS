#include <bits/stdc++.h>
using namespace std;
const int INF = 1e9;
const int X[8] = {-1, -1, 0, 1, 1, 1, 0, -1};
const int Y[8] = {0, 1, 1, 1, 0, -1, -1, -1};
const int N = 1e5 + 10;
int n, c, a[N];
int main() {
  cin >> n >> c;
  for (int i = 0; i < n; ++i) cin >> a[i];
  int ans = 0;
  for (int i = 0; i + 1 < n; ++i) ans = max(ans, a[i] - a[i + 1] - c);
  cout << ans;
  return 0;
}
