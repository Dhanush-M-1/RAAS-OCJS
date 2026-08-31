#include <bits/stdc++.h>
using namespace std;
int szg1[100][100][100 << 1];
int szg2[100][100][100 << 1];
int szg3[100][100][100 << 1];
int szg4[100][100][100 << 1];
int dp[100 << 1][100][2];
int szm[100][100];
int numd;
int numb;
int head;
int tail;
struct nodel {
  nodel* back;
  nodel* next;
  int d;
};
struct nodeb {
  nodel* head;
  nodel* tail;
  int num;
  int w1;
  int w2;
  void init() {
    head = new nodel;
    tail = new nodel;
    head->next = tail;
    tail->back = head;
    return;
  }
  void addl(int x) {
    nodel* p;
    p = new nodel;
    p->d = x;
    p->back = tail->back;
    tail->back->next = p;
    p->next = tail;
    tail->back = p;
    return;
  }
};
nodeb szb[1500];
struct nodeq {
  nodel* p;
  int x;
};
nodeq szq[100 << 2];
bool geth(nodeq x, int& to, int& len) {
  nodeq now;
  nodel* p;
  for (len = 0, head = 1, tail = 1, szq[1] = x, to = szb[x.x].w1; head <= tail;)
    for (now = szq[head++], p = now.p; p != szb[now.x].head; p = p->back) {
      if ((szm[p->d][to] == 0) || (len > numd << 1)) return false;
      szq[++tail] = (nodeq){szb[szm[p->d][to]].tail->back, szm[p->d][to]};
      to = p->d;
      len++;
    }
  return true;
}
bool gett(nodeq x, int& to, int& len) {
  nodeq now;
  nodel* p;
  for (len = 0, head = 1, tail = 1, szq[1] = x, to = szb[x.x].w2; head <= tail;)
    for (now = szq[head++], p = now.p; p != szb[now.x].tail; p = p->next) {
      if ((szm[to][p->d] == 0) || (len > numd << 1)) return false;
      szq[++tail] = (nodeq){szb[szm[to][p->d]].head->next, szm[to][p->d]};
      to = p->d;
      len++;
    }
  return true;
}
int main() {
  nodel* p;
  bool flag;
  int len1;
  int len2;
  int len;
  int ans;
  int lin;
  int to1;
  int to2;
  int to;
  int f1;
  int f2;
  int f3;
  int f4;
  int f5;
  int f6;
  scanf("%d%d", &numd, &numb);
  for (f1 = 1; f1 <= numb; f1++) {
    scanf("%d%d%d", &szb[f1].w1, &szb[f1].w2, &szb[f1].num);
    szm[szb[f1].w1][szb[f1].w2] = f1;
    szb[f1].init();
    for (f2 = 1; f2 <= szb[f1].num; f2++) {
      scanf("%d", &lin);
      szb[f1].addl(lin);
    }
  }
  for (f1 = 1; f1 <= numd; f1++)
    for (f2 = 1; f2 <= numd; f2++) {
      lin = szm[f2][f1];
      if ((lin == 0) || (szb[lin].num == 0) || (szb[lin].tail->back->d != f2))
        continue;
      if (geth((nodeq){szb[lin].tail->back->back, lin}, to, len))
        szg1[to][f1][len + 1]++;
    }
  for (f1 = 1; f1 <= numd; f1++)
    for (f2 = 1; f2 <= numd; f2++) {
      lin = szm[f1][f2];
      if ((lin == 0) || (szb[lin].num == 0) || (szb[lin].head->next->d != f2))
        continue;
      if (gett((nodeq){szb[lin].head->next->next, lin}, to, len))
        szg2[f1][to][len + 1]++;
    }
  for (f1 = 1; f1 <= numb; f1++) {
    flag = false;
    for (p = szb[f1].head->next; p != szb[f1].tail; p = p->next) {
      if (flag && (p->d == szb[f1].w2)) break;
      if (p->d == szb[f1].w1)
        flag = true;
      else
        flag = false;
    }
    if (p == szb[f1].tail) continue;
    if (geth((nodeq){p->back->back, f1}, to1, len1) == false) continue;
    if (gett((nodeq){p->next, f1}, to2, len2) == false) continue;
    szg3[to1][to2][len1 + len2 + 1]++;
  }
  for (f1 = 1; f1 <= numd; f1++)
    for (f2 = 1; f2 <= numd; f2++)
      if ((szm[f1][f2] != 0) && (szb[szm[f1][f2]].num == 0))
        szg4[f1][f2][1] = 1;
  for (f1 = 1; f1 <= numd; f1++) dp[0][f1][0] = 1;
  for (f1 = 1; f1 <= numd << 1; f1++)
    for (f2 = 1; f2 <= numd; f2++)
      for (f3 = 1; f3 <= f1; f3++)
        for (f4 = 1; f4 <= numd; f4++) {
          dp[f1][f2][0] +=
              (long long int)dp[f1 - f3][f4][0] * szg1[f4][f2][f3] % 1000000007;
          if (dp[f1][f2][0] >= 1000000007) dp[f1][f2][0] -= 1000000007;
          dp[f1][f2][0] +=
              (long long int)dp[f1 - f3][f4][1] * szg4[f4][f2][f3] % 1000000007;
          if (dp[f1][f2][0] >= 1000000007) dp[f1][f2][0] -= 1000000007;
          dp[f1][f2][1] +=
              (long long int)dp[f1 - f3][f4][0] * szg3[f4][f2][f3] % 1000000007;
          if (dp[f1][f2][1] >= 1000000007) dp[f1][f2][1] -= 1000000007;
          dp[f1][f2][1] +=
              (long long int)dp[f1 - f3][f4][1] * szg2[f4][f2][f3] % 1000000007;
          if (dp[f1][f2][1] >= 1000000007) dp[f1][f2][1] -= 1000000007;
        }
  for (f1 = 1; f1 <= numd << 1; f1++) {
    ans = 0;
    for (f2 = 1; f2 <= numd; f2++) {
      ans += dp[f1][f2][1];
      if (ans >= 1000000007) ans -= 1000000007;
    }
    printf("%d\n", ans);
  }
  return 0;
}
