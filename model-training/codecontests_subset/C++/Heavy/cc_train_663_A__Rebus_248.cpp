#include <bits/stdc++.h>
using namespace std;
char buf[1010];
pair<vector<int>, int> Parse() {
  pair<vector<int>, int> res;
  stringstream ss;
  ss << buf;
  string tok;
  int sgn = 1;
  while (ss >> tok) {
    if (tok[0] == '?')
      res.first.push_back(sgn);
    else if (tok[0] == '+')
      sgn = 1;
    else if (tok[0] == '-')
      sgn = -1;
    else
      res.second = atoi(tok.c_str());
  }
  return res;
}
int main() {
  gets(buf);
  auto expr = Parse();
  long long add = count(expr.first.begin(), expr.first.end(), 1);
  long long sub = count(expr.first.begin(), expr.first.end(), -1);
  long long alo = add * 1, ahi = add * expr.second;
  long long rlo = sub * 1, rhi = sub * expr.second;
  long long lo = alo - rhi, hi = ahi - rlo;
  if (expr.second < lo || expr.second > hi)
    puts("Impossible");
  else {
    puts("Possible");
    long long x, y;
    long long t = expr.second;
    if (rlo <= ahi - t && rhi >= ahi - t) x = ahi, y = ahi - t;
    if (rlo <= alo - t && rhi >= alo - t) x = alo, y = alo - t;
    if (alo <= t + rlo && ahi >= t + rlo) x = t + rlo, y = rlo;
    if (alo <= t + rhi && ahi >= t + rhi) x = t + rhi, y = rhi;
    vector<int> plus(add, 1);
    vector<int> minus(sub, 1);
    x -= add, y -= sub;
    for (int i = 0; i < add; ++i) {
      long long rem = min(x, t - 1);
      plus[i] += rem;
      x -= rem;
    }
    for (int i = 0; i < sub; ++i) {
      long long rem = min(y, t - 1);
      minus[i] += rem;
      y -= rem;
    }
    for (int i = 0; i < ((int)(expr.first).size()); ++i) {
      if (i) printf(" %c ", expr.first[i] > 0 ? '+' : '-');
      if (expr.first[i] > 0) printf("%d", plus.back()), plus.pop_back();
      if (expr.first[i] < 0) printf("%d", minus.back()), minus.pop_back();
    }
    printf(" = %d\n", expr.second);
  }
  return 0;
}
