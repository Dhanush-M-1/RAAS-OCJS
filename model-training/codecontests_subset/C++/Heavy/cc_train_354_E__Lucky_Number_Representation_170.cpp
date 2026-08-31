#include <bits/stdc++.h>
using namespace std;
struct num_6 {
  int a[10];
};
vector<num_6> act;
string dest[10];
vector<int> num;
num_6 glo;
int val[] = {0, 4, 7};
set<int> myset;
void rec(int i, int j, int nu) {
  if (i == 3) return;
  if (j == 6) {
    if (myset.count(nu) == 0) {
      myset.insert(nu);
      num.push_back(nu);
      act.push_back(glo);
    }
    return;
  }
  rec(i + 1, j, nu);
  glo.a[j] = val[i];
  rec(i, j + 1, nu + val[i]);
}
string str;
int dp[22][11], len;
int memoize(int dig, int cary) {
  if (dig == -1 && !cary) return 1;
  if (dig < 0) return 0;
  if (dp[dig][cary] != -1) return dp[dig][cary];
  int ans = 0;
  for (int i = int(0); i <= int(27); i++) {
    if (str[dig] - '0' == (cary + num[i]) % 10)
      ans |= memoize(dig - 1, (cary + num[i]) / 10);
    if (ans) break;
  }
  return dp[dig][cary] = ans;
}
void print(int dig, int cary) {
  if (dig == -1) return;
  for (int i = int(0); i <= int(27); i++) {
    if (str[dig] - '0' == (cary + num[i]) % 10) {
      if (memoize(dig - 1, (cary + num[i]) / 10)) {
        for (int j = int(0); j <= int(5); j++) {
          dest[j] += ('0' + act[i].a[j]);
        }
        print(dig - 1, (cary + num[i]) / 10);
        break;
      }
    }
  }
}
int main() {
  rec(0, 0, 0);
  int t;
  scanf("%d", &t);
  while (t--) {
    memset(dp, -1, sizeof(dp));
    cin >> str;
    len = str.length();
    int ans = memoize(len - 1, 0);
    if (ans) {
      for (int i = int(0); i <= int(6); i++) dest[i] = "";
      print(len - 1, 0);
      for (int i = int(0); i <= int(5); i++) {
        reverse(dest[i].begin(), dest[i].end());
        int j = 0;
        int len = dest[i].length();
        while (j <= len - 2) {
          if (dest[i][j] != '0') break;
          j++;
        }
        for (int k = int(j); k <= int(len - 1); k++) {
          printf("%c", dest[i][k]);
        }
        printf(" ");
      }
      printf("\n");
    } else {
      printf("-1\n");
    }
  }
  return 0;
}
