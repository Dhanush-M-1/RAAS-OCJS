#include <bits/stdc++.h>
using namespace std;
long long gcd(long long x, long long y) {
  if (!y) return x;
  return gcd(y, x % y);
}
const long long MOD = 1e9 + 7;
int inf = 1e9 + 7;
long long INF = 2e18 + 9;
long long power(long long x, long long y) {
  long long res = 1ll;
  x %= MOD;
  if (x == 0) return 0;
  while (y > 0) {
    if (y & 1) res = (res * x) % MOD;
    y = y >> 1ll;
    x = (x * x) % MOD;
  }
  return res;
}
long long inv(long long x) {
  long long r = 1ll, t = x, k = MOD - 2ll;
  while (k) {
    if (k & 1ll) r = (long long)r * t % MOD;
    t = (long long)t * t % MOD;
    k >>= 1;
  }
  return r;
}
bool isPrime(long long x) {
  if (x == 1) return false;
  for (long long i = 2; i * i <= x; i++) {
    if (x % i == 0) return false;
  }
  return true;
}
const int nax = 5e5 + 13;
void prep() {}
void solve() {}
vector<long long> fenwick[2];
int n;
void add(int pos, long long val, int ind) {
  pos++;
  while (pos <= n) {
    fenwick[ind][pos] += val;
    pos += pos & (-pos);
  }
}
long long query(int pos, int ind) {
  long long res = 0;
  pos++;
  while (pos) {
    res += fenwick[ind][pos];
    pos -= pos & (-pos);
  }
  return res;
}
void read() {
  cin >> n;
  vector<pair<int, int> > xv(n);
  for (int i = 0; i < n; i++) {
    cin >> xv[i].first;
  }
  for (int i = 0; i < n; i++) {
    cin >> xv[i].second;
  }
  vector<int> tmp;
  for (int i = 0; i < n; i++) tmp.push_back(xv[i].second);
  sort(tmp.begin(), tmp.end());
  auto it = unique(tmp.begin(), tmp.end());
  tmp.resize(distance(tmp.begin(), it));
  map<int, int> M;
  for (int i = 0; i < tmp.size(); i++) {
    M[tmp[i]] = i;
  }
  for (int i = 0; i < n; i++) {
    xv[i].second = M[xv[i].second];
  }
  sort(xv.begin(), xv.end());
  int N = n;
  n = tmp.size();
  fenwick[0].resize(n + 1);
  fenwick[1].resize(n + 1);
  for (auto& el : fenwick[0]) el = 0;
  for (auto& el : fenwick[1]) el = 0;
  long long res = 0;
  for (int i = 0; i < N; i++) {
    res += xv[i].first * query(xv[i].second, 0) - query(xv[i].second, 1);
    add(xv[i].second, 1, 0);
    add(xv[i].second, xv[i].first, 1);
  }
  cout << res << endl;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie();
  cout.tie();
  srand(time(NULL));
  int T = 1;
  prep();
  for (int i = 1; i <= T; i++) {
    read();
    solve();
  }
  return 0;
}
