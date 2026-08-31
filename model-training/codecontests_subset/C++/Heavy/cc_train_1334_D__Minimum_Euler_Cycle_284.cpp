#include <bits/stdc++.h>
using namespace std;
pair<int, int> p[105];
const int N = 1e5 + 10;
long long d[N];
bool cmp(int a, int b) { return a > b; }
int main() {
  std::ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int t;
  cin >> t;
  while (t--) {
    long long n, l, r;
    cin >> n >> l >> r;
    long long ans = 0;
    for (long long i = 1; i < n; i++) {
      d[i] = ans + (n - i) * 2;
      ans = d[i];
    }
    d[n] = ans + 1;
    for (long long i = l; i <= r; i++) {
      long long p = lower_bound(d + 1, d + n + 1, i) - d;
      if (i == d[n]) {
        cout << 1 << ' ';
        break;
      }
      if (i & 1)
        cout << p << ' ';
      else {
        long long t = i - d[p - 1];
        cout << t / 2 + p << ' ';
      }
    }
    cout << endl;
  }
  return 0;
}
