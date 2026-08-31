#include <bits/stdc++.h>
using namespace std;
using vi = vector<long long int>;
using vvi = vector<vi>;
using vb = vector<bool>;
using vc = vector<char>;
using vs = vector<string>;
using vld = vector<long double>;
using pii = pair<long long int, long long int>;
using psi = pair<string, long long int>;
using pci = pair<char, long long int>;
using vpii = vector<pii>;
long long int const mod = 1e9 + 7;
long long int const maxn = 1e5 + 5;
long long int const inf = 1e18;
long long int add(long long int a, long long int b) {
  return ((a % mod) + (b % mod)) % mod;
}
long long int mul(long long int a, long long int b) {
  return ((a % mod) * (b % mod)) % mod;
}
long long int powm(long long int x, long long int n, long long int M) {
  long long int result = 1;
  while (n > 0) {
    if (n % 2 == 1) result = (result * x) % M;
    x = (x * x) % M;
    n = n / 2;
  }
  return result;
}
long long int modinverse(long long int a, long long int m) {
  return powm(a, m - 2, m);
}
bool prime(long long int x) {
  if (x <= 1) return false;
  for (int i = 2; i <= sqrt(x); i++)
    if (x % i == 0) return false;
  return true;
}
long long int divisor(long long int x) {
  long long int cnt = 0;
  for (int i = 1; i <= sqrt(x); i++) {
    if (x % i == 0) {
      if (i != x / i)
        cnt += 2;
      else
        cnt += 1;
    }
  }
  return cnt;
}
vector<long long int> sieve(long long int n) {
  bool prim[n + 1];
  memset(prim, true, sizeof(prim));
  for (long long int p = 2; p * p <= n; p++) {
    if (prim[p] == true) {
      for (int i = p * p; i <= n; i += p) prim[i] = false;
    }
  }
  vector<long long int> v;
  for (int i = 2; i <= n; i++)
    if (prim[i]) v.push_back(i);
  return v;
}
long long int const N = 100;
long long int a[N];
long long int b[N];
long long int n;
pii dp[N][N * N + N];
bool vis[N][N * N + N];
pii fun(long long int pos, long long int kitna_jagah) {
  if (pos == n) {
    if (kitna_jagah >= 0) {
      return {0, 0};
    }
    return {1e9, 1e9};
  }
  pii &ans = dp[pos][kitna_jagah];
  if (vis[pos][kitna_jagah] != false) return ans;
  vis[pos][kitna_jagah] = true;
  pii cur1 = fun(pos + 1, kitna_jagah - a[pos]);
  cur1.second += a[pos];
  pii cur2 = fun(pos + 1, kitna_jagah + (b[pos] - a[pos]));
  cur2.first += 1;
  return ans = min(cur1, cur2);
}
void solve() {
  cin >> n;
  for (int i = 0; i < n; i++) cin >> a[i];
  for (int i = 0; i < n; i++) cin >> b[i];
  pii ans = fun(0, 0);
  cout << ans.first << " " << ans.second;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  ;
  long long int t;
  t = 1;
  while (t--) {
    solve();
  }
  return 0;
}
