#include <bits/stdc++.h>
using namespace std;
const int N = 100010;
int n, d, arr[N], cur[N], sum[N];
int main() {
  scanf("%d%d", &n, &d);
  for (int i = 0; i < n; i++) {
    scanf("%d", &arr[i]);
    sum[i] = (i == 0 ? 0 : sum[i - 1]) + arr[i];
  }
  int ans = 0;
  int mx = -1e9;
  for (int i = n - 1; i >= 0; i--) {
    if (arr[i] == 0)
      cur[i] = mx;
    else
      mx = max(mx, sum[i]);
  }
  int added = 0, money = 0;
  for (int i = 0; i < n; i++) {
    if (arr[i] == 0) {
      if (money < 0) {
        int inc = d - money;
        inc = min(inc, d - (cur[i] + added));
        if (money + inc < 0) {
          puts("-1");
          return 0;
        }
        money += inc;
        added += inc;
        ans++;
      }
    } else {
      money += arr[i];
      if (money > d) {
        puts("-1");
        return 0;
      }
    }
  }
  cout << ans << endl;
  return 0;
}
