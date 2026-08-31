#include <bits/stdc++.h>
using namespace std;
struct List {
  List *pre, *net;
  int l, r, id;
  List() {
    pre = net = NULL;
    l = r = id = 0;
  }
};
int main() {
  int n, m, id = 1;
  scanf("%d%d", &n, &m);
  List *p = new List;
  List *f = p;
  p->net = new List;
  p->net->pre = p;
  p = p->net;
  p->l = m;
  while (n--) {
    char cmd[20];
    scanf("%s", cmd);
    if (cmd[0] == 'a') {
      int x;
      scanf("%d", &x);
      p = f;
      bool cha = false;
      while (p->net) {
        if (p->net->l - p->r >= x) {
          List *q = new List;
          q->net = p->net;
          q->pre = p;
          q->l = p->r;
          q->r = p->r + x;
          q->id = id++;
          q->pre->net = q;
          q->net->pre = q;
          cha = true;
          break;
        }
        p = p->net;
      }
      if (!cha)
        puts("NULL");
      else
        printf("%d\n", id - 1);
    } else if (cmd[0] == 'e') {
      int x;
      scanf("%d", &x);
      p = f->net;
      bool cha = false;
      while (p->net) {
        if (p->id == x) {
          cha = true;
          p->pre->net = p->net;
          p->net->pre = p->pre;
          break;
        }
        p = p->net;
      }
      if (!cha) puts("ILLEGAL_ERASE_ARGUMENT");
    } else {
      p = f->net;
      while (p->net != NULL) {
        p->r -= p->l - p->pre->r;
        p->l = p->pre->r;
        p = p->net;
      }
    }
  }
  return 0;
}
