#include <bits/stdc++.h>
using namespace std;
int n, k;
int a[100007];
long long dp[100007];
int prv1[100007];
int prv2[100007];
class bucket {
 public:
  int st, en;
  long long pref[300 + 2];
  int val[300 + 2];
  int mn = 0;
  void recalc() {
    int curr = val[0];
    for (int i = st; i <= en; ++i) {
      curr = (curr < val[i - st]) ? curr : val[i - st];
    }
    mn += curr;
    for (int i = st; i <= en; ++i) {
      val[i - st] -= curr;
    }
    for (int i = 0; i <= 300; ++i) {
      pref[i] = 0;
    }
    for (int i = st; i <= en; ++i) {
      pref[val[i - st]] = pref[val[i - st]] + ((i > 0) ? dp[i - 1] : 1);
      if (pref[val[i - st]] >= 998244353) {
        pref[val[i - st]] -= 998244353;
      }
    }
    for (int i = 1; i <= 300; ++i) {
      pref[i] += pref[i - 1];
      if (pref[i] >= 998244353) {
        pref[i] -= 998244353;
      }
    }
  }
  void update(int add) { mn += add; }
  long long ask() {
    if (mn > k) {
      return 0;
    }
    int id = (k - mn);
    if (id > 300) {
      id = 300;
    }
    return pref[id];
  }
};
bucket f[2 * 300];
int NUM_BUCKETS;
void input() {
  scanf("%d%d", &n, &k);
  for (int i = 0; i < n; ++i) {
    scanf("%d", &a[i]);
    prv1[a[i]] = prv2[a[i]] = -1;
  }
  NUM_BUCKETS = (n / 300) + ((n % 300) != 0);
  for (int i = 0; i < NUM_BUCKETS; ++i) {
    f[i].st = i * 300;
    f[i].en = min(f[i].st + 300 - 1, n - 1);
  }
}
void upd_int(int st, int en, int val) {
  if (en < st) {
    return;
  }
  if (en - st <= 300) {
    for (int i = st; i <= en; ++i) {
      int id = (i / 300);
      f[id].val[i - f[id].st] += val;
    }
    f[(st / 300)].recalc();
    for (int i = st + 1; i <= en; ++i) {
      if ((i / 300) != ((i - 1) / 300)) {
        f[(i / 300)].recalc();
      }
    }
    return;
  }
  for (int i = st; i <= en; ++i) {
    if ((i / 300) != (st / 300)) {
      break;
    }
    int id = (i / 300);
    f[id].val[i - f[id].st] += val;
  }
  f[(st / 300)].recalc();
  for (int i = en; i >= st; --i) {
    if ((i / 300) != (en / 300)) {
      break;
    }
    int id = (i / 300);
    f[id].val[i - f[id].st] += val;
  }
  f[(en / 300)].recalc();
  for (int i = (st / 300) + 1; i < (en / 300); ++i) {
    f[i].update(val);
  }
}
void solve() {
  for (int i = 0; i < n; ++i) {
    upd_int(prv2[a[i]] + 1, prv1[a[i]], -1);
    prv2[a[i]] = prv1[a[i]];
    upd_int(prv1[a[i]] + 1, i, 1);
    prv1[a[i]] = i;
    for (int j = 0; j <= (i / 300); ++j) {
      dp[i] += f[j].ask();
      dp[i] = (dp[i] < 998244353) ? dp[i] : dp[i] - 998244353;
    }
  }
  printf("%I64d\n", dp[n - 1]);
}
int main() {
  ios_base ::sync_with_stdio(false);
  cin.tie(NULL);
  input();
  solve();
  return 0;
}
