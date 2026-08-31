#include <bits/stdc++.h>
using namespace std;
struct R {
  long long int nd, i;
};
int main() {
  long long int n, l, r, st;
  scanf("%*d");
  while (~scanf("%lld %lld %lld", &n, &l, &r)) {
    long long int p, i, j, nd;
    vector<R> v;
    v.push_back({1, 1});
    for (p = 1, i = 2, j = n - 1; i < n; i++, j--) v.push_back({i, p += j + j});
    long long int st = 0, en = v.size() - 1, md, pos = -1;
    while (st <= en) {
      md = (st + en) / 2;
      if (v[md].i > l)
        en = md - 1;
      else {
        pos = max(pos, md);
        st = md + 1;
      }
    }
    vector<R> pet;
    for (nd = v[pos].nd, i = v[pos].i; i <= r && nd < n; nd++) {
      for (j = nd + 1; j <= n && i <= r; j++)
        pet.push_back({nd, i++}), pet.push_back({j, i++});
    }
    if (nd == n) pet.push_back({1, i++});
    for (auto it : pet)
      if (it.i >= l && it.i <= r) printf("%lld ", it.nd);
    puts("");
  }
  return 0;
}
