#include <bits/stdc++.h>
using namespace std;
const int maxn = 200009;
struct {
  int L, R;
  int pl, pr;
  int suma, sumb;
} T[2 * maxn];
int buildTree(int L, int R) {
  static int sz = 1;
  int cur = sz++;
  T[cur].L = L;
  T[cur].R = R;
  if (L < R) {
    T[cur].pl = buildTree(L, (L + R) / 2);
    T[cur].pr = buildTree((L + R) / 2 + 1, R);
  }
  return cur;
}
int get(int L, int R, char c, int cur) {
  if (L <= T[cur].L && R >= T[cur].R) {
    if (c == 'a') return T[cur].suma;
    return T[cur].sumb;
  }
  int ret = 0;
  if (L <= T[T[cur].pl].R && T[T[cur].pl].L <= R)
    ret += get(L, R, c, T[cur].pl);
  if (L <= T[T[cur].pr].R && T[T[cur].pr].L <= R)
    ret += get(L, R, c, T[cur].pr);
  return ret;
}
int a, b;
void add(int i, int val, int cur) {
  if (T[cur].L == T[cur].R) {
    T[cur].suma += val;
    T[cur].suma = min(a, T[cur].suma);
    T[cur].sumb += val;
    T[cur].sumb = min(b, T[cur].sumb);
    return;
  }
  if (i <= T[T[cur].pl].R)
    add(i, val, T[cur].pl);
  else
    add(i, val, T[cur].pr);
  T[cur].suma = T[T[cur].pl].suma + T[T[cur].pr].suma;
  T[cur].sumb = T[T[cur].pl].sumb + T[T[cur].pr].sumb;
}
int main() {
  int n, k, q;
  scanf("%d %d %d %d %d", &n, &k, &a, &b, &q);
  buildTree(0, 200001);
  while (q--) {
    int t;
    scanf("%d", &t);
    if (t == 1) {
      int di, ai;
      scanf("%d %d", &di, &ai);
      add(di, ai, 1);
    } else {
      int p;
      scanf("%d", &p);
      int sum = get(0, p - 1, 'b', 1) + get(p + k, 200001, 'a', 1);
      printf("%d\n", sum);
    }
  }
}
