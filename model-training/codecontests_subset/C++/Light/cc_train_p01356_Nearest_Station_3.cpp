#include <cstdio>
#include <cstring>
#include <cstdlib>
#include <cmath>
#include <string>
#include <vector>
#include <queue>
#include <map>
#include <set>
#include <algorithm>
#include <sstream>
#include <iostream>
#include <cassert>
using namespace std;

typedef long long ll;

#define REP(i, n) for (ll i = 0; i < (ll)(n); ++i)
#define FOR(i, a, b) for (ll i = (a); i < (ll)(b); ++i)
#define FOREQ(i, a, b) for (ll i = (a); i <= (ll)(b); ++i)
#define DEC(i, k) for (ll i = (k); i >= 0; --i)
#define FORIT(i, c) for (__tyoeof((c).begin()) i = (c).begin(); i != (c).end(); ++i)
#define SZ(v) (ll)((v).size())
#define MEMSET(v, h) memset((v), (h), sizeof(v))
#define FIND(m, w) ((m).find(w) != (m).end())
#define ALL(c) (c).begin(), (c).end()

ll ticket[1000];
ll ticketSum[1000];
ll n, m, a, b, p, q;
ll cnt;

ll calc(ll depth, ll lm) {
  if (depth == cnt || lm <= 0) { return abs(lm); }
  if (ticketSum[depth] < lm) { return abs(lm - ticketSum[depth]); }
  ll ret = m;
  ret = min(ret, calc(depth + 1, lm));
  ret = min(ret, calc(depth + 1, lm - ticket[depth]));
  return ret;
}

int main() {
  cin >> n >> m >> a >> b >> p >> q;
  if (a == 1 && b == 1) {
    ll use = m / (p + q);
    use = min(use, n - 1);
    printf("%lld\n", min(m - use * (p + q), abs(m - (use + 1) * (p + q))));
    return 0;
  }
  cnt = 0;
  {
    ll left = p;
    ll right = q;
    REP(i, n) {
      if (left + right > 2 * m) { break; }
      ticket[cnt++] = left + right;
      ll pleft = left;
      ll pright = right;
      left *= a;
      right *= b;
      if (left / a != pleft || right / b != pright) { break; }
    }
  }
  reverse(ticket, ticket + cnt);
  MEMSET(ticketSum, 0);
  for (ll i = cnt; i > 0; i--) {
    ticketSum[i - 1] = ticket[i - 1] + ticketSum[i];
  }
  ll ans = calc(0, m);
  printf("%lld\n", ans);
}