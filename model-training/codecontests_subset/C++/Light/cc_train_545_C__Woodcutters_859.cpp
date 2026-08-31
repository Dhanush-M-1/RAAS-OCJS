#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a, b;
  cin >> n;
  if (n == 1) {
    cout << 1 << '\n';
    return 0;
  }
  long long int x[n], h[n];
  for (int i = 0; i < n; i++) {
    cin >> x[i] >> h[i];
  }
  long long int right[n], cnt = 0;
  right[0] = x[0];
  cnt++;
  for (int i = 1; i < n - 1; i++) {
    if (x[i] - h[i] > right[i - 1]) {
      cnt++;
      right[i] = x[i];
    } else if (x[i] + h[i] < x[i + 1]) {
      cnt++;
      right[i] = x[i] + h[i];
    } else
      right[i] = x[i];
  }
  ++cnt;
  cout << cnt << '\n';
  return 0;
}
