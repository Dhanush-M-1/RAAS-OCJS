#include <bits/stdc++.h>
using namespace std;
const long long MAX = 1e5 + 47;
long long a[MAX], sum[MAX], n, ans, tek, d, last_iter[MAX], li, t;
void go() {
  cin >> n >> d;
  for (long long i = 1; i <= n; i++) cin >> a[i], sum[i] = sum[i - 1] + a[i];
  for (long long i = n - 1; i >= 1; i--) sum[i] = max(sum[i], sum[i + 1]);
  return;
}
int main() {
  go();
  for (long long i = 1; i <= n; i++) {
    long long v = a[i];
    tek += v;
    if (tek > d) {
      cout << -1;
      return 0;
    }
    if (!v) {
      if (tek < 0) {
        sum[i] += li;
        t = max(0ll, min(d - tek, d - sum[i]));
        ans++;
        li += t;
        tek += t;
        if (tek < 0) {
          cout << -1;
          return 0;
        }
      }
    }
  }
  cout << ans;
}
