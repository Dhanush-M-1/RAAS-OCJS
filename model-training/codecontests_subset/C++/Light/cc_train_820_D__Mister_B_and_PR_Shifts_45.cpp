#include <bits/stdc++.h>
using namespace std;
const int N = 1e6 + 10;
long long a[N], n, l[N];
int main() {
  cin >> n;
  long long ans = 0;
  long long id = 0, L = 0, R;
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
    if (a[i] > i) {
      l[a[i] - i]++;
      L++;
    } else {
      l[n - i + a[i]]++;
    }
    ans += (a[i] > i) ? a[i] - i : i - a[i];
  }
  long long tmp = ans;
  for (int i = 1; i < n; i++) {
    R = n - L;
    tmp += (-L + R + (-(n - a[n - i + 1])) + (a[n - i + 1] - 1) - 1);
    L -= l[i];
    L++;
    if (tmp < ans) {
      ans = tmp;
      id = i;
    }
  }
  cout << ans << ' ' << id << endl;
  return 0;
}
