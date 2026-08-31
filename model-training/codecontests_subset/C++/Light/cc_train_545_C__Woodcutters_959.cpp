#include <bits/stdc++.h>
using namespace std;
int main() {
  std::ios::sync_with_stdio(false);
  long long n, i;
  cin >> n;
  long long x[n], h[n];
  for (i = 0; i < n; i++) cin >> x[i] >> h[i];
  long long c = min(2LL, n);
  for (i = 1; i < n - 1; i++) {
    if (x[i] - x[i - 1] > h[i])
      c++;
    else if (x[i + 1] - x[i] > h[i]) {
      c++;
      x[i] = x[i] + h[i];
    }
  }
  cout << c << endl;
}
