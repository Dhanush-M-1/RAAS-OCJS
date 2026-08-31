#include <bits/stdc++.h>
#pragma GCC target("avx2")
#pragma GCC optimize("Ofast")
#pragma GCC optimize("unroll-loops")
using namespace std;
template <typename T>
T sqr(T a) {
  return a * a;
}
template <typename T>
int sign(T a) {
  if (a == 0) return 0;
  return (a > 0 ? 1 : -1);
}
template <typename T>
bool uax(T& a, const T b) {
  if (a < b) {
    a = b;
    return true;
  }
  return false;
}
template <typename T>
bool uin(T& a, const T b) {
  if (a > b) {
    a = b;
    return true;
  }
  return false;
}
template <typename T1, typename T2>
istream& operator>>(istream& in, pair<T1, T2>& p) {
  in >> p.first >> p.second;
  return in;
}
template <typename T1, typename T2>
ostream& operator<<(ostream& out, pair<T1, T2>& p) {
  out << p.first << ' ' << p.second;
  return out;
}
mt19937_64 rnd(0);
const int LOG = 64;
const int N = (int)1e5 + 7;
const int MAXN = (int)4e5 + 7;
const int MOD = (int)998244353;
const int INF = (int)2e9 + 7;
const int CONST = 450;
const long long LINF = (int64_t)1e15;
const long double PI = 3.1415926535897932384626433832795;
const long double EPS = 1;
struct Monster {
  int a, b, ind;
  Monster(){};
  Monster(int a, int b, int ind) : a(a), b(b), ind(ind){};
};
bool operator<(const Monster& a, const Monster& b) { return a.b < b.b; }
long long dp[100][100];
int par[100][100];
int n, k;
Monster mon[N];
void solve() {
  cin >> n >> k;
  for (int i = 1; i <= n; i++) {
    cin >> mon[i].a >> mon[i].b;
    mon[i].ind = i;
  }
  sort(mon + 1, mon + n + 1);
  for (int i = 0; i < 100; i++) {
    fill(dp[i], dp[i] + 100, -LINF);
    fill(par[i], par[i] + 100, -1);
  }
  dp[0][0] = 0;
  for (int i = 1; i <= n; i++) {
    par[i][0] = 0;
    dp[i][0] = dp[i - 1][0] + (k - 1) * mon[i].b;
    for (int j = 1; j <= k; j++) {
      if (dp[i - 1][j - 1] == -LINF && dp[i - 1][j] == -LINF) continue;
      if (dp[i - 1][j] == -LINF) {
        dp[i][j] = dp[i - 1][j - 1] + (j - 1) * mon[i].b + mon[i].a;
        par[i][j] = 1;
        continue;
      }
      if (dp[i - 1][j - 1] == -LINF) {
        dp[i][j] = dp[i - 1][j] + (k - 1) * mon[i].b;
        par[i][j] = 0;
        continue;
      }
      long long val1 = dp[i - 1][j - 1] + (j - 1) * mon[i].b + mon[i].a;
      long long val2 = dp[i - 1][j] + (k - 1) * mon[i].b;
      dp[i][j] = max(val1, val2);
      par[i][j] = (val1 >= val2 ? 1 : 0);
    }
  }
  int pos = n, cnt = k;
  vector<int> stay, rem;
  while (pos) {
    if (par[pos][cnt] == 0) {
      rem.push_back(mon[pos].ind);
      pos--;
    } else {
      stay.push_back(mon[pos].ind);
      pos--, cnt--;
    }
  }
  reverse(stay.begin(), stay.end()), reverse(rem.begin(), rem.end());
  cout << (int)stay.size() + 2 * (int)rem.size() << "\n";
  for (int i = 0; i < (int)stay.size() - 1; i++) cout << stay[i] << ' ';
  for (int x : rem) cout << x << ' ' << -x << ' ';
  cout << stay.back() << "\n";
}
int main() {
  double start = clock();
  cout << fixed << setprecision(20);
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  rnd.seed(time(0));
  int t = 1;
  cin >> t;
  for (int i = 0; i < t; i++) {
    solve();
  }
}
