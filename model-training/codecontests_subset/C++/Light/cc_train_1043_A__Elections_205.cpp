#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a[109], sum = 0, max = -1;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    if (a[i] > max) max = a[i];
    sum = sum + a[i];
  }
  int t = max * n;
  if (t - sum > sum) {
    cout << max;
  } else {
    while (1) {
      if (max * n - sum > sum) {
        cout << max;
        return 0;
      } else
        max++;
    }
  }
  return 0;
}
