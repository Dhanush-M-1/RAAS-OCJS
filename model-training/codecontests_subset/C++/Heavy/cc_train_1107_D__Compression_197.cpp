#include <bits/stdc++.h>
using namespace std;
char s[5400][5400];
char pp[5400];
map<char, string> ma;
int gcd(int a, int b) {
  int r;
  while (b > 0) {
    r = a % b;
    a = b;
    b = r;
  }
  return a;
}
int main() {
  ma['0'] = "0000";
  ma['1'] = "0001";
  ma['2'] = "0010";
  ma['3'] = "0011";
  ma['4'] = "0100";
  ma['5'] = "0101";
  ma['6'] = "0110";
  ma['7'] = "0111";
  ma['8'] = "1000";
  ma['9'] = "1001";
  ma['A'] = "1010";
  ma['B'] = "1011";
  ma['C'] = "1100";
  ma['D'] = "1101";
  ma['E'] = "1110";
  ma['F'] = "1111";
  int t;
  cin >> t;
  int len;
  for (int i = 1; i <= t; i++) {
    getchar();
    scanf("%s", pp);
    len = strlen(pp);
    for (int j = 0; j < len; j++) {
      for (int k = j * 4 + 1; k <= j * 4 + 4; k++) {
        s[i][k] = ma[pp[j]][k - 4 * j - 1];
      }
    }
  }
  int n = t;
  int m = 4 * len;
  queue<int> q;
  int p = 0;
  for (int i = 1; i <= n; i++) {
    p = 0;
    for (int j = 1; j <= m; j++) {
      if (s[i][j] != s[i][j + 1] || j == m) {
        if (j - p == 1) {
          cout << 1 << endl;
          return 0;
        }
        q.push(j - p);
        p = j;
      }
    }
  }
  for (int i = 1; i <= m; i++) {
    p = 0;
    for (int j = 1; j <= n; j++) {
      if (s[j][i] != s[j + 1][i] || j == n) {
        if (j - p == 1) {
          cout << 1 << endl;
          return 0;
        }
        q.push(j - p);
        p = j;
      }
    }
  }
  int g = q.front();
  q.pop();
  while (!q.empty()) {
    g = gcd(g, q.front());
    q.pop();
  }
  cout << g << endl;
  return 0;
}
