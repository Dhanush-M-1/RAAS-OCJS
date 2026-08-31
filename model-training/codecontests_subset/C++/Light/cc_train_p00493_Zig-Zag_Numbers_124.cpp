#include <iostream>
#include <algorithm>
#include <climits>
#include <cstring>
#include <string>
#include <vector>
#include <cmath>
using namespace std;

#define MOD 10000

char A[510], B[510];
int M;
int memo[510][10][3][3][500];

int f(char *x, int i, int d, int c, int u, int r) {
  if (memo[i][c][d][u][r] >= 0) return memo[i][c][d][u][r];
  if (i == strlen(x)) {
    int ret = 0;
    if (u != 2) ret = r == 0;
    return memo[i][c][d][u][r] = ret;
  }
  int ret = r == 0;
  for (int k=0; k<10; k++) {
    int nu = u;
    if (c == k) continue;
    if (d == 0 && c < k) continue;
    if (d == 1 && c > k) continue;
    int nd;
    if (d == 2) nd = c > k;
    else        nd = 1-d;
    if (u == 1 && k > (int)(x[i] - '0')) nu = 2;
    if (u == 1 && k < (int)(x[i] - '0')) nu = 0;
    ret += f(x, i+1, nd, k, nu, (k + r*10) % M);
    ret %= MOD;
  }
  return memo[i][c][d][u][r] = ret;
}

int f(char *x) {
  int ret = 0;
  for (int i=0; i<510; i++) {
    for (int j=0; j<10; j++) {
      for (int d=0; d<3; d++) {
        for (int k=0; k<3; k++) {
          for (int l=0; l<500; l++) {
            memo[i][j][d][k][l] = -1;
          }
        }
      }
    }
  }
  for (int i=1; i<10; i++) {
    char c = (int)(x[0] - '0');
    ret += f(x, 1, 2, i, i > c ? 2 : (i == c ? 1 : 0), i % M);
    ret %= MOD;
  }
  return ret;
}

void decrement(char *x) {
  int L = strlen(x);
  int h = L - 1;
  while (x[h] == '0') {
    x[h] = '9';
    h -= 1;
  }
  x[h] = (char)(x[h] - 1);
  if (L > 1 && h == 0) {
    for (int i=0; i<L-1; i++) x[i] = x[i+1];
    x[L-1] = '\0';
  }
}

int main() {
  cin >> A >> B >> M;
  decrement(A);
  cout << (f(B) - f(A) + MOD) % MOD << "\n";
  return 0;
}