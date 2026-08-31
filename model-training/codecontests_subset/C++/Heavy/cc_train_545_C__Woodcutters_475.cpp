#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n;
  cin >> n;
  int x[n + 2], h[n + 2];
  x[0] = numeric_limits<int>::min(), h[0] = 0;
  x[n + 1] = numeric_limits<int>::max(), h[n + 1] = 0;
  for (int i = 1; i < n + 1; i++) cin >> x[i] >> h[i];
  int ans[n + 1][3];
  ans[0][0] = ans[0][1] = ans[0][2] = 0;
  for (int i = 1; i < n + 1; i++) {
    ans[i][0] = 0;
    ans[i][0] = max({ans[i - 1][1], ans[i - 1][0], ans[i][0]});
    if (x[i - 1] + h[i - 1] < x[i]) ans[i][0] = max(ans[i][0], ans[i - 1][2]);
    ans[i][1] = 0;
    if (x[i - 1] + h[i - 1] < x[i] - h[i]) {
      ans[i][1] = max(1 + ans[i - 1][2], ans[i][1]);
    }
    if (x[i - 1] < x[i] - h[i]) {
      ans[i][1] = max(1 + max(ans[i - 1][1], ans[i - 1][0]), ans[i][1]);
    }
    ans[i][2] = 0;
    if (x[i] + h[i] < x[i + 1]) {
      ans[i][2] = max(1 + max({ans[i - 1][0], ans[i - 1][1], ans[i - 1][2]}),
                      ans[i][2]);
    }
  }
  cout << max({ans[n][0], ans[n][1], ans[n][2]});
}
