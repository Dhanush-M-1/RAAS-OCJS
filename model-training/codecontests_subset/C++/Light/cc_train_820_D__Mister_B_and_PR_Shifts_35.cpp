#include <bits/stdc++.h>
using namespace std;
int a[1000005];
long long ans[1000005];
int main() {
  int n;
  cin >> n;
  for (int i = 1; i <= n; i++) scanf("%d", a + i);
  for (int i = 1; i <= n; i++) {
    int time1, time2;
    time1 = n - i + 1;
    time2 = a[i] - i;
    if (time2 < 0) time2 += n;
    int ch = abs(n - a[i]);
    if (time1 <= time2) {
      int bg = abs(i - a[i]);
      int se = abs(1 - a[i]);
      int ed = abs(n - a[i]);
      ans[0] += bg;
      ans[1] += -bg + 1;
      ans[time1] += -1 - ed + se;
      ans[time1 + 1] += -1 + ed - se;
      ans[time2 + 1] += 2;
    } else {
      int bg = abs(i - a[i]);
      int se = abs(1 - a[i]);
      int ed = abs(n - a[i]);
      ans[0] += bg;
      ans[1] += -bg - 1;
      ans[time2 + 1] += 2;
      ans[time1] += -1 - ed + se;
      ans[time1 + 1] += -1 + ed - se;
    }
  }
  for (int i = 1; i < n; i++) ans[i] += ans[i - 1];
  for (int i = 1; i < n; i++) ans[i] += ans[i - 1];
  long long best = 1e18, besti = -1;
  for (int i = 0; i < n; i++) {
    if (ans[i] < best) {
      best = ans[i];
      besti = i;
    }
  }
  cout << best << " " << besti << endl;
  return 0;
}
