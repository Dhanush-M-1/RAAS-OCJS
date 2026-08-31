#include <bits/stdc++.h>
using namespace std;
const double PI = 3.14159265358979323846;
const double eps = (1e-8);
string g[5205];
int rEqual[5205][5205], cEqual[5205][5205];
int n;
bool check(int x) {
  for (int j = 0; j < n; j += x) {
    for (int i = 0; i < n; i += x) {
      if (rEqual[i][j] < x || cEqual[i][j] < x) return false;
      for (int st = j; st < j + x; ++st) {
        if (cEqual[i][st] < x) return false;
      }
    }
  }
  return true;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n;
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < n / 4; ++j) {
      char c;
      cin >> c;
      if (isalpha(c)) {
        c -= 'A' - 10;
      } else
        c -= '0';
      string bin;
      while (c) {
        bin += c % 2 + '0';
        c /= 2;
      }
      while ((int)(bin).size() < 4) bin += '0';
      reverse(bin.begin(), bin.end());
      g[i] += bin;
    }
  }
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < n; ++j) {
      int st = j;
      char c = g[i][j];
      while (j < n && g[i][j] == c) {
        rEqual[i][st]++;
        ++j;
      }
      --j;
      for (int k = st + 1; k <= j; ++k) rEqual[i][k] = rEqual[i][k - 1] - 1;
    }
  }
  for (int j = 0; j < n; ++j) {
    for (int i = 0; i < n; ++i) {
      int st = i;
      char c = g[i][j];
      while (i < n && g[i][j] == c) {
        cEqual[st][j]++;
        ++i;
      }
      --i;
      for (int k = st + 1; k <= i; ++k) cEqual[k][j] = cEqual[k - 1][j] - 1;
    }
  }
  for (int i = n; i > 1; --i) {
    if (n % i == 0 && check(i)) {
      cout << i << '\n';
      return 0;
    }
  }
  cout << 1 << '\n';
  return 0;
}
