#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  for (int p = 0; p < t; p++) {
    int n;
    cin >> n;
    int a[n];
    for (int i = 0; i < n; i++) cin >> a[i];
    int flag = 0;
    int ans[3];
    for (int i = 0; i < n - 2; i++) {
      int temp;
      temp = a[i] + a[i + 1];
      if (temp <= a[n - 1]) {
        flag = 1;
        ans[0] = i + 1;
        ans[1] = i + 2;
        ans[2] = n;
      }
      if (flag == 1) break;
    }
    if (flag == 1)
      cout << ans[0] << " " << ans[1] << " " << ans[2] << endl;
    else
      cout << "-1" << endl;
  }
  return 0;
}
