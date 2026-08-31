#include <bits/stdc++.h>
using namespace std;
int szm[3100][3100];
int numd;
int sizc;
int totb;
int hc;
struct nodeb {
  int next;
  int v;
};
nodeb szb[3100 << 1];
struct noded {
  bool inc;
  bool vis;
  int next;
  int ind;
  int top;
};
noded szd[3100];
void adde(int from, int to) {
  totb++;
  szb[totb].v = to;
  szb[totb].next = szd[from].ind;
  szd[from].ind = totb;
  return;
}
bool dfs1(int x, int fa) {
  int f1;
  szd[x].vis = true;
  for (f1 = szd[x].ind; f1 != 0; f1 = szb[f1].next) {
    if (szb[f1].v == fa) continue;
    if (szd[szb[f1].v].vis) {
      szd[szb[f1].v].inc = true;
      szd[x].inc = true;
      return true;
    }
    if (dfs1(szb[f1].v, x)) break;
  }
  if ((f1 == 0) || (szd[x].inc)) return false;
  szd[x].inc = true;
  return true;
}
void dfs2(int x, int fa, int top, int deep) {
  int f1;
  szm[top][x] = szm[x][top] = deep;
  if (szd[top].inc) szd[x].top = top;
  for (f1 = szd[x].ind; f1 != 0; f1 = szb[f1].next)
    if ((szb[f1].v != fa) && (szd[szb[f1].v].inc == false))
      dfs2(szb[f1].v, x, top, deep + 1);
  return;
}
void dfs3(int x, int fa) {
  int f1;
  if (szd[x].next != 0) return;
  for (f1 = szd[x].ind; f1 != 0; f1 = szb[f1].next)
    if ((szb[f1].v != fa) && szd[szb[f1].v].inc) {
      szd[x].next = szb[f1].v;
      dfs3(szb[f1].v, x);
      break;
    }
  return;
}
int main() {
  double ans;
  int w1;
  int w2;
  int f1;
  int f2;
  int f3;
  scanf("%d", &numd);
  for (f1 = 1; f1 <= numd; f1++) {
    scanf("%d%d", &w1, &w2);
    w1++;
    w2++;
    adde(w1, w2);
    adde(w2, w1);
  }
  dfs1(1, 0);
  for (f1 = 1; f1 <= numd; f1++) {
    dfs2(f1, 0, f1, 0);
    if (szd[f1].inc) {
      if (sizc == 0) {
        dfs3(f1, 0);
        hc = f1;
      }
      sizc++;
      for (f2 = 1; f2 <= numd; f2++) szm[f2][f1] = szm[f1][f2];
    }
  }
  f1 = hc;
  do {
    for (f2 = szd[f1].next, f3 = 1; f2 != f1; f2 = szd[f2].next, f3++)
      szm[f1][f2] = f3;
    f1 = szd[f1].next;
  } while (f1 != hc);
  ans = 0;
  for (f1 = 1; f1 <= numd; f1++)
    for (f2 = 1; f2 <= numd; f2++)
      if (szd[f1].top == szd[f2].top)
        if ((szm[f1][f2] != 0) || (f1 == f2))
          ans += (double)1 / (szm[f1][f2] + 1);
        else
          ans += (double)1 / (szm[f1][szd[f1].top] + szm[f2][szd[f2].top] + 1);
      else {
        ans += (double)1 / (szm[f1][szd[f1].top] + szm[f2][szd[f2].top] +
                            szm[szd[f1].top][szd[f2].top] + 1);
        ans += (double)1 / (szm[f1][szd[f1].top] + szm[f2][szd[f2].top] +
                            (sizc - szm[szd[f1].top][szd[f2].top]) + 1);
        ans -= (double)1 / (szm[f1][szd[f1].top] + szm[f2][szd[f2].top] + sizc);
      }
  printf("%.10lf\n", ans);
  return 0;
}
