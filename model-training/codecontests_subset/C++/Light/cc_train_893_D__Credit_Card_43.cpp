#include <bits/stdc++.h>
using namespace std;
int n, d;
int main() {
  cin >> n >> d;
  int cur = 0, flow = 0, ans = 0;
  for (int i = 0; i < n; i++) {
    int j;
    cin >> j;
    if (!j && cur < 0) {
      if (flow + cur >= 0) {
        flow += cur;
      } else {
        ans++;
        flow = d;
      }
      cur = 0;
    }
    cur += j;
    if (cur > d) {
      cout << "-1";
      exit(0);
    }
    flow = min(flow, d - cur);
  }
  cout << ans;
}
