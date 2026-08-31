#include <bits/stdc++.h>
using namespace std;
long long dx4[4] = {0, 1, 0, -1};
long long dy4[4] = {1, 0, -1, 0};
long long dy8[8] = {1, 1, 1, 0, -1, -1, -1, 0};
long long dx8[8] = {-1, 0, 1, 1, 1, 0, -1, -1};
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long n;
  cin >> n;
  long long l, r;
  long long ans = 0;
  long long xarr[n], harr[n];
  for (long long i = 0; i < n; i++) {
    cin >> xarr[i] >> harr[i];
  }
  for (long long i = 0; i < n; i++) {
    long long x = xarr[i], h = harr[i];
    if (i == 0) {
      ans++;
      l = x - h;
      r = x;
    } else if (i == n - 1) {
      if (x > r) ans++;
    } else if (x - h > r) {
      r = x;
      ans++;
    } else if (x > r && xarr[i + 1] > x + h) {
      r = x + h;
      ans++;
    } else {
      r = x;
    }
  }
  cout << ans;
}
