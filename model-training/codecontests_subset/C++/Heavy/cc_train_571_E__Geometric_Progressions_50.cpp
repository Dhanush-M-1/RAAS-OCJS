#include <bits/stdc++.h>
using namespace std;
int n;
int a[110], b[110], c[110], d[110];
vector<int> stdprimes;
vector<int> sepra(int x) {
  vector<int> res = vector<int>();
  for (int i = 2; i * i <= x; i++) {
    if (x % i == 0) {
      res.push_back(i);
      while (x % i == 0) x /= i;
    }
  }
  if (x != 1) res.push_back(x);
  return res;
}
struct record {
  vector<int> stdpows;
  vector<int> extrapr;
  vector<int> extrapo;
  record() {
    stdpows.clear();
    extrapr.clear();
    extrapo.clear();
  }
  record(int x) {
    for (int i = 0; i < stdprimes.size(); i++) {
      stdpows.push_back(0);
      while (x % stdprimes[i] == 0) {
        x /= stdprimes[i];
        stdpows.back()++;
      }
    }
    for (int i = 2; i * i <= x; i++) {
      if (x % i == 0) {
        extrapr.push_back(i);
        extrapo.push_back(0);
        while (x % i == 0) {
          x /= i;
          extrapo.back()++;
        }
      }
    }
    if (x != 1) {
      extrapr.push_back(x);
      extrapo.push_back(1);
    }
  }
};
inline long long quickpow(long long base, long long ind) {
  long long ans = 1;
  while (ind > 0) {
    if (ind & 1) ans = ans * base % 1000000007;
    ind >>= 1;
    base = base * base % 1000000007;
  }
  return ans;
}
inline void mul(long long &a, long long b) { a = a * b % 1000000007; }
inline long long extgcd(long long a, long long b, long long &x, long long &y) {
  if (!b) {
    x = 1, y = 0;
    return a;
  }
  long long g = extgcd(b, a % b, y, x);
  y = y - a / b * x;
  return g;
}
void combine(long long &a1, long long &m1, int a2, int m2) {
  long long c = a2 - a1;
  long long a = m1, b = m2;
  long long x, y, g;
  g = extgcd(a, b, x, y);
  if (c % g != 0) {
    cout << -1;
    exit(0);
  }
  long long b1 = b / g;
  long long x1 = ((x + b1) * c / g);
  x1 = (x1 % b1 + b1) % b1;
  long long y1 = ((c - a * x1) / b);
  a1 = a1 + m1 * x1;
  m1 = m1 * m2 / g;
}
void trysingle(int id, int pos) {
  stdprimes.clear();
  record fst(a[id]);
  stdprimes = fst.extrapr;
  record ratio(b[id]);
  for (int i = 0; i < ratio.extrapr.size(); i++)
    stdprimes.push_back(ratio.extrapr[i]);
  fst = record(a[id]);
  ratio = record(b[id]);
  vector<int> cnt;
  for (int i = 0; i < fst.stdpows.size(); i++) {
    cnt.push_back(fst.stdpows[i]);
    cnt.back() += ratio.stdpows[i] * pos;
  }
  for (int i = 0; i < n; i++) {
    record curfst(a[i]);
    record currat(b[i]);
    if (!curfst.extrapr.empty()) {
      cout << -1;
      exit(0);
    }
    int curneed = -1;
    for (int j = 0; j < stdprimes.size(); j++) {
      if (curfst.stdpows[j] > cnt[j]) {
        cout << -1;
        exit(0);
      }
      int need = cnt[j] - curfst.stdpows[j];
      if (!currat.stdpows[j]) {
        if (need) {
          cout << -1;
          exit(0);
        }
        continue;
      } else if (need % currat.stdpows[j] != 0) {
        cout << -1;
        exit(0);
      }
      need /= currat.stdpows[j];
      if (curneed == -1)
        curneed = need;
      else if (curneed != need) {
        cout << -1;
        exit(0);
      }
    }
    if (curneed > 0 && !currat.extrapr.empty()) {
      cout << -1;
      exit(0);
    }
  }
  long long ans = a[id];
  mul(ans, quickpow(b[id], pos));
  cout << ans;
  exit(0);
}
int main() {
  cin >> n;
  for (int i = 0; i < n; i++) cin >> a[i] >> b[i];
  for (int i = 0; i < n; i++)
    if (b[i] == 1) trysingle(i, 0);
  if (n == 1) {
    cout << a[0];
    return 0;
  }
  stdprimes = sepra(b[0]);
  record fst(a[0]);
  record ratio(b[0]);
  c[0] = fst.stdpows[0];
  d[0] = ratio.stdpows[0];
  for (int i = 1; i < n; i++) {
    record curfst(a[i]);
    record currat(b[i]);
    if (!currat.extrapr.empty()) {
      int needPow = 0, p = currat.extrapr[0], pw = currat.extrapo[0];
      for (int j = 0; j < fst.extrapr.size(); j++) {
        if (fst.extrapr[j] == p) {
          needPow += fst.extrapo[j];
          break;
        }
      }
      for (int j = 0; j < curfst.extrapr.size(); j++) {
        if (curfst.extrapr[j] == p) {
          needPow -= curfst.extrapo[j];
          break;
        }
      }
      if (needPow < 0 || needPow % pw != 0) {
        cout << -1;
        return 0;
      }
      trysingle(i, needPow / pw);
    }
    c[i] = curfst.stdpows[0];
    d[i] = currat.stdpows[0];
    int fstpos = 0, errpos = -1;
    while (fstpos < stdprimes.size() && currat.stdpows[fstpos] == 0) fstpos++;
    int pow0 = ratio.stdpows[fstpos];
    int powi = currat.stdpows[fstpos];
    for (int j = 0; j < stdprimes.size(); j++) {
      if (ratio.stdpows[j] * powi != currat.stdpows[j] * pow0) {
        errpos = j;
        break;
      }
    }
    if (~errpos) {
      int s1 = fst.stdpows[fstpos], s2 = fst.stdpows[errpos];
      int t1 = curfst.stdpows[fstpos], t2 = curfst.stdpows[errpos];
      int u1 = ratio.stdpows[fstpos], u2 = ratio.stdpows[errpos];
      int v1 = currat.stdpows[fstpos], v2 = currat.stdpows[errpos];
      int mulx = u1 * v2 - u2 * v1;
      int eqa = t1 * v2 - t2 * v1 - s1 * v2 + s2 * v1;
      if (mulx == 0 || (abs(eqa) % abs(mulx) != 0) || eqa / mulx < 0) {
        cout << -1;
        return 0;
      }
      trysingle(0, eqa / mulx);
    }
    if (fst.extrapr.size() != curfst.extrapr.size()) {
      cout << -1;
      return 0;
    }
    for (int j = 0; j < fst.extrapr.size(); j++)
      if (fst.extrapr[j] != curfst.extrapr[j] ||
          fst.extrapo[j] != curfst.extrapo[j]) {
        cout << -1;
        return 0;
      }
    int dif = curfst.stdpows[0] - fst.stdpows[0];
    for (int j = 1; j < stdprimes.size(); j++) {
      int curdif = curfst.stdpows[j] - fst.stdpows[j];
      if (dif * ratio.stdpows[j] != curdif * ratio.stdpows[0]) {
        cout << -1;
        return 0;
      }
    }
  }
  long long ansC = c[0], ansD = d[0];
  for (int i = 1; i < n; i++) {
    combine(ansC, ansD, c[i], d[i]);
  }
  for (int i = 0; i < n; i++) {
    if (ansC < c[i]) {
      (ansC += ((c[i] - ansC + ansD - 1) / ansD) * ansD);
    }
  }
  long long ans = a[0];
  ansC /= ratio.stdpows[0];
  mul(ans, quickpow(b[0], ansC));
  cout << ans;
  return 0;
}
