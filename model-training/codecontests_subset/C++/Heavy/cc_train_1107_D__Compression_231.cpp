#include <bits/stdc++.h>
using namespace std;
long long int n;
vector<string> fuck;
long long int sum[5300][5300];
char ch;
int main() {
  scanf("%lld", &n);
  for (long long int i = 0; i < n; i++) {
    string to_add = "";
    for (long long int j = 0; j < n / 4; j++) {
      cin >> ch;
      long long int num;
      if (ch >= '0' && ch <= '9') {
        num = ch - '0';
      } else {
        num = ch - 'A' + 10;
      }
      string temp = "";
      while (num) {
        temp += (num % 2) + '0';
        num /= 2;
      }
      while ((long long int)temp.size() < 4LL) temp += '0';
      reverse(temp.begin(), temp.end());
      to_add += temp;
    }
    fuck.push_back(to_add);
  }
  for (long long int i = 0; i < n; i++) {
    if (fuck[i][0] == '0')
      sum[i][0] = 0;
    else
      sum[i][0] = 1;
    for (long long int j = 1; j < n; j++) {
      if (fuck[i][j] == '0')
        sum[i][j] = sum[i][j - 1];
      else
        sum[i][j] = sum[i][j - 1] + 1;
    }
  }
  for (long long int j = 0; j < n; j++) {
    for (long long int i = 1; i < n; i++) {
      sum[i][j] += sum[i - 1][j];
    }
  }
  for (long long int x = n; x >= 1; x--) {
    if (n % x == 0) {
      bool ok = true;
      long long int r1 = 0;
      long long int r2 = x - 1;
      while (r1 < n) {
        long long int c1 = 0;
        long long int c2 = x - 1;
        while (c1 < n) {
          long long int Ans = sum[r2][c2];
          if (c1 > 0) Ans -= sum[r2][c1 - 1];
          if (r1 > 0) Ans -= sum[r1 - 1][c2];
          if (r1 > 0 && c1 > 0) Ans += sum[r1 - 1][c1 - 1];
          if (Ans == (x * x) || Ans == 0) {
            c1 += x;
            c2 += x;
          } else {
            ok = false;
            break;
          }
        }
        r1 += x;
        r2 += x;
        if (!ok) break;
      }
      if (ok) {
        printf("%lld\n", x);
        exit(0);
      }
    }
  }
  return 0;
}
