#include <bits/stdc++.h>
using namespace std;
int mod = 1000000007;
int m, n, k, x[200000], h[200000], ans[200000];
deque<int> q;
int main() {
  cin >> n;
  for (int i = 0; i < (int)(n); i++) cin >> x[i] >> h[i];
  m = 2;
  if (n == 1) {
    cout << 1;
    return 0;
  }
  ans[0] = 1;
  int f = 0;
  for (int i = 1; i < (int)(n - 1); i++) {
    if (h[i] + x[i - 1] < x[i] && !f) {
      m++;
    } else if (h[i] + h[i - 1] + x[i - 1] < x[i] && f) {
      m++;
      f = 0;
    } else {
      if (x[i + 1] - x[i] > h[i]) {
        f = 1;
        m++;
      } else {
        f = 0;
      }
    }
  }
  cout << m;
  return 0;
}
