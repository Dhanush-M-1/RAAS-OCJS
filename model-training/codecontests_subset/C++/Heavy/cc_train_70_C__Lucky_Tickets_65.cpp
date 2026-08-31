#include <bits/stdc++.h>
void doubleIntSort(double d[], int m[], int s) {
  int i, j, r;
  double k1, k2, t;
  if (s <= 1) return;
  k1 = (d[0] + d[s - 1]) / 2.0;
  k2 = k1 + 1e-10;
  k1 -= 1e-10;
  i = -1;
  j = s;
  for (;;) {
    while (d[++i] < k1)
      ;
    while (d[--j] > k2)
      ;
    if (i >= j) break;
    t = d[i];
    d[i] = d[j];
    d[j] = t;
    r = m[i];
    m[i] = m[j];
    m[j] = r;
  }
  doubleIntSort(d, m, i);
  doubleIntSort(d + j + 1, m + j + 1, s - j - 1);
}
typedef struct struct_vector_int {
  int size, mem;
  int *d;
} intVector;
intVector intVectorNull() {
  intVector v;
  v.size = v.mem = 0;
  return v;
}
void intVectorMemoryExpand(intVector *v) {
  int i, *t, m;
  m = v->mem * 2;
  if (m < 5) m = 5;
  t = (int *)malloc(m * sizeof(int));
  for (i = 0; i < v->size; i++) t[i] = v->d[i];
  if (v->mem) free(v->d);
  v->d = t;
  v->mem = m;
}
void intVectorPushBack(intVector *v, int add) {
  if (v->mem == v->size) intVectorMemoryExpand(v);
  v->d[(v->size)++] = add;
}
int rev(int n) {
  int i, res = 0;
  char buf[100];
  sprintf(buf, "%d", n);
  for (i = 0;; i++)
    if (buf[i] < ' ') break;
  while (i--) res = res * 10 + buf[i] - '0';
  return res;
}
int REV[100001];
double rat[100001];
int ind[100001];
intVector edge[100001];
int main() {
  int i, j, k, l, m, n;
  int useX[100001];
  int x, y;
  int st, ed, add = 0;
  long long resX, resY, nowX, nowY, now;
  for (i = 0; i < 100001; i++) REV[i] = rev(i);
  for (i = 1; i < 100001; i++) rat[i] = REV[i] / (double)i, ind[i] = i;
  doubleIntSort(rat + 1, ind + 1, 100001 - 1);
  for (i = 0; i < 100001; i++) edge[i] = intVectorNull();
  ed = 100001 - 1;
  for (st = 1; st < 100001; st++) {
    while (ed >= 1 && rat[st] * rat[ed] > 1 + 1e-10) ed--;
    if (ed == 0) break;
    for (i = ed; i >= 1; i--) {
      if (rat[st] * rat[i] < 1 - 1e-10) break;
      intVectorPushBack(edge + ind[st], ind[i]);
      add++;
    }
  }
  while (scanf("%d%d%d", &x, &y, &n) == 3) {
    resX = 100000000;
    resY = 100000000;
    for (i = 0; i < x + 1; i++) useX[i] = 0;
    nowX = x;
    now = 0;
    for (nowY = 1; nowY < y + 1; nowY++) {
      for (i = 0; i < edge[nowY].size; i++)
        if (1 <= edge[nowY].d[i] && edge[nowY].d[i] <= nowX)
          now++, useX[edge[nowY].d[i]]++;
      while (now >= n) {
        if (resX * resY > nowX * nowY) resX = nowX, resY = nowY;
        now -= useX[nowX];
        nowX--;
      }
    }
    if (resX > x)
      puts("-1");
    else
      printf("%d %d\n", (int)resX, (int)resY);
  }
  return 0;
}
