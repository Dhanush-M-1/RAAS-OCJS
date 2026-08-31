#include <bits/stdc++.h>
using namespace std;
class fenwick {
  long long size;
  vector<long long> integral;
  vector<long long> kof;

 public:
  fenwick(int n) {
    size = n;
    integral.assign(size, 0);
    kof.assign(size, 0);
  }
  void add_range(long long r, long long num) {
    long long i;
    if (r < 0) return;
    for (i = r; i >= 0; i = (i & (i + 1)) - 1) {
      kof[i] += num;
    }
    for (i = r | (r + 1); i < size; i |= i + 1) {
      integral[i] += num * (r - (i & (i + 1)) + 1);
    }
  }
  void add_range(long long l, long long r, long long num) {
    add_range(r, num);
    add_range(l - 1, -num);
  }
  long long sum(long long r) {
    long long i;
    if (r < 0) return 0;
    long long res = 0;
    for (i = r; i >= 0; i = (i & (i + 1)) - 1) {
      res += integral[i] + kof[i] * (i - (i & (i + 1)) + 1);
    }
    for (i = r | (r + 1); i < size; i |= i + 1) {
      res += kof[i] * (r - (i & (i + 1)) + 1);
    }
    return res;
  }
  long long sum(long long l, long long r) { return sum(r) - sum(l - 1); }
};
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.setf(ios::fixed);
  cout.precision(4);
  int n, k;
  cin >> n >> k;
  long long a, b;
  cin >> a >> b;
  int q;
  cin >> q;
  fenwick trbe(n + 100);
  fenwick traf(n + 100);
  for (int i = 0; i < q; ++i) {
    int z;
    cin >> z;
    if (z == 1) {
      long long d, t;
      cin >> d >> t;
      long long sm = trbe.sum(d, d);
      long long dif = min(t + sm, b) - sm;
      trbe.add_range(d, d, dif);
      sm = traf.sum(d, d);
      dif = min(t + sm, a) - sm;
      traf.add_range(d, d, dif);
    } else {
      int p;
      cin >> p;
      cout << trbe.sum(0, p - 1) + traf.sum(p + k, n) << endl;
    }
  }
  return 0;
}
