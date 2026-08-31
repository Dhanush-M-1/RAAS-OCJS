#include <bits/stdc++.h>
using namespace std;
long long gcd(long long x, long long y) { return x ? gcd(y % x, x) : y; }
long long mcm(long long x, long long y) { return x * y / gcd(x, y); }
int main(int argc, char *argv[]) {
  cout.sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cerr.tie(0);
  long long N, D;
  while (cin >> N >> D) {
    long long ans = 0;
    bool can = true;
    long long mini = 0;
    long long maxi = 0;
    for (int i = 0; i < (N); i++) {
      long long A;
      cin >> A;
      if (A > 0) {
        if (mini + A > D) can = false;
        mini = mini + A;
        maxi = maxi + A;
        if (maxi > D) maxi = D;
      }
      if (A < 0) {
        mini += A;
        maxi += A;
      }
      if (A == 0) {
        if (maxi < 0) {
          ans++;
          maxi = D;
        }
        if (mini < 0) {
          mini = 0;
        }
      }
    }
    if (!can) ans = -1;
    cout << ans << endl;
  }
}
