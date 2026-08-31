#include <bits/stdc++.h>
using namespace std;
const int MOD = 1e9 + 7, N = 1e6 + 7;
int dx[] = {0, 0, 1, -1, 1, -1, 1, -1};
int dy[] = {1, -1, 0, 0, -1, 1, 1, -1};
long long gcd(long long x, long long y) { return (!y) ? x : gcd(y, x % y); }
long long lcm(long long x, long long y) { return ((x * y) / gcd(x, y)); }
void file() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
}
int a[1005];
int main() {
  file();
  int n;
  cin >> n;
  int sum = 0, mx = 0;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    mx = max(mx, a[i]);
    sum += a[i];
  }
  for (int i = mx; i <= 10000; i++) {
    int rem = 0;
    for (int j = 0; j < n; j++) {
      rem += i - a[j];
    }
    if (rem > sum) return cout << i << '\n', 0;
  }
}
