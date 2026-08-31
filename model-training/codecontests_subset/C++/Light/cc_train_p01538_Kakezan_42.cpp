#include <cstring>
#define REP(i,n) for(int i=0; i<(int)(n); i++)

#include <cstdio>
inline int getInt(){ int s; scanf("%d", &s); return s; }

#include <set>
using namespace std;

int dp[1000000 + 100000];
int solve(int n){
  if(n < 10) return 0;
  if(dp[n] != -1) return dp[n];

  int now = 0;
  int nn = n;

  int next = 0;

  int tmp = 1;
  while(true){
    now += tmp * (nn % 10);
    nn /= 10;

    if(nn == 0) break;
    next = max(next, now * nn);
    tmp *= 10;
  }

  return dp[n] = solve(next) + 1;
}

int main(){
  const int q = getInt();
  memset(dp, -1, sizeof(dp));

  REP(i,q)
    printf("%d\n", solve(getInt()));

  return 0;
}