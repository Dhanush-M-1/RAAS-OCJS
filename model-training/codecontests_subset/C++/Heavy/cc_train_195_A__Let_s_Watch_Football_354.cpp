#include <bits/stdc++.h>
using namespace std;
int area;
struct node {
  int st, ed;
  int cnt;
  int f;
  node *l, *r;
  node() {}
  node(int _x, int _y) {
    st = _x, ed = _y;
    l = r = NULL;
    cnt = 0;
  }
};
void insert(node *ob, int val, int ind) {
  if (ob->st == ob->ed) {
    ob->cnt += val;
    ob->f = ind;
    return;
  }
  int mid = (ob->st + ob->ed) / 2;
  if (ob->l == NULL) ob->l = new node(ob->st, mid);
  if (ob->r == NULL) ob->r = new node(mid + 1, ob->ed);
  if (mid >= ind) {
    insert(ob->l, val, ind);
  } else
    insert(ob->r, val, ind);
  if (ob->l->cnt > ob->r->cnt) {
    ob->cnt = ob->l->cnt;
    ob->f = ob->l->f;
  } else {
    ob->cnt = ob->r->cnt;
    ob->f = ob->r->f;
  }
  return;
}
int A;
int L;
int waste;
char str[20];
bool state;
char ch;
void query(node *ob, int val) {
  if (ob == NULL) return;
  if (state) return;
  if (ob->cnt < val) return;
  if (ob->st == ob->ed) {
    if (ob->cnt >= val) {
      A = ob->f;
      state = true;
      return;
    }
  }
  if (ob->l->cnt >= val)
    query(ob->l, val);
  else if (ob->r->cnt >= val)
    query(ob->r, val);
  else
    return;
}
int main() {
  int a, b, c, p, q, ans;
  cin >> a >> b >> c;
  int i, j, k;
  int wait, total, lage, ase;
  total = a * c;
  for (i = 0;; i++) {
    p = i * b;
    int baki = total - p;
    int hoy = (i + c) * b;
    if (hoy < total)
      continue;
    else {
      cout << i << endl;
      break;
    }
  }
  return 0;
}
