#include <bits/stdc++.h>
using namespace std;
struct segtree {
  long long int M = 1, INIT;
  vector<long long int> dat;
  segtree(long long int N, long long int num) {
    INIT = num;
    while (M < N) M *= 2;
    for (int i = 0; i < M * 2 - 1; i++) dat.push_back(num);
  }
  void update(long long int x, long long int k, long long int l = 0,
              int r = -1) {
    if (r == -1) r = M;
    k += M - 1;
    dat[k] += x;
    while (k > 0) k = (k - 1) / 2, dat[k] = dat[k * 2 + 1] + dat[k * 2 + 2];
  }
  long long int query(long long int a, long long int b = -1,
                      long long int k = 0, long long int l = 0,
                      long long int r = -1) {
    if (r == -1) r = M;
    if (b == -1) b = M;
    if (r <= a || b <= l) return INIT;
    if (a <= l && r <= b) return dat[k];
    long long int A = query(a, b, k * 2 + 1, l, (l + r) / 2);
    long long int B = query(a, b, k * 2 + 2, (l + r) / 2, r);
    return A + B;
  }
};
int main(int argc, char const *argv[]) {
  long long int n;
  scanf("%lld", &n);
  vector<vector<long long int> > l = vector<vector<long long int> >(
                                     0, vector<long long int>(3, 0)),
                                 r = vector<vector<long long int> >(
                                     0, vector<long long int>(3, 0));
  long long int b;
  map<long long int, long long int> mp, point;
  vector<long long int> x(n);
  for (long long int i = 0; i < n; i++) scanf("%lld", &x[i]);
  vector<vector<long long int> > d =
      vector<vector<long long int> >(n, vector<long long int>(3, 0));
  for (long long int i = 0; i < n; i++) {
    scanf("%lld", &b);
    d[i][0] = x[i], d[i][1] = b;
    if (b <= 0) l.push_back(vector<long long int>{x[i], abs(b), 0});
    if (b >= 0) r.push_back(vector<long long int>{x[i], abs(b), 0});
    mp.emplace(abs(b), 0);
    point.emplace(x[i], 0);
  }
  long long int c = 0;
  for (auto itr = mp.begin(); itr != mp.end(); itr++, c++) (*itr).second = c;
  c = 0;
  for (auto itr = point.begin(); itr != point.end(); itr++, c++)
    (*itr).second = c;
  long long int ans = 0;
  for (long long int i = 0; i < l.size(); i++) l[i][2] = mp.at(l[i][1]);
  for (long long int i = 0; i < r.size(); i++) r[i][2] = mp.at(r[i][1]);
  for (long long int i = 0; i < n; i++) d[i][2] = point.at(d[i][0]);
  segtree seg_l(mp.size(), 0), seg_r(mp.size(), 0), p(point.size(), 0);
  segtree seg_l_num(mp.size(), 0), seg_r_num(mp.size(), 0),
      p_num(point.size(), 0);
  sort((l).begin(), (l).end());
  sort((r).begin(), (r).end());
  sort((d).begin(), (d).end());
  for (int i = r.size() - 1; i >= 0; i--) {
    long long int SUM = seg_r.query(r[i][2], mp.size() + 1);
    long long int NUM = seg_r_num.query(r[i][2], mp.size() + 1);
    ans += (SUM - r[i][0] * NUM);
    if (r[i][1] != 0)
      seg_r.update(r[i][0], r[i][2]), seg_r_num.update(1, r[i][2]);
  }
  for (long long int i = 0; i < l.size(); i++) {
    long long int SUM = seg_l.query(l[i][2], mp.size() + 1);
    long long int NUM = seg_l_num.query(l[i][2], mp.size() + 1);
    ans += (l[i][0] * NUM - SUM);
    seg_l.update(l[i][0], l[i][2]), seg_l_num.update(1, l[i][2]);
  }
  for (long long int i = 0; i < n; i++) {
    if (d[i][1] < 0) p.update(d[i][0], d[i][2]), p_num.update(1, d[i][2]);
    if (d[i][1] > 0) {
      long long int SUM = p.query(0, d[i][2]);
      long long int NUM = p_num.query(0, d[i][2]);
      ans += (d[i][0] * NUM - SUM);
    }
  }
  std::cout << ans << '\n';
}
