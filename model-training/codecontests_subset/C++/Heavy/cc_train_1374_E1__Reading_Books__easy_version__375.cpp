#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n, K;
  cin >> n >> K;
  long long a, b, c;
  long long x[n], x2[n], x3[n];
  long long k = 0, k2 = 0, k3 = 0, ans = 0;
  for (long long i = 0; i < n; i++) {
    cin >> a >> b >> c;
    if (b == c && b == 1) {
      x[k] = a;
      k++;
    } else if (b == 0 && c == 1) {
      x2[k2] = a;
      k2++;
    } else if (b == 1 && c == 0) {
      x3[k3] = a;
      k3++;
    }
  }
  sort(x, x + k);
  sort(x2, x2 + k2);
  sort(x3, x3 + k3);
  if (k2 > k3) k2 = k3;
  for (long long i = 0; i < k2; i++) {
    x2[i] += x3[i];
  }
  sort(x2, x2 + k2);
  for (long long i = k; i < k + k2; i++) {
    x[i] = x2[i - k];
  }
  sort(x, x + k + k2);
  if (K > k + k2) {
    cout << "-1" << endl;
  } else {
    for (long long i = 0; i < K; i++) ans += x[i];
    cout << ans << endl;
  }
}
