#include <bits/stdc++.h>
using namespace std;
int n;
long long IM = -999999999999;
typedef struct nde {
  int ll;
  int rl;
  long long val;
  int pos;
  long long prv;
  struct nde* l;
  struct nde* r;
  struct nde* pr;
} prt;
prt* getnew() {
  prt* p = new prt();
  p->prv = 0;
  return p;
}
prt* createTree(long long ar[], prt* pps[], int s, int e, prt* pr) {
  prt* rt = getnew();
  rt->ll = s;
  rt->rl = e;
  rt->pr = pr;
  rt->l = 0;
  rt->r = 0;
  if (s == e) {
    rt->pos = s;
    rt->val = ar[s];
    pps[s] = rt;
    return rt;
  } else {
    prt* t = createTree(ar, pps, s, (s + e) / 2, rt);
    prt* tt = createTree(ar, pps, 1 + ((s + e) / 2), e, rt);
    rt->l = t;
    rt->r = tt;
    if (t->val == tt->val) {
      rt->val = t->val;
      rt->pos = tt->pos;
    } else if (t->val < tt->val) {
      rt->val = t->val;
      rt->pos = t->pos;
    } else {
      rt->val = tt->val;
      rt->pos = tt->pos;
    }
  }
  return rt;
}
void uptd(int k, int rr, long long u, prt* p) {
  if (p->ll >= k && p->rl <= rr) {
    p->prv += u;
    return;
  }
  p->l->prv += p->prv;
  p->r->prv += p->prv;
  p->prv = 0;
  if (p->l->rl >= k && p->l->ll <= k) {
    uptd(k, rr, u, p->l);
  } else if (p->l->ll <= rr && p->l->rl >= rr) {
    uptd(k, rr, u, p->l);
  } else if (p->l->ll >= k && p->l->rl <= rr) {
    uptd(k, rr, u, p->l);
  } else {
  }
  if (p->r->rl >= k && p->r->ll <= k) {
    uptd(k, rr, u, p->r);
  } else if (p->r->ll <= rr && p->r->rl >= rr) {
    uptd(k, rr, u, p->r);
  } else if (p->r->ll >= k && p->r->rl <= rr) {
    uptd(k, rr, u, p->r);
  } else {
  }
  if ((p->l->val - p->l->prv) < (p->r->val - p->r->prv)) {
    p->val = p->l->val - p->l->prv;
    p->pos = p->l->pos;
  } else {
    p->val = p->r->val - p->r->prv;
    p->pos = p->r->pos;
  }
  return;
}
void inactive(int k, prt* root) { uptd(k, k, IM, root); }
int main() {
  int u;
  cin >> n;
  long long ar[n + 1];
  prt* pps[n + 1];
  int i = 1;
  while (i <= n) {
    cin >> ar[i];
    i++;
  }
  prt* root = createTree(ar, pps, 1, n, 0);
  i = 1;
  int t;
  while (i <= n) {
    t = root->pos;
    ar[t] = i;
    inactive(t, root);
    if (t < n) uptd(t + 1, n, i, root);
    i++;
  }
  i = 1;
  while (i <= n) {
    cout << ar[i] << " ";
    i++;
  }
  cout << endl;
  return 0;
}
