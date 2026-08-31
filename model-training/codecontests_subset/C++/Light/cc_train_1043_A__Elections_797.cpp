#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  int n;
  cin >> n;
  int vt[n + 7], sum = 0, mx = -INT_MAX;
  for (int i = 1; i <= n; i++) {
    cin >> vt[i];
    sum += vt[i];
    mx = max(mx, vt[i]);
  }
  for (int k = mx; k < 300; k++) {
    int t = 0;
    for (int i = 1; i <= n; i++) {
      t += max(0, k - vt[i]);
    }
    if (t > sum) {
      cout << k << endl;
      return 0;
    }
  }
  return 0;
}
