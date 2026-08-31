#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  long long int x[n + 5], h[n + 5], i;
  for (i = 0; i < n; ++i) cin >> x[i] >> h[i];
  int count = min(n, 2);
  long long int prev = 0;
  for (i = 1; i < n - 1; ++i) {
    if (x[i] - x[i - 1] > h[i] + prev) {
      ++count;
      prev = 0;
    } else {
      if (x[i + 1] - x[i] > h[i]) {
        ++count;
        prev = h[i];
      } else
        prev = 0;
    }
  }
  cout << count << endl;
  return 0;
}
