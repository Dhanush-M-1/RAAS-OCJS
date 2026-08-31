#include <bits/stdc++.h>
using namespace std;
void update(int idx, long long *bit, int value) {
  while (idx < 200001) {
    bit[idx] += value;
    idx += (idx & -idx);
  }
}
long long query(int idx, long long *bit) {
  long long sum = 0;
  while (idx) {
    sum += bit[idx];
    idx -= (idx & -idx);
  }
  return sum;
}
long long qtd[200001];
long long bit1[200001], bit2[200001];
int main() {
  int n, k, a, b, q;
  scanf("%d %d %d %d %d", &n, &k, &a, &b, &q);
  swap(a, b);
  while (q--) {
    int op;
    scanf("%d", &op);
    if (op == 1) {
      int d, ai;
      scanf("%d %d", &d, &ai);
      long long aux = qtd[d];
      if (qtd[d] < a) {
        qtd[d] = min((long long)a, qtd[d] + ai);
        update(d, bit1, qtd[d] - aux);
      }
      qtd[d] = aux;
      if (qtd[d] < b) {
        qtd[d] = min((long long)b, qtd[d] + ai);
        update(d, bit2, qtd[d] - aux);
      }
      qtd[d] = aux + ai;
    } else {
      int d;
      scanf("%d", &d);
      long long ans = 0;
      ans += query(d - 1, bit1);
      ans += (query(n, bit2) - query(min(d + k - 1, n), bit2));
      printf("%lld\n", ans);
    }
  }
  return 0;
}
