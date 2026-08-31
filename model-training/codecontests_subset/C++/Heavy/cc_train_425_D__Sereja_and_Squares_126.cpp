#include <bits/stdc++.h>
using namespace std;
const int md = 1e5 + 10;
const int N = 2e6 + 10;
unordered_set<int> cx[N], cy[N];
pair<int, int> a[md];
long long res;
int n;
inline int readchar() {
  const int N = 1048576;
  static char buf[N];
  static char *p = buf, *end = buf;
  if (p == end) {
    if ((end = buf + fread(buf, 1, N, stdin)) == buf) return EOF;
    p = buf;
  }
  return *p++;
}
inline int ReadInt(int *x) {
  static char c, neg;
  while ((c = readchar()) < '-') {
    if (c == EOF) return 0;
  }
  neg = (c == '-') ? -1 : 1;
  *x = (neg == 1) ? c - '0' : 0;
  while ((c = readchar()) >= '0') *x = (*x << 3) + (*x << 1) + c - '0';
  *x *= neg;
  return 1;
}
int main() {
  ReadInt(&n);
  for (int i = 1; i <= n; i++) {
    int x, y;
    ReadInt(&x);
    ReadInt(&y);
    a[i].first = x + 1000000;
    a[i].second = y + 1000000;
  }
  sort(a + 1, a + 1 + n);
  for (int i = 1; i <= n; i++) {
    int x = a[i].first;
    int y = a[i].second;
    if (cx[x].size() < cy[y].size()) {
      unordered_set<int>::iterator it;
      for (it = cx[x].begin(); it != cx[x].end(); it++) {
        int yy = *it;
        int dis = y - yy;
        if (x - dis >= 0 && cx[x - dis].count(y) && cx[x - dis].count(yy))
          res++;
      }
    } else {
      unordered_set<int>::iterator it;
      for (it = cy[y].begin(); it != cy[y].end(); it++) {
        int xx = *it;
        int dis = x - xx;
        if (y - dis >= 0 && cy[y - dis].count(x) && cy[y - dis].count(xx))
          res++;
      }
    }
    cx[x].insert(y);
    cy[y].insert(x);
  }
  printf("%I64d", res);
  return 0;
}
