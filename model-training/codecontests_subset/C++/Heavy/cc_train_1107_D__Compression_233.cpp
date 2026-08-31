#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
#pragma GCC optimize("unroll-loops")
#pragma GCC target("sse2")
using namespace std;
map<int, string> m;
vector<vector<int>> a;
vector<int> elig;
void convert_input(int i, int j, char c) {
  if (c >= 48 and c <= 58) {
    int f = (int)(c - 48);
    for (int k = 0; k < 4; k++) {
      if (f & (1 << k))
        a[i][j + 3 - k] = 1;
      else
        a[i][j + 3 - k] = 0;
    }
  } else {
    int f = 10 + (int)(c - 65);
    for (int k = 0; k < 4; k++) {
      if (f & (1 << k))
        a[i][j + 3 - k] = 1;
      else
        a[i][j + 3 - k] = 0;
    }
  }
}
void preprocess(int n) {
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j += 4) {
      char c;
      cin >> c;
      convert_input(i, j, c);
    }
  }
}
void compute_elig(int n) {
  for (int i = 1; i * i <= n; i++) {
    if (n % i == 0) {
      elig[i] = 1;
      elig[n / i] = 1;
    }
  }
}
void update(int n) { ; }
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
  a.resize(n + 1, vector<int>(n + 1));
  preprocess(n);
  elig.resize(n + 1, 0);
  compute_elig(n);
  for (int i = n; i >= 1; i--) {
    if (elig[i]) {
      if (check(i, n)) {
        cout << i << "\n";
        return 0;
      } else
        update(i);
    }
  }
  cout << 1;
}
