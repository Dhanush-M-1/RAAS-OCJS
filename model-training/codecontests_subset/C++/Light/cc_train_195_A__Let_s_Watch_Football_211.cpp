#include <bits/stdc++.h>
using namespace std;
bool ktra(int a, int b, int c, int t) {
  int i;
  int have = t * b;
  int need = 0;
  for ((i) = (t + 1); (i) <= (c + t); (i)++) {
    need += a;
    have += b;
    if (have < need) return false;
  }
  return true;
}
void input() {
  int a, b, c, dau, giua, cuoi;
  scanf("%d %d %d", &a, &b, &c);
  dau = 0, cuoi = c * a;
  while (dau <= cuoi) {
    giua = (dau + cuoi) >> 1;
    if (ktra(a, b, c, giua))
      cuoi = giua - 1;
    else
      dau = giua + 1;
  }
  printf("%d", dau);
}
int main() {
  input();
  return 0;
}
