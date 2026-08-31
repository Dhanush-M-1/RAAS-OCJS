#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 5;
int n, ans[N];
long long a[N], bit[N];
void update(int pos) {
  for (int i = pos; i < N; i += (i & -i)) {
    bit[i] += pos;
  }
}
long long query(int pos) {
  long long res = 0;
  for (int i = pos; i; i -= (i & -i)) {
    res += bit[i];
  }
  return res;
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
  }
  for (int i = n; i; i--) {
    int l = 1, r = n;
    while (l <= r) {
      int mid = (l + r) / 2;
      if (1ll * (mid - 1) * mid / 2 - query(mid - 1) <= a[i]) {
        ans[i] = mid;
        l = mid + 1;
      } else {
        r = mid - 1;
      }
    }
    update(ans[i]);
  }
  for (int i = 1; i <= n; i++) {
    cout << ans[i] << (i == n ? "\n" : " ");
  }
}
