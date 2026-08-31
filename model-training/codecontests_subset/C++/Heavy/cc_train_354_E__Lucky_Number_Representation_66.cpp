#include <bits/stdc++.h>
using namespace std;
int dp[200][500];
char num[200];
struct comb {
  int v[60];
  int s;
  comb() { s = 0; }
} v[500];
int qnt = 1;
int get(int p, int c) {
  if (p == -1 && c == 0) return 1;
  if (p == -1) return 0;
  if (dp[p][c] + 1) return dp[p][c];
  dp[p][c] = 0;
  for (int i = 1; i <= qnt; i++) {
    if ((v[i].s + c) % 10 != num[p]) continue;
    if (get(p - 1, (v[i].s + c) / 10)) dp[p][c] = i;
  }
  return dp[p][c];
};
void gera(int p, int d, comb C) {
  if (p == 6) {
    v[++qnt] = C;
    return;
  }
  C.v[p] = 7;
  C.s += 7;
  gera(p + 1, 7, C);
  C.s -= 7;
  if (d != 7) {
    C.v[p] = 4;
    C.s += 4;
    gera(p + 1, 4, C);
    C.s -= 4;
  }
  if (d == 0) {
    C.v[p] = 0;
    gera(p + 1, 0, C);
  }
}
void print(int *p) {
  int foi = 0;
  for (int i = 0; i <= 17; i++) {
    if (*(p + i) == 0 && !foi) continue;
    foi = 1;
    printf("%d", *(p + i));
  }
  if (!foi) printf("0");
}
int resp[80][200];
int main() {
  gera(0, 0, comb());
  int t;
  scanf("%d", &t);
  while (t--) {
    char ch;
    scanf(" %s", num);
    int n = strlen(num);
    for (int i = 0; i < n; i++) num[i] -= '0';
    memset(dp, -1, sizeof(dp));
    if (get(n - 1, 0) == 0)
      printf("-1\n");
    else {
      memset(resp, 0, sizeof(resp));
      int c = 0;
      for (int i = n - 1; i >= 0; i--) {
        int k = get(i, c);
        c = (v[k].s + c) / 10;
        ;
        for (int j = 0; j < 6; j++)
          ;
        ;
        for (int j = 0; j < 6; j++) {
          resp[j][i + 18 - n] = v[k].v[j];
          if (v[k].v[j])
            ;
        }
      }
      for (int i = 0; i < 6; i++) {
        if (i) printf(" ");
        print(resp[i]);
      }
      printf("\n");
    }
  }
}
