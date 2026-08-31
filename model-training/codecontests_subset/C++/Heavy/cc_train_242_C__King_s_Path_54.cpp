#include <bits/stdc++.h>
using namespace std;
void openfile() {
  freopen("input.inp", "r", stdin);
  freopen("output.out", "w", stdout);
}
void input(long &n) { scanf("%ld", &n); }
void output(long n) { printf("%ld", n); }
typedef vector<long> GR[100000 + 10];
const long dirr[] = {-1, -1, -1, 0, 0, 1, 1, 1};
const long dirc[] = {-1, 0, 1, -1, 1, -1, 0, 1};
class oPoint {
 public:
  long r, c;
  void input() { scanf("%ld %ld", &r, &c); }
  oPoint(long rr, long cc) {
    r = rr;
    c = cc;
  }
  oPoint() { r = c = 0; }
  inline friend bool operator==(const oPoint &a, const oPoint &b) {
    return (a.r == b.r && a.c == b.c);
  }
  inline friend bool operator<(const oPoint &a, const oPoint &b) {
    return (a.r < b.r || (a.r == b.r && a.c < b.c));
  }
};
vector<oPoint> pList;
void input(oPoint &p1, oPoint &p2, vector<oPoint> &pList, long &n) {
  p1.input();
  p2.input();
  long m;
  input(m);
  for (long i = (1); i <= (m); i++) {
    long r, a, b;
    input(r);
    input(a);
    input(b);
    for (long c = (a); c <= (b); c++) {
      pList.push_back(oPoint(r, c));
    }
  }
  sort((pList).begin(), (pList).end());
  typeof(pList.begin()) it = unique((pList).begin(), (pList).end());
  pList.resize(it - pList.begin());
  n = pList.size();
}
inline long find(oPoint p, const vector<oPoint> &pList, long ll, long rr) {
  while (rr - ll > 1) {
    long mid = (rr + ll) >> 1;
    if (pList[mid] < p)
      ll = mid + 1;
    else
      rr = mid;
  }
  if (pList[rr] == p)
    return rr;
  else if (pList[ll] == p)
    return ll;
  else
    return -1;
}
void buildgraph(long n, const vector<oPoint> &pList, GR &a) {
  for (long i = (0); i <= (n - 1); i++) {
    for (long dir = (0); dir <= (8 - 1); dir++) {
      oPoint newp = oPoint(pList[i].r + dirr[dir], pList[i].c + dirc[dir]);
      long id = find(newp, pList, 0, n - 1);
      if (id != -1) {
        a[i].push_back(id);
      }
    }
  }
}
queue<long> qx;
long BFS(long n, long st, long en, const GR &a, long x[]) {
  for (long i = (0); i <= (n - 1); i++) x[i] = -1;
  if (st == -1 || en == -1) return -1;
  qx.push(st);
  x[st] = 0;
  while (!qx.empty()) {
    long u = qx.front();
    qx.pop();
    for (typeof((a[u]).begin()) it = (a[u]).begin(); it != (a[u]).end(); it++) {
      long v = *it;
      if (x[v] == -1) {
        x[v] = x[u] + 1;
        if (v == en) return x[v];
        qx.push(v);
      }
    }
  }
  return -1;
}
oPoint p1, p2;
long n;
GR a;
long x[100000 + 10];
int main() {
  input(p1, p2, pList, n);
  buildgraph(n, pList, a);
  long ps = find(p1, pList, 0, n - 1);
  long pt = find(p2, pList, 0, n - 1);
  long res = BFS(n, ps, pt, a, x);
  output(res);
}
