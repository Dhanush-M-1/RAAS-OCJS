#include <bits/stdc++.h>
using namespace std;
using ll = long long;
template <typename t>
using V = vector<t>;
template <typename t>
void print(ostream& os, const t& a) {
  os << a << '\n';
}
template <typename t, typename... A>
void print(ostream& os, const t& a, A&&... b) {
  os << a << ' ';
  print(os, b...);
}
int n, d;
V<pair<int, int> > ilo;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  cin >> n >> d;
  int cnt = 0;
  int maks = 0;
  for (int i = 0; i < n; ++i) {
    int a;
    cin >> a;
    if (a == 0) {
      ilo.push_back({cnt, maks});
      cnt = 0;
      maks = 0;
    } else {
      cnt += a;
      maks = max(maks, cnt);
    }
  }
  ilo.push_back({cnt, maks});
  ;
  cnt = 0;
  int pt = 0;
  for (; pt < ilo.size(); ++pt) {
    if (cnt + ilo[pt].second > d) return print(cout, -1), 0;
    cnt += ilo[pt].first;
    if (cnt < 0) break;
    if (cnt > d) return print(cout, -1), 0;
  }
  if (pt == ilo.size()) return print(cout, 0), 0;
  if (pt == ilo.size() - 1) return print(cout, -1), 0;
  ;
  int res = 1;
  int lo = 0;
  int hi = d;
  for (int i = pt + 1; i < ilo.size(); ++i) {
    hi = min(hi, d - ilo[i].second);
    hi += ilo[i].first;
    hi = min(hi, d);
    lo += ilo[i].first;
    if (lo > hi) return print(cout, -1), 0;
    if (hi < 0) {
      if (i == ilo.size() - 1) break;
      ++res;
      lo = 0, hi = d;
    }
    lo = max(0, lo);
    ;
  }
  print(cout, res);
}
