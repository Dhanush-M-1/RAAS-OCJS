#include <bits/stdc++.h>
using namespace std;
using ll = long long;
double squareRoot(double n) { return pow(2, 0.5 * log2(n)); }
ll gcd(ll a, ll b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
bool pal(string& s) {
  for (int i = 0; i < s.size() / 2; i++) {
    if (s[i] != s[s.size() - i - 1]) return 0;
  }
  return 1;
}
ll MOD = 1000000007;
ll powmod(ll a, ll b, ll m) {
  if (b == 0) return 1;
  if (b == 1) return a;
  ll p1 = powmod(a, b / 2ll, m);
  ll p2 = p1 * p1;
  ll p3 = powmod(a, b % 2ll, m);
  return ((p2 % m) * (p3 % m)) % m;
}
ll modpow(ll a, ll b, ll x) {
  ll res = 1;
  while (b > 0) {
    if (b & 1) res = (res * a) % x;
    a = (a * a) % x;
    b >>= 1;
  }
  return res;
}
ll ncr(ll n, ll r) {
  if (n == 0 || r == 0) return 1;
  if (r > n) return 0;
  if (n - r < r) r = n - r;
  ll ans = 1;
  for (ll i = 1; i <= r; i++) {
    ans = ans * (n - i + 1) / i;
  }
  return ans;
}
bool bruteprime(ll n) {
  if (n == 1) return 0;
  for (int i = 2; i * i <= n; i++) {
    if (n % i == 0) return 0;
  }
  return 1;
}
vector<ll> primefactors(ll n) {
  vector<ll> ans;
  for (ll i = 2; i * i <= n; i++) {
    while (n % i == 0) {
      ans.push_back(i);
      n /= i;
    }
  }
  if (n > 1) ans.push_back(n);
  return ans;
}
vector<ll> factors(ll n) {
  vector<ll> ans;
  for (int i = 2; i * i <= n; i++) {
    if (n % i == 0) {
      ans.push_back(i);
      if (n / i != i) {
        ans.push_back(n / i);
      }
    }
  }
  return ans;
}
void computeLPSArray(string pat, int M, int* lps);
int KMPSearch(string pat, string txt) {
  int M = pat.size();
  int N = txt.size();
  int lps[M];
  computeLPSArray(pat, M, lps);
  int i = 0;
  int j = 0;
  int ans = 0;
  while (i < N) {
    if (pat[j] == txt[i]) {
      j++;
      i++;
    }
    if (j == M) {
      ans++;
      j = lps[j - 1];
    } else if (i < N && pat[j] != txt[i]) {
      if (j != 0)
        j = lps[j - 1];
      else
        i = i + 1;
    }
  }
  return ans;
}
void computeLPSArray(string pat, int M, int* lps) {
  int len = 0;
  lps[0] = 0;
  int i = 1;
  while (i < M) {
    if (pat[i] == pat[len]) {
      len++;
      lps[i] = len;
      i++;
    } else {
      if (len != 0) {
        len = lps[len - 1];
      } else {
        lps[i] = 0;
        i++;
      }
    }
  }
}
ll nCrModp(ll n, ll r, ll p) {
  if (r > n - r) r = n - r;
  ll C[r + 1];
  memset(C, 0, sizeof(C));
  C[0] = 1;
  for (ll i = 1; i <= n; i++) {
    for (ll j = min(i, r); j > 0; j--) C[j] = (C[j] + C[j - 1]) % p;
  }
  return C[r];
}
bool cmp(vector<double>& a, vector<double>& b) {
  if (a[3] > b[3])
    return true;
  else if (a[3] < b[3])
    return false;
  else
    return a[2] < b[2];
}
ll cnt = 0;
void dfsutil(vector<bool>& vis, ll src, ll n, ll k) {
  vis[src] = 1;
  cnt++;
  for (ll i = 0; i < (k); ++i) {
    if ((src - i) >= 0 && (src + k - i - 1) < n && !vis[src - i - i + k - 1])
      dfsutil(vis, src - i - i + k - 1, n, k);
  }
}
void dfs(vector<bool>& vis, ll n, ll m, ll k) {
  ll c = 0;
  for (ll i = 0; i < (n); ++i) {
    if (vis[i] == false) {
      dfsutil(vis, i, n, k);
      c++;
    }
  }
  ll ans = 1;
  for (ll i = 0; i < (c); ++i) {
    ans = (ans * m) % MOD;
  }
  cout << ans;
}
ll dx[] = {0, 0, 1, 1, 1, -1, -1, -1};
ll dy[] = {1, -1, -1, 0, 1, -1, 0, 1};
void solve() {
  ll x1, y1, x2, y2;
  cin >> x1 >> y1 >> x2 >> y2;
  ll n;
  cin >> n;
  map<pair<ll, ll>, ll> m1, m2;
  for (ll i = 0; i < (n); ++i) {
    ll x, y, z;
    cin >> x >> y >> z;
    for (ll j = y; j <= (z); ++j) m1[{x, j}] = 1;
  }
  queue<pair<pair<ll, ll>, ll>> q;
  m2[{x1, y1}] = 1;
  q.push({{x1, y1}, 0});
  while (!q.empty()) {
    auto ele = q.front();
    q.pop();
    if (ele.first.first == x2 && ele.first.second == y2) {
      cout << ele.second << "\n";
      return;
    }
    for (ll i = 0; i < (8); ++i) {
      ll x = ele.first.first + dx[i], y = ele.first.second + dy[i];
      if (m1.find({x, y}) != m1.end() && m2.find({x, y}) == m2.end()) {
        m2[{x, y}] = 1;
        q.push({{x, y}, ele.second + 1});
      }
    }
  }
  cout << "-1";
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  ll t = 1;
  while (t--) solve();
  return 0;
}
