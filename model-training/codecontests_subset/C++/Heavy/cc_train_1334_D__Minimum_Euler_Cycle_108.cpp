#include <bits/stdc++.h>
using namespace std;
long long f(long long N, long long x) { return (2 * N - 1 - x) * x; }
int main() {
  cin.tie(0);
  ios::sync_with_stdio(false);
  int t;
  cin >> t;
  while (t--) {
    long long N;
    cin >> N;
    long long l, r;
    cin >> l >> r;
    long long ng = 0, ok = N;
    while (ok - ng > 1) {
      long long mid = (ok + ng) / 2;
      if (f(N, mid) >= l)
        ok = mid;
      else
        ng = mid;
    }
    long long p = ok;
    long long stage = N - p;
    p--;
    long long cnt = (l - f(N, p) - 1) / 2,
              s = ((l - f(N, p) - 1) % 2 == 0 ? N - stage
                                              : N - stage + cnt + 1);
    for (int i = 0; i <= (r - l); i++) {
      if (i == r - l && r == N * (N - 1) + 1)
        cout << 1;
      else
        cout << s << " ";
      if (s == N - stage) {
        s = N - stage + cnt + 1;
      } else {
        if (cnt == stage - 1) {
          stage--;
          cnt = 0;
        } else
          cnt++;
        s = N - stage;
      }
    }
    cout << "\n";
  }
  return 0;
}
