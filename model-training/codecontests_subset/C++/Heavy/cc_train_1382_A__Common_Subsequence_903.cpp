#include <bits/stdc++.h>
using namespace std;
const double pi = 3.1415926535;
long long n, m;
const int mx = 69;
char grid[mx][mx];
long long blocked[mx][mx];
long long vis[mx][mx];
void FAST() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
}
long long power(long long a, long long b) {
  long long res = 1;
  for (int i = 1; i <= b; ++i) res *= a;
  return res;
}
vector<long long> digit(long long n) {
  long long arr[10000];
  long long i = 0;
  long long j, r;
  vector<long long> v;
  while (n != 0) {
    r = n % 10;
    arr[i] = r;
    i++;
    n = n / 10;
  }
  for (j = i - 1; j > -1; j--) {
    v.push_back(arr[j]);
  }
  return v;
}
long long sum(long long x) {
  long long ans = 0;
  while (x > 0) {
    ans += (x % 10);
    x /= 10;
  }
  return ans;
}
bool opp(int x, int y) { return ((x ^ y) < 0); }
int main() {
  FAST();
  long long t;
  cin >> t;
  while (t--) {
    long long n, m;
    cin >> n >> m;
    long long a[n], b[m];
    for (long long i = 0; i < n; i++) cin >> a[i];
    for (long long i = 0; i < m; i++) cin >> b[i];
    long long ans, f = 0;
    for (long long i = 0; i < n; i++) {
      for (long long j = 0; j < m; j++) {
        if (a[i] == b[j]) {
          f = 1;
          ans = a[i];
        }
      }
    }
    if (f == 1) {
      cout << "YES" << '\n';
      cout << 1 << ' ';
      cout << ans << '\n';
    } else
      cout << "NO" << '\n';
  }
}
