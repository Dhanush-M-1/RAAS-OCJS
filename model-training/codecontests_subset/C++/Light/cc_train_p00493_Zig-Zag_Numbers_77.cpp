#include <bits/stdc++.h>
using namespace std;

int M;
const int MOD = 10000;
string A, B;
int memo[512][2][2][10][512];

int dfs2(int i, bool low, bool tight, int pre, int rem);

int dfs1(int i=0, bool tight=true)
{
  int x = B[i] - '0';
  int r = (tight) ? (x) : 9;
  int ret = 0;
  
  if (B.size() - 1 == i){
    for (int j = 1; j <= r; j++){
      if (j % M) continue;
      ret++;
    }
    return ret;
  }

  ret += dfs1(i + 1, false);
  for (int j = 1; j <= r; ++j){
    ret += dfs2(i + 1, true, tight && x == j, j, j % M);
    ret += dfs2(i + 1, false, tight && x == j, j, j % M);
  }

  return ret % MOD;
}

int dfs2(int i, bool low, bool tight, int pre, int rem)
{
  if (i == B.size()){
    return rem == 0;
  }
  int &ret = memo[i][low][tight][pre][rem];

  if (ret != -1){
    return ret;
  }
  ret = 0;
  int x = B[i] - '0';
  int r = low ? pre - 1 : 9;
  int l = low ? 0 : (pre + 1);

  if (tight){
    r = min(r, x);
  }

  for (int j = l; j <= r; j++){
    ret += dfs2(i + 1, !low, tight && j == x, j, (rem * 10 + j) % M);
  }

  return ret %= MOD;
}

int main()
{
  cin >> A >> B >> M;

  for (int i = A.size() - 1; i >= 0; --i){
    if (A[i] - '0'){
      A[i]--;
      break;
    }
    A[i] = '9';
  }
  if (A[0] == '0' && A.size() != 1) A = A.substr(1);
  memset(memo, -1, sizeof(memo));
  int b = dfs1();
  swap(A, B);
  memset(memo, -1, sizeof(memo));
  int a = dfs1();

  cout << (b - a + MOD) % MOD << endl;
}