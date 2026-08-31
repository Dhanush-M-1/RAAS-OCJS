#include <bits/stdc++.h>
using namespace std;

const int MAXN = 400;
const int R = 4;
const int W = 7;
const int di[] = {0,1,0,-1};
const int dj[] = {1,0,-1,0};
int N;
int F[MAXN][R][R];
bool dp[MAXN][R][R][W][W][W][W];

int main() {
  while(cin >> N && N) {
    for(int k = 0; k < N; ++k)
      for(int i = 0; i < R; ++i)
        for(int j = 0; j < R; ++j)
          cin >> F[k][i][j];
    memset(dp, 0, sizeof(dp));
    dp[0][1][1][0][0][0][0] = 1;
    bool ok = false;
    for(int k = 0; k < N; ++k)
      for(int i = 0; i < R; ++i)
        for(int j = 0; j < R; ++j)
          for(int a = 0; a < W; ++a)
            for(int b = 0; b < W; ++b)
              for(int c = 0; c < W; ++c)
                for(int d = 0; d < W; ++d) {
                  if(!dp[k][i][j][a][b][c][d]) continue;
                  for(int s = 0; s < 4; ++s)
                    for(int l = 0; l <= 2; ++l) {
                      if(k == 0 && l) continue;
                      int ni = i + di[s] * l;
                      int nj = j + dj[s] * l;
                      if(ni < 0 || ni + 1 >= R) continue;
                      if(nj < 0 || nj + 1 >= R) continue;
                      if(F[k][ni][nj]) continue;
                      if(F[k][ni][nj+1]) continue;
                      if(F[k][ni+1][nj]) continue;
                      if(F[k][ni+1][nj+1]) continue;
                      int na = (ni == 0 && nj == 0 ? 0 : a + 1);
                      int nb = (ni == 0 && nj+1 == R-1 ? 0 : b + 1);
                      int nc = (ni+1 == R-1 && nj == 0 ? 0 : c + 1);
                      int nd = (ni+1 == R-1 && nj+1 == R-1 ? 0 : d + 1);
                      if(max(max(na,nb),max(nc,nd)) >= W) continue;
                      dp[k+1][ni][nj][na][nb][nc][nd] = true;
                      if(k+1 == N) ok = true;
                    }
                }
    cout << ok << endl;
  }
  return 0;
}