#include <bits/stdc++.h>
using namespace std;
int raod[5201][5201];
int n, in1, in2, first;
string second;
bool check(int x) {
  for (int i = 1; i <= n / x; i++) {
    for (int j = 1; j <= n / x; j++) {
      in1 = i * x;
      in2 = j * x;
      first = raod[in1][in2] - raod[in1 - x][in2] - raod[in1][in2 - x] +
              raod[in1 - x][in2 - x];
      if (first != 0 && first != x * x) return false;
    }
  }
  return true;
}
int main() {
  ios::sync_with_stdio(false);
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> second;
    for (int j = 0; j < second.size(); j++) {
      int x;
      if (second[j] >= '0' && second[j] <= '9')
        x = second[j] - '0';
      else
        x = (second[j] - 'A') + 10;
      string p = "";
      while (x) {
        if (x & 1)
          p += '1';
        else
          p += '0';
        x /= 2;
      }
      while ((int)p.size() != 4) p += '0';
      reverse(p.begin(), p.end());
      for (int l = 0; l < 4; l++)
        raod[i][j * 4 + l + 1] = raod[i - 1][j * 4 + l + 1] +
                                 raod[i][j * 4 + l] - raod[i - 1][j * 4 + l] +
                                 (p[l] == '1');
    }
  }
  for (int i = n; i >= 1; i--) {
    if (n % i != 0) continue;
    if (check(i)) {
      cout << i << '\n';
      return 0;
    }
  }
  return 0;
}
