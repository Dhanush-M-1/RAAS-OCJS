#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m;
  cin >> n >> m;
  int max[5002], mc[5002][4], ad[5002];
  for (int i = 1; i <= m; i++) {
    cin >> mc[i][0] >> mc[i][1] >> mc[i][2] >> mc[i][3];
  }
  for (int i = 1; i <= n; i++) {
    max[i] = 1000000000;
    ad[i] = 0;
  }
  for (int i = 1; i <= m; i++) {
    if (mc[i][0] == 1) {
      for (int j = mc[i][1]; j <= mc[i][2]; j++) ad[j] += mc[i][3];
    } else {
      for (int j = mc[i][1]; j <= mc[i][2]; j++) {
        if (max[j] > mc[i][3] - ad[j]) max[j] = mc[i][3] - ad[j];
      }
    }
  }
  for (int i = 1; i <= n; i++) ad[i] = 0;
  bool f = true;
  for (int i = 1; i <= m; i++) {
    if (mc[i][0] == 1) {
      for (int j = mc[i][1]; j <= mc[i][2]; j++) ad[j] += mc[i][3];
    } else {
      bool flag = false;
      for (int j = mc[i][1]; j <= mc[i][2]; j++) {
        if (max[j] + ad[j] >= mc[i][3]) {
          flag = true;
          break;
        }
      }
      if (!flag) {
        f = false;
        break;
      }
    }
  }
  if (f) {
    printf("YES\n");
    for (int i = 1; i <= n; i++) printf("%d ", max[i]);
  } else
    printf("NO\n");
  return 0;
}
