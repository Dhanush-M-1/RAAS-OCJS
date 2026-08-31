#include <bits/stdc++.h>
using namespace std;
typedef pair< int, int > Pi;

int N;
bool xx[365][4][4];
int dp[3][3][365][7][7][7][7];

bool isin(int x, int y, int depth)
{
  if(0 <= x && 0 <= y && x < 3 && y < 3) {
    for(int i = 0; i < 2; i++) {
      for(int j = 0; j < 2; j++) {
        if(xx[depth][x + i][y + j]) return(false);
      }
    }
    return(true);
  }
  return(false);
}

bool rec(int x, int y, int depth, int lt, int lb, int rt, int rb)
{
  if(x == 0 && y == 0) lt = 0;
  if(x == 0 && y == 2) lb = 0;
  if(x == 2 && y == 0) rt = 0;
  if(x == 2 && y == 2) rb = 0;
  if(lt > 6 || lb > 6 || rt > 6 || rb > 6) return(false);
  if(!isin(x, y, depth)) return(false);
  if(depth == N) return(true);
  auto& curr = dp[x][y][depth][lt][lb][rt][rb];
  if(~curr) return(curr);
  for(int i = -2; i <= 2; i++) {
    if(rec(x + i, y, depth + 1, lt + 1, lb + 1, rt + 1, rb + 1)) return(curr = true);
    if(rec(x, y + i, depth + 1, lt + 1, lb + 1, rt + 1, rb + 1)) return(curr = true);
  }
  return(curr = false);
}

int main()
{
  while(cin >> N, N) {
    memset(dp, -1, sizeof(dp));
    for(int k = 0; k < N; k++) {
      for(int i = 0; i < 4; i++) {
        for(int j = 0; j < 4; j++) {
          cin >> xx[k][i][j];
        }
      }
    }
    cout << rec(1, 1, 0, 1, 1, 1, 1) << endl;
  }
}