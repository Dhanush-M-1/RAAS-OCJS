#include <bits/stdc++.h>
using namespace std;
const int MOD = (int)1e9 + 7;
const int INF = (int)1e9;
const long long LINF = (long long)1e18;
const long double PI = acos((long double)-1);
const long double EPS = 1e-9;
long long gcd(long long a, long long b) {
  long long r;
  while (b) {
    r = a % b;
    a = b;
    b = r;
  }
  return a;
}
long long lcm(long long a, long long b) { return a / gcd(a, b) * b; }
long long fpow(long long n, long long k, int p = MOD) {
  long long r = 1;
  for (; k; k >>= 1) {
    if (k & 1) r = r * n % p;
    n = n * n % p;
  }
  return r;
}
template <class T>
void setmin(T& a, T val) {
  if (a > val) a = val;
}
template <class T>
void setmax(T& a, T val) {
  if (a < val) a = val;
}
void addmod(int& a, int val, int p = MOD) {
  if ((a = (a + val)) >= p) a -= p;
}
void submod(int& a, int val, int p = MOD) {
  if ((a = (a - val)) < 0) a += p;
}
int mult(int a, int b, int p = MOD) { return (long long)a * b % p; }
int inv(int a, int p = MOD) { return fpow(a, p - 2, p); }
const int N = 1000005;
int pre[N], cost[N], block[N];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n, m, k;
  cin >> n >> m >> k;
  for (int i = 1; i <= m; i++) {
    int x;
    cin >> x;
    block[x] = 1;
  }
  if (block[0])
    pre[0] = -1;
  else
    pre[0] = 0;
  for (int i = 1; i <= n; i++) {
    if (!block[i])
      pre[i] = i;
    else
      pre[i] = pre[i - 1];
  }
  for (int i = 1; i <= k; i++) cin >> cost[i];
  long long ans = LINF;
  for (int i = 1; i <= k; i++) {
    int pos = 0, cnt = 0, lst = -1;
    while (pos < n) {
      if (pre[pos] <= lst) {
        cnt = -1;
        break;
      }
      cnt++;
      lst = pre[pos];
      pos = lst + i;
    }
    if (cnt != -1) ans = min(ans, (long long)cnt * cost[i]);
  }
  if (ans != LINF)
    cout << ans << "\n";
  else
    cout << "-1\n";
  return 0;
}
