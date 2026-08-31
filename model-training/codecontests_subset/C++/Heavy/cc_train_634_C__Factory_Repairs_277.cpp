#include <bits/stdc++.h>
using namespace std;
struct BIT {
  vector<long long> tree;
  BIT(int n) : tree(n + 2) {}
  void upd(int p, long long v) {
    for (int i = ++p; i < tree.size(); i += i & -i) tree[i] += v;
  }
  long long get(int p) {
    long long sum = 0;
    for (int i = ++p; i; i -= i & -i) sum += tree[i];
    return sum;
  }
  long long query(int l, int r) {
    if (r < l) return 0;
    return get(r) - get(l - 1);
  }
  int get_kth(long long k) {
    int pos = 0;
    long long s = 0;
    for (int i = 1 + log2(tree.size()); i >= 0; i--)
      if (pos + (1 << i) < tree.size() && s + tree[pos + (1 << i)] < k)
        s += tree[pos + (1 << i)], pos += (1 << i);
    return pos;
  }
  int lower_bound(int v) { return get_kth(get(v - 1) + 1); }
  int upper_bound(int v) { return lower_bound(v + 1); }
};
int main() {
  ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  int n, k, a, b, q;
  cin >> n >> k >> a >> b >> q;
  BIT pre(n + 1), suff(n + 1);
  vector<int> A(n + 1);
  while (q--) {
    int t;
    cin >> t;
    if (t == 1) {
      int day, add;
      cin >> day >> add;
      A[day] += add;
      int oldpre = pre.query(day, day);
      int oldsuff = suff.query(day, day);
      pre.upd(day, min(A[day], b) - oldpre);
      suff.upd(day, min(A[day], a) - oldsuff);
    } else {
      int p;
      cin >> p;
      int r = min(n + 1, p + k);
      cout << pre.query(0, p - 1) + suff.query(r, n + 1) << '\n';
    }
  }
}
