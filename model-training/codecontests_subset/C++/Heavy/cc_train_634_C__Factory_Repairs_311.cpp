#include <bits/stdc++.h>
using namespace std;
struct FenwickTree {
  int N;
  vector<int> A;
  FenwickTree(int N) : N(N), A(N) {}
  int rsq(int b) {
    int sum = 0;
    for (; b; b -= (b & (-b))) sum += A[b];
    return sum;
  }
  int rsq(int a, int b) { return rsq(b) - (a == 1000000000 ? 0 : rsq(a - 1)); }
  void adjust(int k, int v) {
    for (; k < A.size(); k += k & -k) A[k] += v;
  }
};
int n, k, a, b, q;
int main() {
  cin >> n >> k >> a >> b >> q;
  FenwickTree bef(n + 5), aft(n + 5);
  vector<int> befa(n + 1), afta(n + 1);
  int i, j, k1;
  for (int c = 0; c < q; c++) {
    scanf("%d", &i);
    if (i == 1) {
      scanf("%d%d", &j, &k1);
      int befk = min(k1 + befa[j], b);
      int aftk = min(k1 + afta[j], a);
      bef.adjust(j, befk - befa[j]);
      befa[j] = befk;
      aft.adjust(j, aftk - afta[j]);
      afta[j] = aftk;
    } else {
      scanf("%d", &j);
      printf("%d\n", bef.rsq(1, j - 1) + aft.rsq(k + j, n));
    }
  }
  return 0;
}
