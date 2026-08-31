#include <bits/stdc++.h>
using namespace std;
int n;
int a[100010], b[100010];
int ans;
int main() {
  cin >> n;
  if (n == 1) {
    cout << 1;
    return 0;
  }
  for (int i = 1; i <= n; i++) {
    cin >> a[i] >> b[i];
  }
  for (int i = 2; i < n; i++) {
    if (a[i] - b[i] > a[i - 1]) {
      ans++;
    } else if (a[i] + b[i] < a[i + 1]) {
      ans++;
      a[i] = a[i] + b[i];
    }
  }
  cout << ans + 2;
  return 0;
}
