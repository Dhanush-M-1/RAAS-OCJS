#include <bits/stdc++.h>
using namespace std;
const int MaxN = 100000;
vector<int> a[MaxN + 5];
int x, y, w;
int rev[MaxN + 5];
struct number {
  int idx;
  double o;
};
number nA[MaxN + 5], nB[MaxN + 5];
int rr(int x) {
  int r = 0;
  while (x) {
    r = r * 10 + x % 10;
    x /= 10;
  }
  return r;
}
bool cmp(number a, number b) {
  return a.o + 0.000000001 < b.o ||
         (fabs(a.o - b.o) < 0.000000001 && a.idx < b.idx);
}
int comp(long long a, long long b, long long c, long long d) {
  if (a * b == c * d) return 0;
  if (a * b < c * d) return -1;
  return 1;
}
int cum[MaxN + 5];
void add(int idx) {
  while (idx <= MaxN) {
    cum[idx]++;
    idx += idx & (-idx);
  }
}
int sum(int idx) {
  int r = 0;
  while (idx) {
    r += cum[idx];
    idx -= idx & (-idx);
  }
  return r;
}
int main() {
  for (int i = 1; i <= MaxN; i++) {
    rev[i] = rr(i);
    nA[i].idx = i;
    nA[i].o = double(i) / double(rev[i]);
    nB[i].idx = i;
    nB[i].o = double(rev[i]) / double(i);
  }
  sort(nA + 1, nA + MaxN + 1, cmp);
  sort(nB + 1, nB + MaxN + 1, cmp);
  int i = 1, j = 1;
  while (i <= MaxN && j <= MaxN) {
    int c = comp(nA[i].idx, nB[j].idx, rev[nA[i].idx], rev[nB[j].idx]);
    if (c == -1)
      i++;
    else if (c == 0) {
      for (int k = j;
           comp(nA[i].idx, nB[k].idx, rev[nA[i].idx], rev[nB[k].idx]) == 0 &&
           k <= MaxN;
           k++)
        a[nA[i].idx].push_back(nB[k].idx);
      i++;
    } else
      j++;
  }
  scanf("%d%d%d", &x, &y, &w);
  memset(cum, 0, sizeof(cum));
  int solX = 2123456789, solY = 2123456789;
  for (int i = 1; i <= x; i++) {
    for (int j = 0; j < a[i].size(); j++) add(a[i][j]);
    int l = 1, r = MaxN, k;
    while (l < r) {
      k = (l + r) / 2;
      if (sum(k) >= w) {
        if (sum(k - 1) >= w)
          r = k - 1;
        else
          break;
      } else
        l = k + 1;
    }
    if (sum(k - 1) >= w && k - 1 <= y) {
      if (comp(solX, solY, i, k - 1) == 1) {
        solX = i;
        solY = k - 1;
      }
    } else if (sum(k) >= w && k <= y) {
      if (comp(solX, solY, i, k) == 1) {
        solX = i;
        solY = k;
      }
    } else if (sum(k + 1) >= w && k + 1 <= y) {
      if (comp(solX, solY, i, k + 1) == 1) {
        solX = i;
        solY = k + 1;
      }
    }
  }
  if (solX == 2123456789) {
    printf("-1\n");
    return 0;
  }
  printf("%d %d\n", solX, solY);
  return 0;
}
