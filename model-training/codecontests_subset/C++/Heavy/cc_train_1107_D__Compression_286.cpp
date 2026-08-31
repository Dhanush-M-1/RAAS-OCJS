#include <bits/stdc++.h>
using namespace std;
string conv(char ch);
void solve();
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  solve();
  return 0;
}
void solve() {
  int i, j, n, c, x, ind;
  int flag = 0;
  double avg;
  cin >> n;
  string s[n], bin;
  bool a[n][n];
  int row[n][n + 1], pfs[n + 1][n + 1];
  vector<int> factors;
  for (i = 0; i < n; i++) {
    cin >> s[i];
  }
  for (i = 0; i < n; i++) {
    for (j = 0; j < n; j += 4) {
      bin = conv(s[i][j / 4]);
      a[i][j] = bin[0] - '0';
      a[i][j + 1] = bin[1] - '0';
      a[i][j + 2] = bin[2] - '0';
      a[i][j + 3] = bin[3] - '0';
    }
  }
  for (i = 0; i < n; i++) {
    row[i][0] = 0;
    for (j = 0; j < n; j++) {
      row[i][j + 1] = a[i][j] + row[i][j];
    }
  }
  for (i = 0; i < n + 1; i++) {
    pfs[0][i] = 0;
    pfs[i][0] = 0;
  }
  for (i = 0; i < n; i++) {
    for (j = 0; j < n; j++) {
      pfs[i + 1][j + 1] = pfs[i][j + 1] + row[i][j + 1];
    }
  }
  double sr = sqrt(n);
  for (i = 1; i <= sr; i++) {
    if (n % i == 0) {
      factors.push_back(i);
      if (i != sr) factors.push_back(n / i);
    }
  }
  sort(factors.begin(), factors.end());
  for (ind = factors.size() - 1; ind != -1; ind--) {
    x = factors[ind];
    flag = 0;
    for (i = 0; i < n; i += x) {
      for (j = 0; j < n; j += x) {
        avg = pfs[i + x][j + x] - pfs[i + x][j] - pfs[i][j + x] + pfs[i][j];
        avg /= (x * x);
        if (avg != 1 && avg != 0) {
          flag = 1;
          break;
        }
      }
      if (flag) break;
    }
    if (!flag) {
      cout << x;
      return;
    }
  }
}
string conv(char ch) {
  switch (ch) {
    case '0':
      return "0000";
    case '1':
      return "0001";
    case '2':
      return "0010";
    case '3':
      return "0011";
    case '4':
      return "0100";
    case '5':
      return "0101";
    case '6':
      return "0110";
    case '7':
      return "0111";
    case '8':
      return "1000";
    case '9':
      return "1001";
    case 'A':
      return "1010";
    case 'B':
      return "1011";
    case 'C':
      return "1100";
    case 'D':
      return "1101";
    case 'E':
      return "1110";
    case 'F':
      return "1111";
    default:
      return "";
  }
}
