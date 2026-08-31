#include <bits/stdc++.h>
using namespace std;
void quit() {
  fflush(stdout);
  exit(0);
}
long long int num;
int dig[50];
int poss[50];
int dp[50][10];
int bt[50][10];
int ans[6][50];
char buf[50];
int ndig;
void solve() {
  cin >> num;
  ndig = 0;
  long long int tmp = num;
  while (tmp) {
    dig[ndig++] = tmp % 10;
    tmp /= 10;
  }
  for (int i = 0; i < 50; i++) {
    for (int j = 0; j < 10; j++) dp[i][j] = -1;
  }
  memset(ans, 0, sizeof(ans));
  dp[0][0] = 0;
  for (int curdig = 0; curdig < ndig; curdig++) {
    for (int carry = 0; carry < 10; carry++) {
      if (dp[curdig][carry] < 0) continue;
      for (int add = 0; add < 50; add++) {
        if (poss[add] < 0) continue;
        int realadd = add + carry;
        if (realadd % 10 == dig[curdig]) {
          dp[curdig + 1][realadd / 10] = add;
          bt[curdig + 1][realadd / 10] = carry;
        }
      }
    }
  }
  if (dp[ndig][0] < 0) {
    cout << -1 << endl;
    return;
  }
  int curcarry = 0;
  for (int i = ndig; i > 0; i--) {
    int add = dp[i][curcarry];
    int n7 = poss[add] / 10, n4 = poss[add] % 10;
    for (int j = 0; j < n7; j++) {
      ans[j][i - 1] = 7;
    }
    for (int j = 0; j < n4; j++) {
      ans[j + n7][i - 1] = 4;
    }
    curcarry = bt[i][curcarry];
  }
  for (int curnum = 0; curnum < 6; curnum++) {
    int len = 0;
    for (int i = 49; i >= 0; i--) {
      if (ans[curnum][i]) {
        len = i + 1;
        break;
      }
    }
    if (len == 0) {
      cout << 0;
    } else {
      for (int i = 0; i < len; i++) {
        buf[i] = '0' + ans[curnum][len - 1 - i];
      }
      buf[len] = 0;
      cout << buf;
    }
    if (curnum == 5)
      cout << endl;
    else
      cout << ' ';
  }
}
int main(int argc, char** argv) {
  for (int i = 0; i < 50; i++) {
    poss[i] = -1;
  }
  for (int n0 = 0; n0 <= 6; n0++) {
    for (int n4 = 0; n4 <= 6 - n0; n4++) {
      int n7 = 6 - n0 - n4;
      int num = n4 * 4 + n7 * 7;
      poss[num] = 10 * n7 + n4;
    }
  }
  int nC;
  cin >> nC;
  while (nC--) solve();
  quit();
}
