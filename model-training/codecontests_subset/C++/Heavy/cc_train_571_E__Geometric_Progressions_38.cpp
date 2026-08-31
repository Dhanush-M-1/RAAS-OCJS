#include <bits/stdc++.h>
using namespace std;
const long long N = 2007;
const long long mod = 1e9 + 7;
const long long INF = 1e18;
long long Pow(long long x, long long y) {
  long long ans = 1, now = x;
  while (y) {
    if (y & 1) ans = ans * now % mod;
    now = now * now % mod;
    y >>= 1;
  }
  return ans;
}
long long gcd(long long x, long long y) { return y ? gcd(y, x % y) : x; }
map<long long, long long> mp;
void fw(long long x) {
  for (long long i = 2; i <= sqrt(x); i++) {
    if (x % i == 0) {
      while (x % i == 0) x /= i;
      mp[i] = 1;
    }
  }
  if (x > 1) mp[x] = 1;
}
long long a[N], b[N], t1[N], t2[N], vm[N], s1[N], s2[N], as[N], mt[N], dm[N],
    dc[N], yc[N];
long long e[10] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29}, qm[10], qc[10];
long long n, cnt = 0;
void ft(long long *gg, long long x) {
  long long nw = x;
  for (long long i = 1; i <= cnt; i++) {
    gg[i] = 0;
    while (nw % vm[i] == 0) {
      nw /= vm[i];
      gg[i]++;
    }
  }
}
bool check(long long *gg) {
  for (long long i = 1; i <= n; i++) {
    long long v = 0;
    ft(t1, a[i]);
    ft(t2, b[i]);
    for (long long j = 1; j <= cnt; j++) {
      if (gg[j] - t1[j]) {
        if (!t2[j]) return 0;
        if ((gg[j] - t1[j]) % t2[j] != 0) return 0;
        v = (gg[j] - t1[j]) / t2[j];
        break;
      }
    }
    for (long long j = 1; j <= cnt; j++)
      if (gg[j] != t1[j] + t2[j] * v) return 0;
  }
  return 1;
}
long long calc(long long *gg) {
  long long ans = 1;
  for (long long i = 1; i <= cnt; i++) ans = ans * Pow(vm[i], gg[i]) % mod;
  return ans;
}
int main() {
  scanf("%lld", &n);
  for (long long i = 1; i <= n; i++) {
    scanf("%lld%lld", &a[i], &b[i]);
    fw(a[i]);
    fw(b[i]);
  }
  if (n == 1) {
    printf("%lld\n", a[1]);
    return 0;
  }
  for (map<long long, long long>::iterator s = mp.begin(); s != mp.end(); s++) {
    vm[++cnt] = s->first;
    mp[s->first] = cnt;
  }
  for (long long i = 1; i <= n; i++) {
    if (b[i] == 1) {
      ft(as, a[i]);
      if (check(as))
        printf("%lld\n", a[i]);
      else
        puts("-1");
      return 0;
    }
  }
  for (long long i = 1; i <= n - 1; i++) {
    ft(t1, b[i]);
    ft(t2, b[i + 1]);
    bool fl = 0;
    long long ux, uy, d;
    for (long long j = 1; j <= cnt; j++)
      if (t1[j]) ux = t1[j], uy = t2[j], d = j;
    for (long long j = 1; j <= cnt; j++) {
      if (t1[j] * uy != t2[j] * ux) {
        ft(s1, a[i]);
        ft(s2, a[i + 1]);
        long long bb =
            (s2[d] * t1[j] - s2[j] * t1[d] + t1[d] * s1[j] - t1[j] * s1[d]);
        long long cc = t1[d] * t2[j] - t1[j] * t2[d];
        if (!cc) {
          puts("-1");
          return 0;
        }
        if (cc < 0) bb = -bb, cc = -cc;
        if (bb % cc != 0) {
          puts("-1");
          return 0;
        }
        long long y = bb / cc;
        if (y < 0) {
          puts("-1");
          return 0;
        }
        int ub = s2[d] - s1[d] + t2[d] * y;
        if (ub % t1[d] != 0) {
          puts("-1");
          return 0;
        }
        if (ub < 0) {
          puts("-1");
          return 0;
        }
        for (long long k = 1; k <= cnt; k++) as[k] = s2[k] + t2[k] * y;
        if (check(as))
          printf("%lld\n", calc(as));
        else
          puts("-1");
        return 0;
      }
    }
  }
  long long mi = INF, hd;
  for (long long i = 1; i <= n; i++) mi = min(mi, a[i]);
  ft(t1, b[1]);
  for (long long i = 1; i <= cnt; i++) mt[i] = t1[i];
  for (long long i = 1; i <= cnt; i++)
    if (mt[i]) {
      hd = i;
      break;
    }
  dm[1] = t1[hd];
  for (long long i = 2; i <= n; i++) {
    ft(t1, b[i]);
    dm[i] = t1[hd];
    for (long long j = 1; j <= cnt; j++) mt[j] = gcd(mt[j], t1[j]);
  }
  ft(t1, mi);
  for (long long i = 1; i <= n; i++) {
    ft(t2, a[i]);
    dc[i] = t2[hd];
    long long ls = -1;
    for (long long j = 1; j <= cnt; j++) {
      if (!mt[j]) continue;
      if ((t2[j] - t1[j]) % mt[j] != 0) {
        puts("-1");
        return 0;
      }
      if (ls < 0)
        ls = (t2[j] - t1[j]) / mt[j];
      else if (t2[j] != t1[j] + mt[j] * ls) {
        puts("-1");
        return 0;
      }
    }
  }
  for (long long i = 0; i <= 10 - 1; i++) qm[i] = 1, qc[i] = 0;
  for (long long i = 1; i <= n; i++) {
    yc[i] = dc[i];
    dc[i] %= dm[i];
    for (long long j = 0; j <= 10 - 1; j++) {
      long long gg = 1, nw = dm[i];
      while (nw % e[j] == 0) gg *= e[j], nw /= e[j];
      long long ng = dc[i] % gg;
      if (gg >= qm[j]) {
        if (ng % qm[j] != qc[j]) {
          puts("-1");
          return 0;
        }
        qm[j] = gg;
        qc[j] = ng;
      } else {
        if (qc[j] % gg != ng) {
          puts("-1");
          return 0;
        }
      }
    }
  }
  long long S = 0, mm = 1;
  for (long long i = 0; i <= 10 - 1; i++) {
    if (qm[i] == 1) continue;
    long long sc = 1;
    for (long long j = 0; j <= 10 - 1; j++)
      if (i != j) sc *= qm[j];
    long long mc = sc % qm[i], iv;
    for (long long j = 0; j <= qm[i] - 1; j++)
      if (j * mc % qm[i] == 1) {
        iv = j;
        break;
      }
    iv = iv * qc[i] % qm[i];
    S += sc * iv;
    mm *= qm[i];
  }
  S %= mm;
  for (long long i = 1; i <= n; i++)
    while (S < yc[i]) S += mm;
  ft(t1, a[1]);
  ft(t2, b[1]);
  for (long long i = 1; i <= cnt; i++)
    as[i] = t2[i] * ((S - dc[1]) / dm[1]) + t1[i];
  printf("%lld\n", calc(as));
  return 0;
}
