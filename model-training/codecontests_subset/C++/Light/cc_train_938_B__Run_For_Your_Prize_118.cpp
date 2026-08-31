#include <bits/stdc++.h>
using namespace std;
int a[100010];
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  int n;
  cin >> n;
  for (int i = 1; i <= n; ++i) {
    cin >> a[i];
  }
  sort(a + 1, a + n + 1);
  int res = numeric_limits<int>::max();
  for (int i = 1; i <= n; ++i) {
    res = min(res, max(a[i] - 1, 1000000 - a[i + 1]));
  }
  res = min(res, a[n] - 1);
  res = min(res, 1000000 - a[1]);
  cout << res;
}
