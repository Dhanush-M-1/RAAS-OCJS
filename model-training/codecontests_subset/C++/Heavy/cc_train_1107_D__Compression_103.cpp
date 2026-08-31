#include <bits/stdc++.h>
using namespace std;
const int N = 5201;
int a[N][N];
vector<int> elig;
void compute_elig(int n) {
  for (int i = 1; i * i <= n; i++) {
    if (n % i == 0) {
      elig[i] = 1;
      elig[n / i] = 1;
    }
  }
}
int check(int k, int n) {
  for (int i = 1; i <= n; i += k) {
    for (int j = 1; j <= n; j += k) {
      for (int p = i; p < i + k; p++) {
        for (int q = j; q < j + k; q++) {
          if (a[i][j] != a[p][q]) return 0;
        }
      }
    }
  }
  return 1;
}
int32_t main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  int n;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j += 4) {
      char ch;
      cin >> ch;
      int val;
      if (isdigit(ch))
        val = ch - '0';
      else
        val = ch - 'A' + 10;
      int cur = 8;
      for (int k = j; k <= j + 3; k++) {
        if (val >= cur) {
          val -= cur;
          a[i][k] = 1;
        }
        cur /= 2;
      }
    }
  }
  elig.resize(n + 1, 0);
  compute_elig(n);
  for (int i = n; i >= 1; i--) {
    if (elig[i]) {
      if (check(i, n)) {
        cout << i << "\n";
        return 0;
      }
    }
  }
  cout << 1;
}
