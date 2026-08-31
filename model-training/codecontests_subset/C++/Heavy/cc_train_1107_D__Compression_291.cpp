#include <bits/stdc++.h>
using namespace std;
string htb(char s) {
  if (s == '0')
    return "0000";
  else if (s == '1')
    return "0001";
  else if (s == '2')
    return "0010";
  else if (s == '3')
    return "0011";
  else if (s == '4')
    return "0100";
  else if (s == '5')
    return "0101";
  else if (s == '6')
    return "0110";
  else if (s == '7')
    return "0111";
  else if (s == '8')
    return "1000";
  else if (s == '9')
    return "1001";
  else if (s == 'A')
    return "1010";
  else if (s == 'B')
    return "1011";
  else if (s == 'C')
    return "1100";
  else if (s == 'D')
    return "1101";
  else if (s == 'E')
    return "1110";
  else
    return "1111";
}
int main() {
  ios_base::sync_with_stdio(false);
  int n;
  cin >> n;
  vector<vector<int>> m(n + 1, vector<int>(n + 1, 0));
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n / 4; j++) {
      char c;
      cin >> c;
      string s = htb(c);
      m[i][4 * j - 3] = s[0] - '0';
      m[i][4 * j - 2] = s[1] - '0';
      m[i][4 * j - 1] = s[2] - '0';
      m[i][4 * j] = s[3] - '0';
    }
  }
  for (int i = 2; i < n + 1; i++) {
    m[i][1] += m[i - 1][1];
    m[1][i] += m[1][i - 1];
  }
  for (int i = 2; i < n + 1; i++)
    for (int j = 2; j < n + 1; j++)
      m[i][j] += m[i][j - 1] + m[i - 1][j] - m[i - 1][j - 1];
  int y = 1, t = 0;
  for (int x = 2; x < n + 1; x++) {
    t = 0;
    if (n % x == 0)
      for (int i = 1; i <= n / x; i++) {
        for (int j = 1; j <= n / x; j++) {
          int it = i * x, jt = j * x, u;
          u = m[it][jt] - m[it][jt - x] - m[it - x][jt] + m[it - x][jt - x];
          if (u != x * x && u != 0) {
            t = 1;
            break;
          }
        }
        if (t == 1) break;
      }
    if (t == 0 && n % x == 0) y = x;
  }
  cout << y;
  return 0;
}
