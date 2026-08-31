#include <bits/stdc++.h>
using namespace std;
long long n;
long long a[200007];
long long bit[200007];
long long ans[200007];
long long query(long long id) {
  long long res = 0;
  while (id) {
    res += bit[id];
    id -= (id & (-id));
  }
  return res;
}
void add(long long id, long long val) {
  while (id <= n) {
    bit[id] += val;
    id += (id & (-id));
  }
}
int main() {
  cin >> n;
  for (long long i = 1; i <= n; i++) {
    cin >> a[i];
  }
  for (long long i = 1; i <= n; i++) add(i, i);
  for (long long i = n; i >= 1; i--) {
    long long lo = 1, hi = n;
    while (lo <= hi) {
      long long mid = (lo + hi) / 2;
      if (query(mid - 1) > a[i]) {
        hi = mid - 1;
      } else {
        lo = mid + 1;
        ans[i] = mid;
      }
    }
    add(ans[i], -1 * ans[i]);
  }
  for (long long i = 1; i <= n; i++) cout << ans[i] << " ";
}
