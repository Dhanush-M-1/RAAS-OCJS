#include <bits/stdc++.h>
using namespace std;
using ll = long long int;
using ii = pair<int, ll>;
using li = pair<ll, int>;
using vi = vector<ll>;
using vii = vector<ii>;
using graph = vector<vi>;
const ll MOD = 1000000007;
const int INF = 0x3f3f3f3f;
const ll INFL = 0x3f3f3f3f3f3f3f3f;
const int MAXN = 312345;
const double PI = 3.14159265359;
const double EPS = 0.000000001;
ll cost[8][MAXN];
ll dp[15][MAXN];
vi o, t, s;
void process(int j) {
  for (int i = 1; i <= 6; ++i) {
    cost[i][j] = 0;
  }
  sort(o.begin(), o.end());
  sort(t.begin(), t.end());
  sort(s.begin(), s.end());
  if (o.size() >= 1) {
    cost[1][j] = -o[0];
    cost[4][j] = cost[1][j] << 1;
  }
  if (o.size() >= 2) {
    cost[2][j] = -(o[0] + o[1]);
    cost[5][j] = cost[2][j] - o[0];
  }
  if (o.size() >= 3) {
    for (int i = 0; i < 3; ++i) {
      cost[3][j] += -o[i];
    }
    cost[6][j] = cost[3][j] - o[0];
  }
  if (t.size() >= 1) {
    cost[1][j] = max(cost[1][j], -t[0]);
    cost[4][j] = cost[1][j] << 1;
    if (o.size() >= 1) {
      cost[2][j] = max(cost[2][j], -(o[0] + t[0]));
      cost[5][j] = max(cost[5][j], -(o[0] + t[0] + min(o[0], t[0])));
    }
  }
  if (s.size() >= 1) {
    cost[1][j] = max(cost[1][j], -s[0]);
    cost[4][j] = cost[1][j] << 1;
  }
}
int n;
ll sol(int i, int r) {
  if (i > n) return 0;
  if (dp[r][i]) return dp[r][i];
  ll ans = 0;
  ans = sol(i + 1, r);
  for (int j = 1; j <= 3; ++j) {
    if (r >= 10 - j && cost[3 + j][i]) {
      ans = max(ans, cost[3 + j][i] + sol(i + 1, (r + j) % 10));
    } else if (cost[j][i]) {
      ans = max(ans, cost[j][i] + sol(i + 1, (r + j) % 10));
    }
  }
  return dp[r][i] = ans;
}
int main() {
  scanf("%d", &n);
  for (int j = 1, q, a, b; j <= n; ++j) {
    scanf("%d", &q);
    o.clear();
    t.clear();
    s.clear();
    while (q--) {
      scanf("%d %d", &a, &b);
      if (a == 1) {
        o.push_back(-b);
      } else if (a == 2) {
        t.push_back(-b);
      } else {
        s.push_back(-b);
      }
    }
    process(j);
  }
  printf("%lld\n", sol(1, 0));
}
