#include <bits/stdc++.h>
using namespace std;
using vi = vector<int>;
using mii = map<int, int>;
const double Eps = 1e-8;
const int Inf = 1e9 + 9;
const int Mod = 1e9 + 7;
const int N = 1e5 + 9;
const int dx4[4] = {0, 1, 0, -1};
const int dy4[4] = {-1, 0, 1, 0};
const int dx8[8] = {-1, -1, -1, 0, 1, 1, 1, 0};
const int dy8[8] = {-1, 0, 1, 1, 1, 0, -1, -1};
constexpr double pi = 3.141592653589793238462643383279502884L;
long long gcd(long long x, long long y) {
  if (y == 0) return x;
  return gcd(y, x % y);
}
long long lcm(long long a, long long b) { return a * b / gcd(a, b); }
void prime_siever(long long p) {
  bool prime[p + 9];
  for (long long i = 2; i * i <= p; i++)
    if (prime[i] == 0)
      for (long long j = i * i; j <= p; j += i) prime[j] = 1;
}
int mul(int a, int b) { return (1LL * a * b) % Mod; }
int add(int a, int b) {
  a += b;
  if (a >= Mod) a -= Mod;
  if (a < 0) a += Mod;
  return a;
}
long long bin_power(long long a, long long n) {
  if (a == 0) return 0;
  long long res = 1;
  while (n) {
    if (n % 2) {
      res = (res * a) % Mod;
      n--;
    } else {
      a = (a * a) % Mod;
      n /= 2;
    }
  }
  return res;
}
vector<int> a;
vector<pair<int, int> > b, c;
priority_queue<int, vector<int>, greater<int> > qi;
map<pair<int, int>, int> mp;
void solve() {
  int q, n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    int x;
    cin >> x;
    a.push_back(x);
    qi.push(a[i]);
  }
  cin >> q;
  for (int i = 0; i < q; i++) {
    int x, y;
    cin >> x >> y;
    b.push_back({x, y});
  }
  c = b;
  sort(b.rbegin(), b.rend());
  for (int i = 0; i < q; i++) {
    int siz = b[i].first, idx = b[i].second - 1;
    while (qi.size() != siz) {
      reverse(a.begin(), a.end());
      a.erase(find(a.begin(), a.end(), qi.top()));
      reverse(a.begin(), a.end());
      qi.pop();
    }
    mp[{siz, idx + 1}] = a[idx];
  }
  for (int i = 0; i < q; i++) {
    cout << mp[c[i]] << '\n';
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  solve();
  return 0;
}
