#include <bits/stdc++.h>
using namespace std;
class BinaryIndexedTree {
 public:
  BinaryIndexedTree(int n) : n(n), data(n + 1, 0) {}
  void add(int p, int x) {
    while (p <= n) {
      data[p] += x;
      p += p & -p;
    }
  }
  int get(int p) {
    int result = 0;
    while (p > 0) {
      result += data[p];
      p -= p & -p;
    }
    return result;
  }

 private:
  int n;
  vector<int> data;
};
void add(BinaryIndexedTree& bit, int day, int orders, int limit) {
  int now = bit.get(day) - bit.get(day - 1);
  bit.add(day, min(limit - now, orders));
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  int n, k, a, b, q;
  cin >> n >> k >> a >> b >> q;
  BinaryIndexedTree broken(n);
  BinaryIndexedTree repared(n);
  for (int query = 0; query < q; ++query) {
    int type;
    cin >> type;
    if (type == 1) {
      int d, a_;
      cin >> d >> a_;
      add(broken, d, a_, b);
      add(repared, d, a_, a);
    } else {
      int p;
      cin >> p;
      cout << broken.get(p - 1) + repared.get(n) - repared.get(p + k - 1)
           << '\n';
    }
  }
}
