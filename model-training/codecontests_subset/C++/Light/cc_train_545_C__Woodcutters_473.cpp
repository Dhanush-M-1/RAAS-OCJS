#include <bits/stdc++.h>
using namespace std;
int xi[100005], hi[100005], i, j, nr, cnt, n;
int main() {
  cin >> n;
  if (n == 1 || n == 2) {
    cout << n;
    return 0;
  } else {
    nr = 2;
  }
  for (i = 1; i <= n; i++) {
    cin >> xi[i] >> hi[i];
  }
  for (i = 2; i < n; i++) {
    if (xi[i] - hi[i] > xi[i - 1]) {
      nr++;
    } else if (xi[i] + hi[i] < xi[i + 1]) {
      nr++;
      xi[i] += hi[i];
    }
  }
  cout << nr;
  return 0;
}
