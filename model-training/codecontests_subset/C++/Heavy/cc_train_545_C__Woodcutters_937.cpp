#include <bits/stdc++.h>
using namespace std;
const double pi = acos(-1.0);
template <typename T, typename U>
inline void amin(T &x, U y) {
  if (y < x) x = y;
}
template <typename T, typename U>
inline void amax(T &x, U y) {
  if (x < y) x = y;
}
int main() {
  ios::sync_with_stdio(0);
  long n, i;
  long x[200000], h[200000];
  cin >> n;
  for (i = 0; i < n; i += 1) {
    cin >> x[i];
    cin >> h[i];
  }
  if (n == 1) {
    cout << 1;
    return 0;
  }
  long cnt = 2;
  for (i = 1; i < n - 1; i += 1) {
    if (x[i - 1] < (x[i] - h[i])) {
      cnt += 1;
    } else if (x[i + 1] > (x[i] + h[i])) {
      cnt += 1;
      x[i] += h[i];
    }
  }
  cout << cnt;
  return 0;
}
