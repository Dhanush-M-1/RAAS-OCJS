#include <bits/stdc++.h>
using namespace std;
const long long INF = 1e13 + 5;
const int mod = 1e9 + 7;
const int maxn = 1e5 + 5;
long long n, l, r, s[maxn];
int calc(long long x) {
  if (x > s[n - 1]) return 1;
  long long a = lower_bound(s + 1, s + n, x) - s;
  long long b = x - s[a - 1];
  if (b % 2)
    return a;
  else
    return b / 2 + a;
}
int main() {
  int T;
  cin >> T;
  while (T--) {
    cin >> n >> l >> r;
    for (int i = 1; i <= n; i++) s[i] = s[i - 1] + 2 * (n - i);
    for (long long i = l; i <= r; i++) {
      cout << calc(i) << " ";
    }
    puts("");
  }
}
