#include <bits/stdc++.h>
using namespace std;
const long double pi = 3.141592653589793238462643;
int n;
int m;
int k;
string str;
int s[5210][5210];
bool ch(int x) {
  bool f = 1;
  x = n / x;
  for (int i = 0; i < n / x; i++) {
    for (int j = 0; j < n / x; j++) {
      int sum = s[(i + 1) * x][(j + 1) * x] - s[i * x][(j + 1) * x] -
                s[(i + 1) * x][j * x] + s[i * x][j * x];
      if (sum == 0 || sum == x * x)
        f *= 1;
      else
        f *= 0;
    }
  }
  return f;
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> n;
  for (int i = 0; i < (n); i++) {
    cin >> str;
    for (int j = 0; j < (n / 4); j++) {
      int x = 0;
      if (str[j] >= '0' && str[j] <= '9')
        x = str[j] - '0';
      else
        x = str[j] - 'A' + 10;
      for (int k = (4) - 1; k >= 0; k--) {
        s[i + 1][j * 4 + k + 1] = x % 2;
        x /= 2;
      }
    }
  }
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++) {
      s[i][j] += s[i][j - 1] + s[i - 1][j] - s[i - 1][j - 1];
    }
  }
  for (int i = 1; i <= n; i++) {
    if (n % i == 0 && ch(i)) {
      cout << n / i;
      return 0;
    }
  }
  return 0;
}
