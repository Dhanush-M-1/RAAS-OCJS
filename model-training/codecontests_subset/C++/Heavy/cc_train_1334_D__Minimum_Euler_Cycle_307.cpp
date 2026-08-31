#include <bits/stdc++.h>
using namespace std;
const long long md = 1e9 + 7;
const int xn = -20 + 10;
const int xm = 2e1 + 10;
const int SQ = 450;
const int sq = 1e3 + 10;
const int inf = 1e9 + 10;
const long long INF = 1e18 + 10;
long long power(long long a, long long b) {
  return (!b ? 1
             : (b & 1 ? a * power(a * a % md, b / 2) % md
                      : power(a * a % md, b / 2) % md));
}
long long zarb(long long a, long long b) { return (a * b + 10 * md) % md; }
long long jaam(long long a, long long b) { return (a + b + 10 * md) % md; }
long long qq, n, l, r;
vector<int> vec;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  cin >> qq;
  while (qq--) {
    cin >> n >> l >> r;
    vec.clear();
    long long ptr = 2 * n - 2, sum = 0;
    for (long long i = 1; i <= n; i++) {
      if (l <= sum + n + n - i - i) {
        ptr = i;
        break;
      }
      sum += n + n - i - i;
    }
    long long gir = 0;
    long long L = l;
    gir = (l - sum + 1) / 2 + ptr;
    long long last = sum;
    for (long long i = l; i <= r; i++) {
      if (i > n * (n - 1)) {
        vec.push_back(1);
        break;
      }
      if ((i - last) % 2 == 1) vec.push_back(ptr);
      if ((i - last) % 2 == 0) vec.push_back(gir++);
      if (gir > n) {
        gir = ptr + 2;
        sum += n + n - ptr - ptr - 2;
        ptr++;
        last = sum;
      }
    }
    for (int x : vec) cout << x << ' ';
    cout << '\n';
  }
  return 0;
}
