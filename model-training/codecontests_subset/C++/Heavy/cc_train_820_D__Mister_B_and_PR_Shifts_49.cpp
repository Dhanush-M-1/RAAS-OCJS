#include <bits/stdc++.h>
using namespace std;
const int N = 1e6 + 10;
int n, p[N], cnt[N];
int main() {
  cin >> n;
  for (int i = 1; i <= n; i++) cin >> p[i];
  int L = 0, R = 0;
  long long res = 0, ans;
  for (int i = 1; i <= n; i++) {
    res += abs(p[i] - i);
    cnt[(p[i] - i + n) % n]++;
    if (p[i] <= i)
      R++;
    else
      L++;
  }
  ans = res;
  int idx = 0;
  for (int k = 1; k < n; k++) {
    res -= L;
    res += R - 1;
    res += p[(n - k) % n + 1] - n + p[(n - k) % n + 1] - 1;
    L -= cnt[k] - 1;
    R += cnt[k] - 1;
    if (res < ans) {
      idx = k, ans = res;
    }
  }
  cout << ans << " " << idx << endl;
  return 0;
}
