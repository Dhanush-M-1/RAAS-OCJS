#include <cstring>
#include <cstdio>
#include <algorithm>
#define REP(i,n) for(int i=0; i<(int)(n); i++)

using namespace std;

int dp[2][2][2][2][2][10][512];

char a[512];
char b[512];
int m;
int aa[512];
int bb[512];

int main(){
  scanf("%s", a);
  scanf("%s", b);
  scanf("%d", &m);

  int nb = strlen(b);
  int na = strlen(a);

  REP(i,na) aa[i] = a[na - i - 1] - '0';
  REP(i,nb) bb[i] = b[nb - i - 1] - '0';

  reverse(aa, aa + nb);
  reverse(bb, bb + nb);

  for(int i = aa[0]; i <= bb[0]; i++){
    int fa = 0;
    int fb = 0;
    int nz = 0;
    if(i > aa[0]) fa = 1;
    if(i < bb[0]) fb = 1;
    if(i != 0) nz = 1;
    dp[0][fa][fb][nz][0][i][i % m] = 1;
    if(nz == 1 && nb != 1)
      dp[0][fa][fb][nz][1][i][i % m] = 1;
  }

  REP(i,nb - 1){
    REP(fa,2) REP(fb,2) REP(nz,2) REP(ud,2) REP(p, 10) REP(am, m)
      dp[(i + 1) % 2][fa][fb][nz][ud][p][am] = 0;

    REP(fa,2) REP(fb,2) REP(nz,2) REP(ud,2)
      REP(p,10) REP(am, m) if(dp[i % 2][fa][fb][nz][ud][p][am]){
      int low  = 0;
      int high = 9;

      // printf("%d: %d %d %d %d %d %d: %d\n", i, fa, fb, nz, ud, p, am, dp[i % 2][fa][fb][nz][ud][p][am]);

      if(fa == 0) low  = aa[i + 1];
      if(fb == 0) high = bb[i + 1];

      if(nz == 1){
        if(ud == 0) low  = max(low, p + 1);
        else        high = min(high, p - 1);
      }

      for(int next = low; next <= high; next++){
        int ffa = fa;
        int ffb = fb;
        int nnz = nz;
        if(next > aa[i + 1]) ffa = 1;
        if(next < bb[i + 1]) ffb = 1;
        if(next > 0) nnz = 1;
        if(nz == 0 && nnz == 1 && i != nb - 2){
          dp[(i + 1) % 2][ffa][ffb][nnz][0][next][(am * 10 + next) % m]
            = (dp[i % 2][fa][fb][nz][ud][p][am] + dp[(i + 1) % 2][ffa][ffb][nnz][0][next][(am * 10 + next) % m]) % 10000;
          dp[(i + 1) % 2][ffa][ffb][nnz][1][next][(am * 10 + next) % m]
            = (dp[i % 2][fa][fb][nz][ud][p][am] + dp[(i + 1) % 2][ffa][ffb][nnz][1][next][(am * 10 + next) % m]) % 10000;
        }else{
          dp[(i + 1) % 2][ffa][ffb][nnz][!ud][next][(am * 10 + next) % m]
            = (dp[i % 2][fa][fb][nz][ud][p][am] + dp[(i + 1) % 2][ffa][ffb][nnz][!ud][next][(am * 10 + next) % m]) % 10000;
        }
      }
    }
  }

  int ans = 0;

  REP(fa,2) REP(fb,2) REP(ud,2) REP(p,10)
    ans = (ans + dp[(nb - 1) % 2][fa][fb][1][ud][p][0]) % 10000;

  printf("%d\n", ans);
  return 0;
}