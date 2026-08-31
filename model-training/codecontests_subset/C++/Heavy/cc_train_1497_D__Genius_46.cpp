#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
typedef pair<int, int> pii;
#define FOR(i, a, b) for (int (i) = (a); (i) <= (b); (i)++)
#define ROF(i, a, b) for (int (i) = (a); (i) >= (b); (i)--)
#define REP(i, n) FOR(i, 0, (n)-1)
#define sqr(x) ((x) * (x))
#define all(x) (x).begin(), (x).end()
#define reset(x, y) memset(x, y, sizeof(x))
#define uni(x) (x).erase(unique(all(x)), (x).end())
#define BUG(x) cerr << #x << " = " << (x) << endl
#define pb push_back
#define eb emplace_back
#define mp make_pair
#define _1 first
#define _2 second
#define chkmin(a, b) a = min(a, b)
#define chkmax(a, b) a = max(a, b)

const int maxn = 5123;

int n;
int tag[maxn], s[maxn];
ll f[maxn];

void solve() {
  cin >> n;
  FOR(i, 1, n) cin >> tag[i];
  FOR(i, 1, n) cin >> s[i];
  f[1] = 0;
  FOR(i, 2, n) {
    f[i] = 0;
    vector<ll> g(n + 1);
    ROF(j, i - 1, 1) if (tag[i] != tag[j]) {
      g[j] = f[i] + abs(s[i] - s[j]);
      chkmax(f[i], f[j] + abs(s[i] - s[j]));
    }
    FOR(j, 1, i) chkmax(f[j], g[j]);
  }
  ll ans = 0;
  FOR(i, 1, n) chkmax(ans, f[i]);
  cout << ans << '\n';
}

int main() {
#ifdef ONLINE_JUDGE
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
#endif
  int T; cin >> T;
  while (T--) solve();
}
