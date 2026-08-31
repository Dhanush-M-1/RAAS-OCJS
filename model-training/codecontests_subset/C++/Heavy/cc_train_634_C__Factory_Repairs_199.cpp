#include <bits/stdc++.h>
using namespace std;
const int MAXN = 200000 + 1000;
struct fenwick {
  int BIT[MAXN];
  void update(int idx, int val) {
    while (idx < MAXN) {
      BIT[idx] += val;
      idx += idx & (-idx);
    }
  }
  long long get(int idx) {
    long long sum = 0;
    while (idx > 0) {
      sum += BIT[idx];
      idx -= idx & (-idx);
    }
    return sum;
  }
  long long get(int l, int r) { return get(r) - get(l - 1); }
};
long long n, a, b, k, q, type, p, d, m;
fenwick before, after;
void print() {
  cout << "BEFORE:\n";
  for (int i = 1; i <= n; ++i) cout << before.get(i, i) << " ";
  cout << "\n";
  cout << "AFTER:\n";
  for (int i = 1; i <= n; ++i) cout << after.get(i, i) << " ";
  cout << "\n";
}
int main() {
  cin >> n >> k >> a >> b >> q;
  for (int i = 0; i < q; ++i) {
    cin >> type;
    if (type == 1) {
      cin >> d >> m;
      long long x1 = before.get(d, d);
      long long x2 = after.get(d, d);
      before.update(d, min(b, x1 + m) - x1);
      after.update(d, min(a, x2 + m) - x2);
    } else {
      cin >> p;
      if (p == 1)
        cout << after.get(p + k, n) << "\n";
      else if (p == n - k + 1)
        cout << before.get(1, p - 1) << "\n";
      else
        cout << before.get(1, p - 1) + after.get(p + k, n) << "\n";
    }
  }
  return 0;
}
