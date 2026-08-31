#include <bits/stdc++.h>
using namespace std;
const long long mdl = 1000000007LL;
void ext(long long a) {
  cout << a << endl;
  exit(0);
}
void fil() { ext(-1); }
long long ab(long long a) { return a < 0 ? -a : a; }
long long gcd(long long a, long long b) {
  if (b == 0) return ab(a);
  return gcd(b, a % b);
}
void adr(long long& rs1, long long& rp1, long long s2, long long p2) {
  long long s1 = rs1;
  long long p1 = rp1;
  long long g = gcd(p1, p2);
  if ((s2 - s1) % g) fil();
  long long np = p1 / g * p2;
  swap(p1, p2);
  swap(s1, s2);
  if (s2 < s1) {
    s2 += p2 * ((s1 - s2 + p2 - 1) / p2);
  }
  long long gm = (s1 - s2) % p1;
  if (gm < 0) gm += p1;
  long long k;
  for (k = 0; k < p1; k++) {
    if (p2 % p1 * k % p1 == gm) {
      break;
    }
  }
  assert(k < p1);
  rs1 = s2 + k * p2;
  rp1 = np;
}
long long pw(long long a, long long b) {
  long long r = 1;
  for (long long i = 62; i >= 0; i--) {
    r = r * r % mdl;
    if (b & (1LL << i)) r = r * a % mdl;
  }
  return r;
}
void fl(long long a, map<long long, long long>& tp) {
  for (long long i = 2; i * i <= a; i++) {
    if (a % i == 0) {
      long long cc = 0;
      while (a % i == 0) {
        a /= i;
        cc++;
      }
      tp[i] = cc;
    }
  }
  if (a != 1) tp[a] = 1;
}
long long n;
vector<long long> a, b;
vector<map<long long, long long> > apw, bpw;
void rcb(long long id, map<long long, long long> npw) {
  long long crc = bpw[id].begin()->first;
  long long crp = bpw[id].begin()->second;
  assert(crp);
  long long st = apw[id][crc];
  long long gl = npw[crc];
  if (gl < st) fil();
  if ((gl - st) % crp) fil();
  long long cf = (gl - st) / crp;
  for (auto i = (bpw[id]).begin(); i != (bpw[id]).end(); ++i) apw[id][i->first];
  for (auto i = (npw).begin(); i != (npw).end(); ++i) apw[id][i->first];
  for (auto i = (apw[id]).begin(); i != (apw[id]).end(); ++i)
    if (i->second + cf * bpw[id][i->first] != npw[i->first]) fil();
}
void mksol(long long id, long long cb) {
  map<long long, long long> npw;
  for (auto i = (apw[id]).begin(); i != (apw[id]).end(); ++i)
    npw[i->first] += i->second;
  if (cb != 0) {
    for (auto i = (bpw[id]).begin(); i != (bpw[id]).end(); ++i)
      npw[i->first] += cb * i->second;
  }
  for (long long j = 0; j < (n); ++j) {
    rcb(j, npw);
  }
  long long r = 1;
  for (auto i = (npw).begin(); i != (npw).end(); ++i) {
    r *= pw(i->first, i->second);
    r %= mdl;
  }
  ext(r);
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cin >> n;
  a.resize(n);
  b.resize(n);
  for (long long i = 0; i < (n); ++i) cin >> a[i] >> b[i];
  if (n == 1) ext(a[0]);
  for (long long i = 0; i < (n); ++i) {
    if (b[i] == 1) {
      for (long long j = 0; j < (n); ++j) {
        long long cc = a[i];
        if (cc % a[j]) fil();
        cc /= a[j];
        if (b[j] == 1 && cc != 1) fil();
        while (cc != 1) {
          if (cc % b[j]) fil();
          cc /= b[j];
        }
      }
      ext(a[i]);
    }
  }
  apw.resize(n);
  bpw.resize(n);
  for (long long i = 0; i < (n); ++i) {
    fl(a[i], apw[i]);
    fl(b[i], bpw[i]);
  }
  for (long long i = 0; i < (n); ++i) {
    for (long long j = 0; j < (n); ++j) {
      if (j == i) continue;
      long long fs = -1, sc, ca;
      for (auto it = (bpw[i]).begin(); it != (bpw[i]).end(); ++it) {
        if (!bpw[j].count(it->first)) {
          long long iapw = 0;
          if (apw[i].count(it->first)) iapw = apw[i][it->first];
          long long japw = 0;
          if (apw[j].count(it->first)) japw = apw[j][it->first];
          long long ibpw = it->second;
          if (japw < iapw) fil();
          if ((japw - iapw) % ibpw) fil();
          mksol(i, (japw - iapw) / ibpw);
        }
        long long cfs = it->second;
        long long csc = bpw[j][it->first];
        long long cca = 0;
        if (apw[i].count(it->first)) cca = apw[i][it->first];
        if (apw[j].count(it->first)) cca -= apw[j][it->first];
        long long g = gcd(cfs, csc);
        g = gcd(g, cca);
        cfs /= g;
        csc /= g;
        cca /= g;
        cca = -cca;
        if (fs == -1) {
          fs = cfs;
          sc = csc;
          ca = cca;
        } else {
          if (fs != cfs || sc != csc || ca != cca) {
            long long upr = cca * fs - ca * cfs;
            long long lwr = sc * cfs - csc * fs;
            long long x2 = 0;
            if (upr != 0) {
              if (lwr == 0) fil();
              if (upr % lwr) fil();
              x2 = upr / lwr;
            }
            upr = ca + sc * x2;
            lwr = fs;
            long long x1 = 0;
            if (upr != 0) {
              if (lwr == 0) fil();
              if (upr % lwr) fil();
              x1 = upr / lwr;
            }
            mksol(i, x1);
          }
        }
      }
    }
  }
  long long fpw = bpw[0].begin()->first;
  long long fsol = apw[0][fpw];
  long long per = bpw[0][fpw];
  for (long long i = 1; i < n; i++) {
    adr(fsol, per, apw[i][fpw], bpw[i][fpw]);
  }
  mksol(0, (fsol - apw[0][fpw]) / bpw[0][fpw]);
  return 0;
}
