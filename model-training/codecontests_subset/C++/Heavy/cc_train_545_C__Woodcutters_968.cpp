#include <bits/stdc++.h>
using namespace std;
const long double pi = acos((long double)-1.0);
const double eps = (double)1e-9;
const int inf = (int)1e9 + 7;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int n;
  cin >> n;
  long long int x[n], h[n];
  for (int i = 0; i < n; i++) {
    cin >> x[i] >> h[i];
  }
  long long int l, cnt = 0;
  for (int i = 0; i < n; i++) {
    if (i == 0) {
      cnt++;
      l = x[i];
    } else if (i == n - 1) {
      cnt++;
    } else if (x[i] - h[i] > l) {
      cnt++;
      l = x[i];
    } else if (x[i] + h[i] < x[i + 1]) {
      cnt++;
      l = x[i] + h[i];
    } else
      l = x[i];
  }
  cout << cnt;
  return 0;
}
