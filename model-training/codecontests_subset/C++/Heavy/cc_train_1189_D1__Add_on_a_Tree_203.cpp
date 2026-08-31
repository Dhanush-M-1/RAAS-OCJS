#include <bits/stdc++.h>
using namespace std;
using ll = long long;
long mmid(long a, long b, long c) {
  return a < b ? (b < c ? b : max(a, c)) : (b > c ? b : min(a, c));
}
ll modinv(ll a) {
  ll b = 1000000007, u = 1, v = 0, t;
  while (b) {
    t = a / b;
    a -= t * b;
    swap(a, b);
    u -= t * v;
    swap(u, v);
  }
  return (u + 1000000007) % 1000000007;
}
ll moddevide(ll a, ll b) { return (a * modinv(b)) % 1000000007; }
ll modncr(ll n, ll r) {
  ll i, plus = 1;
  for (i = 0; i < r; i++) {
    plus = (plus * (n - i)) % 1000000007;
    plus = moddevide(plus, i + 1);
  }
  return plus;
}
ll euclidean_gcd(ll a, ll b) {
  if (a < b) return euclidean_gcd(b, a);
  ll r;
  while ((r = a % b)) {
    a = b;
    b = r;
  }
  return b;
}
int main() {
  int i, N, K, a, b, ch, now;
  long t;
  cin >> N;
  vector<vector<int>> v(N);
  for (i = 0; i < N - 1; i++) {
    cin >> a >> b;
    a--;
    b--;
    v[a].push_back(b);
    v[b].push_back(a);
  }
  for (i = 0; i < N; i++) {
    K = v[i].size();
    if (K == 2) {
      printf("NO\n");
      return 0;
    }
  }
  printf("YES\n");
  return 0;
}
