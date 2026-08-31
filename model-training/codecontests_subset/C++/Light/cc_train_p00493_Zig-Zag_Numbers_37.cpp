#include <iostream>
#include <algorithm>
#include <climits>
#include <string>
#include <vector>
#include <cmath>
using namespace std;

#define MOD 10000
//#define MOD 1145141919

string A, B;
int M;
int dp[510][10][2][3][2][510];

int f(string &X, int i, int L, int lc, bool d, int e, bool zero, int m) {
  if (dp[i][lc][d][e][zero][m] != -1) return dp[i][lc][d][e][zero][m];
  if (i == L-1) {
    return dp[i][lc][d][e][zero][m] = (e == 2 ? 0 : zero ? 0 : m == 0);
  }
  int ret = 0;
  for (int c=0; c<10; c++) {
    int nz = false;
    if (zero) {
      if (c == 0) nz = true;
    }
    else {
      if (d == 0 && lc <= c) continue;
      if (d == 1 && lc >= c) continue;
    }
    int ne = e;
    int h = (int)X[i+1] - (int)'0';
    if (e == 1 && c < h) ne = 0;
    if (e == 1 && c > h) ne = 2;
    ret = (ret + f(X, i+1, L, c, !d, ne, nz, (m*10 + c) % M)) % MOD;
  }
  return dp[i][lc][d][e][zero][m] = ret;
}

void reset() {
  for (int i=0; i<510; i++) {
    for (int j=0; j<10; j++) {
      for (int k=0; k<2; k++) {
        for (int e=0; e<2; e++) {
          for (int zero=0; zero<2; zero++) {
            for (int l=0; l<510; l++) {
              dp[i][j][k][e][zero][l] = -1;
            }
          }
        }
      }
    }
  }
}

int solve(string X) {
  if (X.length() == 1) {
    int t = (int)X[0] - (int)'0';
    int x = 0;
    for (int i=1; i<=t; i++) if (i % M == 0) x++;
    return x;
  }

  int x = 0;
  for (int i=1; i<10; i++) if (i % M == 0) x++;
  int i = X[0] == '0';
  int ans = -x;
  reset();
  int L = X.length();
  for (int c=0; c<10; c++) {
    int h = (int)X[i] - (int)'0';
    int e = c < h ? 0 : (c == h ? 1 : 2);
    ans = (ans + f(X, i, L, c, true , e, c == 0, c % M)) % MOD;
    ans = (ans + f(X, i, L, c, false, e, c == 0, c % M)) % MOD;
  }
  return ans;
}

int main() {
  cin >> A >> B >> M;
  // A -= 1
  int h = A.length() - 1;
  while (true) {
    if (A[h] > '0') {
      A[h] = (char)((int)A[h]-1);
      break;
    }
    A[h] = '9';
    h -= 1;
  }
  cout << (solve(B) - solve(A) + MOD) % MOD << "\n";
  return 0;
}