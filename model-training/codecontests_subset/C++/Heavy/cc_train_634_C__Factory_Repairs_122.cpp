#include <bits/stdc++.h>
using namespace std;
class BIT {
 private:
  vector<int> ft;

 public:
  BIT(int n) { ft.assign(n + 1, 0); }
  int rsq(int b) {
    int sum = 0;
    for (; b; b -= b & (-b)) sum += ft[b];
    return sum;
  }
  void update(int k, int v) {
    for (; k < ft.size(); k += k & (-k)) ft[k] += v;
  }
};
int main() {
  int n, k, a, b, q;
  scanf("%d %d %d %d %d", &n, &k, &a, &b, &q);
  BIT ft1(n);
  BIT ft2(n);
  vector<int> dias(n + 1, 0);
  while (q--) {
    int opr;
    scanf("%d", &opr);
    if (opr == 1) {
      int dia, v;
      scanf("%d %d", &dia, &v);
      int dif;
      if (dias[dia] < b) {
        if (dias[dia] + v > b) {
          dif = b - dias[dia];
        } else {
          dif = v;
        }
        ft1.update(dia, dif);
      }
      if (dias[dia] < a) {
        if (dias[dia] + v > a) {
          dif = a - dias[dia];
        } else {
          dif = v;
        }
        ft2.update(dia, dif);
      }
      dias[dia] += v;
    } else {
      int rep;
      scanf("%d", &rep);
      int resp = 0;
      resp = ft1.rsq(rep - 1);
      resp += ft2.rsq(n) - ft2.rsq(rep + k - 1);
      printf("%d\n", resp);
    }
  }
  return 0;
}
