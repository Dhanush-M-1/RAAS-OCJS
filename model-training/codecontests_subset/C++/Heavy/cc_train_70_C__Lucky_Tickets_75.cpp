#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:268435456")
using namespace std;
template <typename T>
inline T abs(T a) {
  return ((a < 0) ? -a : a);
}
template <typename T>
inline T sqr(T a) {
  return a * a;
}
template <class T>
T gcd(T a, T b) {
  return a ? gcd(b % a, a) : b;
}
template <class T>
T lcm(T a, T b) {
  return a / gcd(a, b) * b;
}
template <class T>
T sign(T a) {
  return a > 0 ? 1 : (a < 0 ? -1 : 0);
}
const int dx[] = {-1, 0, 1, 0};
const int dy[] = {0, 1, 0, -1};
const int dxK[] = {-1, -1, 0, 1, 1, 1, 0, -1};
const int dyK[] = {0, 1, 1, 1, 0, -1, -1, -1};
const int dxKn[] = {-2, -1, 1, 2, 2, 1, -1, -2};
const int dyKn[] = {1, 2, 2, 1, -1, -2, -2, -1};
const int N = int(1e5) + 9;
const int M = int(3e3) + 9;
const int LOGN = 22;
const int SQN = 350;
const int MOD = int(1e9) + 7;
const int INF = 1e9 + 100;
const long long INF64 = 2e18;
const long double PI = 3.1415926535897932384626433832795;
const long double EPS = 1e-9;
int n, m, k;
map<pair<int, int>, int> cnt;
map<pair<int, int>, int> cur;
int rev[N];
int getrev(int x) {
  int res = 0;
  while (x) {
    res = res * 10 + (x % 10);
    x /= 10;
  }
  return res;
}
pair<int, int> norm(pair<int, int> a) {
  int g = gcd(a.first, a.second);
  a.first /= g, a.second /= g;
  return a;
}
void solve() {
  for (int i = 0; i < (int)(N); ++i) rev[i] = getrev(i);
  cin >> n >> m >> k;
  long long x = INF, y = INF;
  for (int i = 1; i < (int)(n + 1); ++i) cnt[norm(make_pair(i, rev[i]))]++;
  long long res = 0;
  int i = n;
  for (int j = 1; j < (int)(m + 1); ++j) {
    res += cnt[norm(make_pair(rev[j], j))];
    ++cur[norm(make_pair(rev[j], j))];
    while (i > 1 && res - cur[norm(make_pair(i, rev[i]))] >= k)
      res -= cur[norm(make_pair(i, rev[i]))], --cnt[norm(make_pair(i, rev[i]))],
          --i;
    if (res >= k && x * y > i * 1LL * j) x = i, y = j;
  }
  if (x == INF)
    cout << -1;
  else
    cout << x << ' ' << y;
}
int main() {
  srand(time(NULL));
  cout << setprecision(10) << fixed;
  cerr << setprecision(10) << fixed;
  solve();
  return 0;
}
