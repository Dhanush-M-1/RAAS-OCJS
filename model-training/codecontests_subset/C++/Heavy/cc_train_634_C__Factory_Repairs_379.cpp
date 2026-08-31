#include <bits/stdc++.h>
using namespace std;
int maxsize = 262144;
struct tree {
  vector<long long> arr;
  tree() { arr.resize(maxsize * 2); }
  void set(int v, int l, int r, int x, long long val) {
    if (x > r || x < l) return;
    if (x <= l && x >= r) {
      arr[v] = val;
      return;
    }
    int m = (l + r) / 2;
    set(v * 2, l, m, x, val);
    set(v * 2 + 1, m + 1, r, x, val);
    arr[v] = arr[v * 2] + arr[v * 2 + 1];
  }
  long long get(int v, int l, int r, int x, int y) {
    if (x > r || y < l) return 0;
    if (l >= x && r <= y) return arr[v];
    int m = (l + r) / 2;
    return get(v * 2, l, m, x, y) + get(v * 2 + 1, m + 1, r, x, y);
  }
};
int main() {
  long long n, k, a, b, q;
  vector<long long> queries;
  tree pref, suf;
  cin >> n >> k >> a >> b >> q;
  for (int i = 0; i < q; i++) {
    int mode;
    cin >> mode;
    if (mode == 1) {
      long long d, am;
      cin >> d >> am;
      d--;
      pref.set(1, 0, maxsize - 1, d,
               min(pref.get(1, 0, maxsize - 1, d, d) + am, b));
      suf.set(1, 0, maxsize - 1, d,
              min(suf.get(1, 0, maxsize - 1, d, d) + am, a));
    } else {
      long long p, res = 0;
      cin >> p;
      p--;
      if (p > 0) res += pref.get(1, 0, maxsize - 1, 0, p - 1);
      if (p + k <= n - 1) res += suf.get(1, 0, maxsize - 1, p + k, n - 1);
      cout << res << endl;
    }
  }
}
