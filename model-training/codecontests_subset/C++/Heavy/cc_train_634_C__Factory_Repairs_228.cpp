#include <bits/stdc++.h>
using namespace std;
struct FenwickTree {
  int N;
  vector<int> A;
  FenwickTree(int n) : N(n + 1), A(N) {}
  int rq(int b) {
    int sum = 0;
    for (; b; b -= b & -b) sum += A[b];
    return sum;
  }
  int rq(int a, int b) { return rq(b) - rq(a); }
  void adjust(int i, int v) {
    for (i++; i < N; i += i & -i) A[i] += v;
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
      bef.adjust(j - 1, befk - befa[j]);
      befa[j] = befk;
      aft.adjust(j - 1, aftk - afta[j]);
      afta[j] = aftk;
    } else {
      scanf("%d", &j);
      printf("%d\n", bef.rq(0, j - 1) + aft.rq(k + j - 1, n));
    }
  }
  return 0;
}
