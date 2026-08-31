#include <bits/stdc++.h>
using namespace std;
long long power(long long x, long long y) {
  long long res = 1;
  while (y) {
    if (y & 1) res = (res * x) % 998244353;
    y = y / 2, x = (x * x) % 998244353;
  }
  return res % 998244353;
}
long long n, k;
const long long BLSZ = 300;
long long NUMBL;
inline long long getBL(long long i) { return i / BLSZ; }
inline long long getL(long long i) { return i * BLSZ; }
inline long long getR(long long i) { return min((i + 1) * BLSZ - 1, n - 1); }
inline void add(long long &a, long long b) {
  a += b;
  if (a >= 998244353) a -= 998244353;
}
long long base[100100];
long long arr[100100];
long long dp[100100];
vector<vector<long long> > pos(100100);
struct block {
  long long l, r;
  long long offset;
  long long pref[BLSZ];
  void init(long long _l, long long _r, long long val) {
    l = (_l), r = (_r), offset = (val);
  }
  void recalc() {
    long long smallest = 1e18;
    long long i;
    for (i = l; i <= r; i++) smallest = min(smallest, base[i] + offset);
    for (i = l; i <= r; i++) {
      base[i] = base[i] - smallest + offset;
    }
    offset = smallest;
    for (i = 0; i < BLSZ; i++) pref[i] = 0;
    for (i = l; i <= r; i++) {
      add(pref[base[i]], dp[i]);
    }
    for (i = 1; i < BLSZ; i++) add(pref[i], pref[i - 1]);
  }
};
block *BARR;
void init() {
  NUMBL = getBL(n - 1);
  BARR = new block[NUMBL + 1];
  for (long long i = 0; i <= NUMBL; i++) {
    BARR[i].init(getL(i), getR(i), 0);
    BARR[i].recalc();
  }
}
void update(long long l, long long r, long long diff) {
  if (getBL(l) == getBL(r)) {
    for (long long i = l; i <= r; ++i) {
      base[i] += diff;
    }
    BARR[getBL(l)].recalc();
  } else {
    long long x = getBL(l);
    for (long long i = l; i <= getR(x); i++) {
      base[i] += diff;
    }
    BARR[x].recalc();
    x = getBL(r);
    for (long long i = r; i >= getL(x); i--) {
      base[i] += diff;
    }
    BARR[x].recalc();
    for (long long i = getBL(l) + 1; i < getBL(r); i++) {
      BARR[i].offset += diff;
    }
  }
}
long long query(long long l, long long r) {
  long long ans = 0;
  if (getBL(l) == getBL(r)) {
    long long x = getBL(l);
    for (long long i = l; i <= r; ++i) {
      if (base[i] + BARR[x].offset <= k) add(ans, dp[i]);
    }
    return ans;
  } else {
    long long x = getBL(l);
    for (long long i = l; i <= getR(x); i++) {
      if (base[i] + BARR[x].offset <= k) add(ans, dp[i]);
    }
    x = getBL(r);
    for (long long i = r; i >= getL(x); i--) {
      if (base[i] + BARR[x].offset <= k) add(ans, dp[i]);
    }
    for (long long i = getBL(l) + 1; i < getBL(r); i++) {
      if (k - BARR[i].offset >= 0)
        add(ans, BARR[i].pref[min(k - BARR[i].offset, BLSZ - 1)]);
    }
    return ans;
  }
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> k;
  dp[0] = 1;
  init();
  long long i;
  for (i = 0; i < n; i++) {
    cin >> arr[i];
    dp[i + 1] = 0;
    if (pos[arr[i]].size() == 0) {
      update(0, i, 1);
    } else if (pos[arr[i]].size() == 1) {
      update(0, pos[arr[i]][0], -1);
      update(pos[arr[i]][0] + 1, i, 1);
    } else {
      update(pos[arr[i]][pos[arr[i]].size() - 2] + 1,
             pos[arr[i]][pos[arr[i]].size() - 1], -1);
      update(pos[arr[i]][pos[arr[i]].size() - 1] + 1, i, 1);
    }
    pos[arr[i]].push_back(i);
    dp[i + 1] = query(0, i);
    BARR[getBL(i + 1)].recalc();
  }
  cout << dp[n];
}
