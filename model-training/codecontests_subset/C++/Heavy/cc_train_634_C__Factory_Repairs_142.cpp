#include <bits/stdc++.h>
using namespace std;
class FenwickTree {
 public:
  explicit FenwickTree(int N) : F(N, 0) {}
  void Add(int i, int add) {
    for (; i < F.size(); i = (i | (i + 1))) {
      F[i] += add;
    }
  }
  int Sum(int i) const {
    int r = 0;
    for (; i >= 0; i = (i & (i + 1)) - 1) {
      r += F[i];
    }
    return r;
  }
  int Sum(int i, int j) const {
    if (i > j) {
      return 0;
    }
    return Sum(j) - Sum(i - 1);
  }

 private:
  vector<int> F;
};
int main() {
  int N, K, A, B, Q;
  scanf("%d%d%d%d%d", &N, &K, &A, &B, &Q);
  vector<int> D(N, 0);
  FenwickTree up(N), down(N);
  for (int q = 0; q < Q; ++q) {
    int type;
    scanf("%d", &type);
    if (type == 1) {
      int d, a;
      scanf("%d%d", &d, &a);
      --d;
      int up_value = min(A, D[d] + a);
      int down_value = min(B, D[d] + a);
      if (up_value > D[d]) {
        up.Add(d, up_value - D[d]);
      }
      if (down_value > D[d]) {
        down.Add(d, down_value - D[d]);
      }
      D[d] = up_value;
    } else {
      int p;
      scanf("%d", &p);
      --p;
      int result = down.Sum(0, p - 1) + up.Sum(p + K, N - 1);
      printf("%d\n", result);
    }
  }
  return 0;
}
