#include <bits/stdc++.h>
using namespace std;
const long long M = 1e9 + 7;
const int N = 1e5 + 5;
long long n, x[N], h[N], cnt;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> x[i] >> h[i];
  }
  cnt++;
  for (int i = 2; i < n; i++) {
    if (x[i] - h[i] > x[i - 1]) {
      cnt++;
    } else if (x[i] + h[i] < x[i + 1]) {
      cnt++;
      x[i] = x[i] + h[i];
    }
  }
  if (n != 1) cnt++;
  cout << cnt;
  return 0;
}
