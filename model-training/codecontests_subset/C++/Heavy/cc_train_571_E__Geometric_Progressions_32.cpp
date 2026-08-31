#include <bits/stdc++.h>
using namespace std;
const int MX = 105;
const long long MOD = 1000000007;
template <typename T>
void read(T &x) {
  x = 0;
  char c = getchar();
  bool f = 0;
  while (!isdigit(c) && c != '-') c = getchar();
  if (c == '-') f = 1, c = getchar();
  while (isdigit(c)) x = x * 10 + c - '0', c = getchar();
  if (f) x = -x;
}
long long qpow(long long x, long long t) {
  long long ans = 1;
  while (t) {
    if (t & 1) ans = ans * x % MOD;
    x = x * x % MOD;
    t >>= 1;
  }
  return ans;
}
struct PRI {
  long long base, step;
  PRI(const long long &a = 0, const long long &b = 0) : base(a), step(b) {}
  PRI f(PRI x) const { return PRI(base + step * x.base, step * x.step); }
};
vector<pair<int, int> > GetDiv(int x) {
  vector<pair<int, int> > ret;
  for (int i = 2; i * i <= x; i++)
    if (x % i == 0) {
      int c = 0;
      while (x % i == 0) c++, x /= i;
      ret.push_back(make_pair(i, c));
    }
  if (x != 1) ret.push_back(make_pair(x, 1));
  return ret;
}
void Exgcd(long long x, long long y, long long &a, long long &b) {
  if (!y)
    a = 1, b = 0;
  else
    Exgcd(y, x % y, b, a), b -= (x / y) * a;
}
vector<int> prm;
int ax[MX], bx[MX];
vector<PRI> px[MX];
vector<PRI> GetPri(int a, int b) {
  vector<PRI> ret;
  vector<pair<int, int> > da = GetDiv(a), db = GetDiv(b);
  for (int i = 0; i < prm.size(); i++) {
    ret.push_back(PRI(0, 0));
    auto it = lower_bound(da.begin(), da.end(), make_pair(prm[i], 0));
    if (it != da.end() && it->first == prm[i]) ret.back().base = it->second;
    it = lower_bound(db.begin(), db.end(), make_pair(prm[i], 0));
    if (it != db.end() && it->first == prm[i]) ret.back().step = it->second;
  }
  return ret;
}
void Fuck() {
  puts("-1");
  exit(0);
}
long long Gcd(long long x, long long y) {
  if (y == 0)
    return x;
  else
    return Gcd(y, x % y);
}
pair<PRI, PRI> MinSolve(PRI e1, PRI e2) {
  if (!e1.step && !e2.step && e1.base != e2.base)
    Fuck();
  else if (!e1.step && !e2.step && e1.base == e2.base)
    return make_pair(PRI(0, 1), PRI(0, 1));
  else if (!e1.step) {
    long long delt = (e1.base - e2.base) / e2.step;
    if (e2.base + delt * e2.step != e1.base)
      Fuck();
    else
      return make_pair(PRI(0, 1), PRI(delt, 0));
  } else if (!e2.step) {
    long long delt = (e2.base - e1.base) / e1.step;
    if (e1.base + delt * e1.step != e2.base)
      Fuck();
    else if (delt < 0)
      Fuck();
    else
      return make_pair(PRI(delt, 0), PRI(0, 1));
  }
  long long g = Gcd(e1.step, e2.step);
  long long k1, k2;
  Exgcd(e1.step, e2.step, k1, k2);
  if ((e2.base - e1.base) % g) Fuck();
  long long delt1 = abs(e2.step / g), delt2 = abs(e1.step / g);
  k1 *= (e2.base - e1.base) / g, k2 *= -(e2.base - e1.base) / g;
  long long mov = max((k1 < 0) ? ((-k1 - 1) / delt1 + 1) : -(k1 / delt1),
                      (k2 < 0) ? ((-k2 - 1) / delt2 + 1) : -(k2 / delt2));
  k1 += delt1 * mov, k2 += delt2 * mov;
  return make_pair(PRI(k1, delt1), PRI(k2, delt2));
}
PRI CombineEquation(PRI e1, PRI e2) {
  PRI sol = MinSolve(e1, e2).first;
  return e1.f(sol);
}
long long SolveProgression(PRI e1, PRI e2) {
  if (e1.step == e2.step) {
    if (e1.base == e2.base)
      return -1;
    else
      Fuck();
  } else {
    long long r = e2.base - e1.base, l = e1.step - e2.step;
    if (r % l)
      Fuck();
    else if (r / l < 0)
      Fuck();
    else
      return r / l;
  }
}
int main() {
  int n;
  read(n);
  for (int i = 1; i <= n; i++) read(ax[i]), read(bx[i]);
  for (int i = 1; i <= n; i++) {
    auto da = GetDiv(ax[i]), db = GetDiv(bx[i]);
    for (auto j : da) prm.push_back(j.first);
    for (auto j : db) prm.push_back(j.first);
  }
  sort(prm.begin(), prm.end());
  prm.erase(unique(prm.begin(), prm.end()), prm.end());
  for (auto i : prm) px[0].push_back(PRI(0, 1));
  for (int i = 1; i <= n; i++) px[i] = GetPri(ax[i], bx[i]);
  for (int i = 2; i <= n; i++) {
    PRI now1(0, 1);
    for (int j = 0; j < prm.size(); j++) {
      auto tmp = MinSolve(px[i][j], px[i - 1][j]);
      now1 = CombineEquation(now1, tmp.first);
    }
    vector<PRI> pro;
    for (int j = 0; j < prm.size(); j++) {
      if (!px[i - 1][j].step) continue;
      PRI tmp((now1.base * px[i][j].step + px[i][j].base - px[i - 1][j].base) /
                  px[i - 1][j].step,
              now1.step * px[i][j].step / px[i - 1][j].step);
      pro.push_back(tmp);
    }
    long long lst = -1;
    for (int j = 0; j < pro.size(); j++)
      for (int k = j + 1; k < pro.size(); k++) {
        long long tmp = SolveProgression(pro[j], pro[k]);
        if (tmp != -1) {
          if (lst != -1) {
            if (lst != tmp) Fuck();
          } else
            lst = tmp;
        }
      }
    if (lst == -1)
      for (auto &it : px[i]) it = it.f(now1);
    else
      for (auto &it : px[i])
        it.base += it.step * (now1.step * lst + now1.base), it.step = 0;
  }
  long long ans = 1;
  for (int i = 0; i < prm.size(); i++)
    ans = ans * qpow(prm[i], px[n][i].base) % MOD;
  printf("%lld\n", ans);
  return 0;
}
