#include <bits/stdc++.h>
using namespace std;
int kq, n, x[100010], h[100010];
int main() {
  cin >> n;
  for (int i = 1; i <= n; i++) cin >> x[i] >> h[i];
  if (n == 1) {
    cout << 1;
    return 0;
  }
  if (n == 2) {
    cout << 2;
    return 0;
  }
  kq = 2;
  for (int i = 2; i < n; i++) {
    if (x[i - 1] + h[i] < x[i])
      kq++;
    else if (x[i] + h[i] < x[i + 1]) {
      kq++;
      x[i] += h[i];
    }
  }
  cout << kq;
  return 0;
}
