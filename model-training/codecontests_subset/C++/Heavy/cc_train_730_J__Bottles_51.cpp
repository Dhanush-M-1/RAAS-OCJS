#include <bits/stdc++.h>
using namespace std;
template <typename T>
bool bitcheck(T p, T pos) {
  return (bool)(p & (1 << pos));
}
template <typename T>
T biton(T p, T pos) {
  return p = p | (1 << pos);
}
template <typename T>
T bitoff(T p, T pos) {
  return p = p & ~(1 << pos);
}
template <typename T>
long long int toint(T s) {
  long long int p;
  stringstream ss(s);
  ss >> p;
  return p;
}
template <typename T>
string tostring(T n) {
  stringstream ss;
  ss << n;
  return ss.str();
}
template <typename T>
T POW(T b, T p) {
  T Ans = 1;
  while (p) {
    if (p & 1) Ans = (Ans * b);
    b = (b * b);
    p >>= 1;
  }
  return Ans;
}
template <typename T>
T BigMod(T b, T p, T Mod) {
  T Ans = 1;
  while (p) {
    if (p & 1) Ans = (Ans * b) % Mod;
    b = (b * b) % Mod;
    p >>= 1;
  }
  return Ans;
}
template <typename T>
T ModInverse(T p, T Mod) {
  return BigMod(p, Mod - 2, Mod);
}
const int fx[] = {+0, +0, +1, -1, -1, +1, -1, +1};
const int fy[] = {-1, +1, +0, +0, +1, +1, -1, -1};
const int mx = 1e5 + 10;
const long long int inf = (long long int)1e9;
const int mod = 1e9 + 7;
const double pi = 2 * acos(0.0);
const double E = 2.71828182845904523536;
const double eps = 1e-9;
bool mark[mx];
vector<int> prime;
void sieve() {
  memset(mark, true, sizeof(mark));
  for (int i = 3; i <= (int)sqrt(mx); i += 2) {
    if (mark[i]) {
      for (int j = i * i; j <= mx; j += 2 * i) mark[j] = false;
    }
  }
  prime.push_back(2);
  for (int i = 3; i <= mx; i += 2)
    if (mark[i]) prime.push_back(i);
}
long long int a[110], total, n;
vector<pair<long long int, long long int> > v;
pair<long long int, long long int> dp[110][10010];
bool vis[110][10010];
pair<long long int, long long int> boss(long long int i, long long int s) {
  if (i == n && s < total) return {inf, inf};
  if (i == n && s >= total) return {0, 0};
  if (vis[i][s]) return dp[i][s];
  vis[i][s] = 1;
  pair<long long int, long long int> p1 =
      make_pair(1 + boss(i + 1, s + v[i].first).first,
                boss(i + 1, s + v[i].first).second);
  pair<long long int, long long int> p2 =
      make_pair(boss(i + 1, s).first, v[i].second + boss(i + 1, s).second);
  return dp[i][s] = min(p1, p2);
}
int main() {
  total = 0;
  cin >> n;
  for (int i = 0; i <= n - 1; i++) {
    cin >> a[i];
    total += a[i];
  }
  for (int i = 0; i <= n - 1; i++) {
    long long int k;
    cin >> k;
    v.push_back({k, a[i]});
  }
  pair<long long int, long long int> d = boss(0, 0);
  cout << d.first << " " << d.second << '\n';
  return 0;
}
