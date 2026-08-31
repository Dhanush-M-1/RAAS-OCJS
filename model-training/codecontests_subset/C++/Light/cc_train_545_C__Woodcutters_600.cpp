#include <bits/stdc++.h>
using namespace std;
int x[100005], h[100005], f[100005];
int main() {
  int n, i;
  cin >> n;
  for (i = 0; i < n; i++) {
    cin >> x[i] >> h[i];
  }
  if (n == 1 || n == 2) {
    cout << n << endl;
    return 0;
  }
  int cnt = 0;
  cnt = 1;
  f[0] = 1;
  for (i = 1; i < n - 1; i++) {
    if (f[i - 1] != 2 && x[i] - h[i] > x[i - 1]) {
      cnt += 1;
      f[i] = 1;
    } else if (f[i - 1] == 2 && x[i] - h[i] > x[i - 1] + h[i - 1]) {
      cnt += 1;
      f[i] = 1;
    } else if (x[i] + h[i] < x[i + 1]) {
      cnt += 1;
      f[i] = 2;
    }
  }
  cnt += 1;
  f[n - 1] = 2;
  cout << cnt << endl;
  return 0;
}
