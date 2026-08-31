#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:512000000")
using namespace std;
void solve();
void precalc();
clock_t start;
int testNumber = 1;
bool todo = true;
int main() {
  start = clock();
  int t = 1;
  cout.sync_with_stdio(0);
  cin.tie(0);
  precalc();
  cout.precision(10);
  cout << fixed;
  int testNum = 1;
  while (t--) {
    solve();
    ++testNumber;
  }
  return 0;
}
template <typename T>
T binpow(T q, T w, T mod) {
  if (!w) return 1 % mod;
  if (w & 1) return q * 1LL * binpow(q, w - 1, mod) % mod;
  return binpow(q * 1LL * q % mod, w / 2, mod);
}
void precalc() {}
template <typename T>
T gcd(T q, T w) {
  while (w) {
    q %= w;
    swap(q, w);
  }
  return q;
}
template <typename T>
T lcm(T q, T w) {
  return q / gcd(q, w) * w;
}
struct SegTree {
  const int shift = 1 << 18;
  vector<int> tree;
  SegTree() { tree.assign(2 * shift, 0); }
  int rmq(int l, int r) {
    if (l >= r) {
      return 0;
    }
    if (l & 1) {
      return tree[l] + rmq(l + 1, r);
    }
    if (r & 1) {
      return tree[r - 1] + rmq(l, r - 1);
    }
    return rmq(l / 2, r / 2);
  }
  int get_sum(int l, int r) { return rmq(l + shift, r + shift); }
  void update(int v, int val) {
    v += shift;
    tree[v] = val;
    v /= 2;
    while (v) {
      tree[v] = tree[2 * v] + tree[2 * v + 1];
      v /= 2;
    }
  }
};
void solve() {
  int n, k, Q;
  vector<int> a(2);
  cin >> n >> k >> a[0] >> a[1] >> Q;
  vector<int> sums(n, 0);
  vector<SegTree> tree(2);
  for (int w = 0; w < Q; ++w) {
    int type;
    cin >> type;
    if (type == 1) {
      int day, num;
      cin >> day >> num;
      --day;
      sums[day] += num;
      for (int i = 0; i < 2; ++i) {
        tree[i].update(day, min(sums[day], a[i]));
      }
    } else {
      int l;
      cin >> l;
      --l;
      long long res = (long long)tree[1].get_sum(0, l) +
                      (long long)tree[0].get_sum(l + k, n);
      cout << res << "\n";
    }
  }
}
