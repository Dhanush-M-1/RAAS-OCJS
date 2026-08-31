#include<bits/stdc++.h>
using namespace std;

#define MOD 1000000007
#define MAXM 200015

long long y;

int pd[MAXM];
int solve(int x){
  if(x < 0) return 0;
  if(pd[x] == -1){
    if(x <= 9) pd[x] = 1;
    else{
      y = (solve(x - 10) + solve(x - 9));
      if(y > MOD) y -= MOD;
      pd[x] = y;
    }
  }
  return pd[x];
}

int main(){
  int t; scanf("%d", &t);
  memset(pd, -1, sizeof pd);
  solve(MAXM - 1);
  while(t--){
    char n[10]; scanf("%s", n);
    int m; scanf("%d", &m);

    long long ans = 0;
    for(int i = 0; n[i]; ++i){
      int z = n[i] - '0';
      ans += solve(m + z);
      ans %= MOD;
    }
    printf("%lld\n", ans);
  }
}
