#include <bits/stdc++.h>
using namespace std;
const int iinf = 1e9 + 7;
const long long linf = 1ll << 60;
const double dinf = 1e10;
void scf(int &x) {
  bool f = 0;
  x = 0;
  char c = getchar();
  while ((c < '0' || c > '9') && c != '-') c = getchar();
  if (c == '-') {
    f = 1;
    c = getchar();
  }
  while (c >= '0' && c <= '9') {
    x = x * 10 + c - '0';
    c = getchar();
  }
  if (f) x = -x;
  return;
}
void scf(int &x, int &y) {
  scf(x);
  return scf(y);
}
void scf(int &x, int &y, int &z) {
  scf(x);
  scf(y);
  return scf(z);
}
const int N = 2e5 + 100;
int n, k, a, b, q;
struct fenwick_tree {
  int num[N];
  void init() {
    memset(num, 0, sizeof(num));
    return;
  }
  inline int lowbit(int i) { return i & (-i); }
  inline void update(int i, int x) {
    for (; i <= q; i += lowbit(i)) num[i] += x;
    return;
  }
  inline int query(int i) {
    int ret = 0;
    for (; i; i -= lowbit(i)) ret += num[i];
    return ret;
  }
} BIT;
struct query {
  int op, a, b;
  void in() {
    scf(op, a);
    if (op == 1) scf(b);
    return;
  }
} qry[N];
vector<int> upd[N], qst[N];
int has[N];
inline int MIN(int a, int b) { return a < b ? a : b; }
int main() {
  scf(n, k);
  scf(a, b, q);
  for (int i = (1); i <= (q); i++) qry[i].in();
  for (int i = (1); i <= (q); i++)
    if (qry[i].op == 1)
      upd[qry[i].a].push_back(i);
    else
      qst[qry[i].a].push_back(i);
  for (int i = (1); i <= (n); i++) {
    for (__typeof((qst[i]).begin()) j = (qst[i]).begin(); j != (qst[i]).end();
         j++)
      qry[*j].b = BIT.query(*j);
    for (__typeof((upd[i]).begin()) j = (upd[i]).begin(); j != (upd[i]).end();
         j++) {
      int tmp = MIN(qry[*j].b, b - has[i]);
      BIT.update(*j, tmp);
      has[i] += tmp;
    }
    qst[i].clear();
  }
  BIT.init();
  memset(has, 0, sizeof(has));
  for (int i = (1); i <= (q); i++)
    if (qry[i].op == 2) qst[qry[i].a + k - 1].push_back(i);
  for (int i = (n); i >= (1); i--) {
    for (__typeof((qst[i]).begin()) j = (qst[i]).begin(); j != (qst[i]).end();
         j++)
      qry[*j].b += BIT.query(*j);
    for (__typeof((upd[i]).begin()) j = (upd[i]).begin(); j != (upd[i]).end();
         j++) {
      int tmp = MIN(qry[*j].b, a - has[i]);
      BIT.update(*j, tmp);
      has[i] += tmp;
    }
    qst[i].clear();
  }
  for (int i = (1); i <= (q); i++)
    if (qry[i].op == 2) printf("%d\n", qry[i].b);
  return 0;
}
