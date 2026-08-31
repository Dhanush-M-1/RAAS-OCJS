#include <bits/stdc++.h>
using namespace std;
long long t, n, i, j, k, x, y, z, l, r, mid, q, m, ans, s;
vector<int> v[200005];
long long bs(long long l, long long r, long long z) {
  long long ans = -1;
  while (l <= r) {
    mid = (l + r) >> 1;
    if ((n - 1 + n - mid) * (mid) >= z) {
      ans = mid;
      r = mid - 1;
    } else
      l = mid + 1;
  }
  if (ans == -1)
    x = 1;
  else {
    x = ans;
    z -= (n - 1 + n - ans + 1) * (ans - 1);
    y = (z + 1) / 2 + x;
  }
  return ans;
}
int main() {
  ios::sync_with_stdio(NULL);
  cin.tie(0);
  cout.tie(0);
  cin >> t;
  while (t--) {
    cin >> n >> l >> r;
    ans = bs(1, n - 1, l);
    while (l <= r) {
      if (l % 2)
        cout << x << " ";
      else
        cout << y << " ", y++;
      l++;
      if (y > n) {
        x++;
        y = x + 1;
        if (x == n) x = 1;
      }
    }
    cout << "\n";
  }
}
