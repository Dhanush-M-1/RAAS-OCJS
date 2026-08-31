#include <bits/stdc++.h>
using namespace std;
class STlazy {
 private:
  int n;
  vector<long long> node, lazy;

 public:
  STlazy(vector<long long> v) {
    int siz = v.size();
    n = 1;
    while (n < siz) n *= 2;
    node.resize(2 * n - 1, 0);
    lazy.resize(2 * n - 1, 0);
    for (int i = 0; i < siz; i++) node[n - 1 + i] = v[i];
    for (int i = n - 2; i >= 0; i--)
      node[i] = node[2 * i + 1] + node[2 * i + 2];
  }
  void eval(int k, int l, int r) {
    if (lazy[k] == 0) return;
    node[k] += lazy[k];
    if (r - l > 1) {
      lazy[2 * k + 1] += lazy[k] / 2;
      lazy[2 * k + 2] += lazy[k] / 2;
    }
    lazy[k] = 0;
  }
  void add(int a, int b, long long x, int k = 0, int l = 0, int r = -1) {
    if (r < 0) r = n;
    eval(k, l, r);
    if (r <= a || b <= l) return;
    if (a <= l && r <= b) {
      lazy[k] += (r - l) * x;
      eval(k, l, r);
      return;
    }
    add(a, b, x, 2 * k + 1, l, (l + r) / 2);
    add(a, b, x, 2 * k + 2, (l + r) / 2, r);
    node[k] = node[2 * k + 1] + node[2 * k + 2];
  }
  long long query(int a, int b, int k = 0, int l = 0, int r = -1) {
    if (r < 0) r = n;
    if (r <= a || b <= l) return 0;
    eval(k, l, r);
    if (a <= l && r <= b) return node[k];
    long long lx = query(a, b, 2 * k + 1, l, (l + r) / 2);
    long long rx = query(a, b, 2 * k + 2, (l + r) / 2, r);
    return lx + rx;
  }
};
int main() {
  cin.tie(0);
  ios::sync_with_stdio(false);
  int n;
  cin >> n;
  vector<pair<int, int> > vp(n);
  for (int i = 0; i < n; i++) {
    cin >> vp[i].first;
  }
  for (int i = 0; i < n; i++) {
    cin >> vp[i].second;
  }
  sort(vp.begin(), vp.end());
  vector<long long> vel;
  for (pair<int, int> &p : vp) vel.push_back(p.second);
  sort(vel.begin(), vel.end());
  vel.erase(unique(vel.begin(), vel.end()), vel.end());
  auto f = [&](long long x) -> int {
    return lower_bound(vel.begin(), vel.end(), x) - vel.begin();
  };
  int siz = vel.size();
  vector<long long> tmp(siz, 0), cnt(siz, 0);
  for (pair<int, int> &p : vp) {
    int pos = f(p.second);
    tmp[pos] += p.first;
    cnt[pos]++;
  }
  STlazy A(tmp), B(cnt);
  long long ans = 0;
  for (int i = 0; i < n; i++) {
    int v = vp[i].second;
    int pos = f(v);
    A.add(pos, pos + 1, -vp[i].first);
    B.add(pos, pos + 1, -1);
    if (v == 0) {
      ans += A.query(pos, siz + 1) - B.query(pos, siz + 1) * vp[i].first;
    } else if (v > 0) {
      ans += A.query(pos, siz + 1) - B.query(pos, siz + 1) * vp[i].first;
    } else if (v < 0) {
      ans += A.query(pos, siz + 1) - B.query(pos, siz + 1) * vp[i].first;
    }
  }
  cout << ans << endl;
  return 0;
}
