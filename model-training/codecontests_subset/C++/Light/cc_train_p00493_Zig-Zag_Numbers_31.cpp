
#include <iostream>
#include <cstring>
#include <cstdio>
using namespace std;

#define MOD 10000

int M;
char A[503], B[503];
short dp[503][10][2][2][503];

void dec(char *t){
  int n = strlen(t);
  t[n - 1]--;

  for(int i = n - 1; i > 0; i--){
    if(t[i] < '0'){
      t[i] += 10;
      t[i - 1]--;
    }
  }

  if(t[0] == '0'){
    for(int i = 0; i < n; i++){
      t[i] = t[i + 1];
    }
  }
}

int solve(char *t){
  int n = strlen(t);

  for(int i = 0; i < n; i++){
    t[i] -= '0';
  }

  memset(dp, 0, sizeof(dp));

  for(int i = 1; i <= t[0]; i++){
    dp[1][i][0][i == t[0]][i % M] = 1;
    if(n != 1){
      dp[1][i][1][i == t[0]][i % M] = 1;
    }
  }

  for(int i = 1; i < n; i++){
    for(int next = 1; next <= 9; next++){
      dp[i + 1][next][0][0][next % M]++;
      dp[i + 1][next][0][0][next % M] %= MOD;
      if(i != n - 1){
        dp[i + 1][next][1][0][next % M]++;
        dp[i + 1][next][1][0][next % M] %= MOD;
      }
    }

    for(int before = 0; before <= 9; before++){
      for(int up = 0; up < 2; up++){
        for(int eq = 0; eq < 2; eq++){
          int from = up ? 0 : before + 1;
          int to = up ? before - 1 : 9;
          if(eq) to = min(to, (int)t[i]);

          for(int rem = 0; rem < M; rem++){
            if(dp[i][before][up][eq][rem] == 0) continue;

            for(int next = from; next <= to; next++){
              int nextEq = eq && next == t[i];
              int nextRem = (rem * 10 + next) % M;
              dp[i + 1][next][!up][nextEq][nextRem] += dp[i][before][up][eq][rem];
              dp[i + 1][next][!up][nextEq][nextRem] %= MOD;
            }
          }
        }
      }
    }
  }

  int res = 0;

  for(int before = 0; before <= 9; before++){
    for(int up = 0; up < 2; up++){
      for(int eq = 0; eq < 2; eq++){
        if(dp[n][before][up][eq][0] == 0) continue;
        //printf("before:%d up:%d eq:%d = %d\n",before,up,eq,dp[n][before][up][eq][0]);
        res += dp[n][before][up][eq][0];
        res %= MOD;
      }
    }
  }

  return res;
}

int main(){
  while(scanf("%s%s%d", A, B, &M) != EOF){
    dec(A);
    printf("%d\n", (solve(B) - solve(A) + MOD) % MOD);
  }
}