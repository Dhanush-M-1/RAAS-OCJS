#include <bits/stdc++.h>
using namespace std;
long long int LONG_INT_MAX = 1000000000000005;
long long int mod = 998244353;
long long int mod1 = 1e9 + 7;
int a[5205][5205];
bool check(int b, int n) {
  for (int i = 0; i < n; i += b) {
    for (int j = 0; j < n; j += b) {
      int type = -1;
      for (int k = 0; k < b; k++) {
        for (int l = 0; l < b; l++) {
          if (type == -1) {
            type = a[i + k][j + l];
          } else {
            if (type != a[i + k][j + l]) {
              return false;
            }
          }
        }
      }
    }
  }
  return true;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n / 4; j++) {
      char c;
      cin >> c;
      int val;
      if (c <= '9' && c >= '0') {
        val = c - '0';
      } else {
        val = c - 'A' + 10;
      }
      int base = 8;
      int inp;
      int cnt = 0;
      while (val != 0) {
        if (val >= base) {
          inp = 1;
          val -= base;
        } else {
          inp = 0;
        }
        a[i][j * 4 + cnt] = inp;
        cnt++;
        base /= 2;
      }
    }
  }
  vector<int> fac;
  for (int i = 1; i < sqrt(n); i++) {
    if (n % i == 0) {
      fac.push_back(i);
      fac.push_back(n / i);
    }
  }
  if (sqrt(n) * sqrt(n) == n) {
    fac.push_back(sqrt(n));
  }
  sort(fac.begin(), fac.end());
  int low = 0;
  for (int i = fac.size() - 1; i >= 0; i--) {
    if (check(fac[i], n)) {
      low = i;
      break;
    }
  }
  cout << fac[low] << endl;
  return 0;
}
