#include <bits/stdc++.h>
#pragma GCC optimize("-O3")
using namespace std;
const double PI = acos(-1);
long long gcd() { return 0ll; }
template <typename T, typename... Args>
T gcd(T a, Args... args) {
  return __gcd(a, (__typeof(a))gcd(args...));
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int T;
  cin >> T;
  while (T--) {
    long long n, l, r;
    cin >> n >> l >> r;
    l--;
    r--;
    long long a[2 * n - 3];
    for (__typeof(2 * n - 3) i = (0) - ((0) > (2 * n - 3));
         i != (2 * n - 3) - ((0) > (2 * n - 3));
         i += 1 - 2 * ((0) > (2 * n - 3))) {
      if (i & 1)
        a[i] = 1 + ((i + 1) / 2);
      else
        a[i] = 1;
    }
    while (l < (2 * n - 3) && l <= r) cout << a[l++] << " ";
    long long st[n - 1], x = 2;
    st[n - 2] = n * (n - 1) - 1;
    for (__typeof(0) i = (n - 2) - ((n - 2) > (0)); i != (0) - ((n - 2) > (0));
         i += 1 - 2 * ((n - 2) > (0))) {
      st[i] = st[i + 1] - x;
      x += 2;
    }
    long long j = -1;
    while (st[j + 1] < l) j++;
    while (l <= r) {
      if (l == (n * (n - 1))) {
        cout << "1";
        break;
      }
      if (st[j + 1] == l) {
        j++;
        l++;
        cout << n << " ";
        continue;
      }
      if (!(l & 1))
        cout << (j + 2) << " ";
      else
        cout << (j + 2) + (l - st[j]) / 2 << " ";
      l++;
    }
    cout << "\n";
  }
  return 0;
}
