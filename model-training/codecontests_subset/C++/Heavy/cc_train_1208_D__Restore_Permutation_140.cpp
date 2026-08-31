#include <bits/stdc++.h>
using namespace std;
using LL = long long;
using PII = pair<int, int>;
template <class T>
struct Fenwick {
  vector<T> v;
  Fenwick(size_t n) : v(n + 1) {}
  void add(size_t i, T x) {
    for (++i; i < v.size(); i += i & -i) v[i] += x;
  }
  T sum(size_t i) {
    for (v[0] = T(); i; i -= i & -i) v[0] += v.at(i);
    return v[0];
  }
  T sum(size_t l, size_t r) { return sum(r) - sum(l); }
};
const int N = 2e5 + 5;
int n, a[N];
LL s[N];
int main() {
  cin >> n;
  Fenwick<LL> fw(N);
  for (int i = (1); i <= (n); ++i) scanf("%lld", &s[i]), fw.add(i, i);
  for (int i = n; i >= 1; i--) {
    int l = 0, r = n;
    while (l + 1 < r) {
      int m = (l + r) >> 1;
      LL sum = fw.sum(m + 1);
      if (sum <= s[i])
        l = m;
      else
        r = m;
    }
    a[i] = l + 1;
    fw.add(l + 1, -(l + 1));
  }
  for (int i = 1; i <= n; i++) printf("%d%c", a[i], " \n"[i == n]);
}
