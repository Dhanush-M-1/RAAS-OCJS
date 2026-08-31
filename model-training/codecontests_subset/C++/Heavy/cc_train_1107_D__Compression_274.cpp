#include <bits/stdc++.h>
using namespace std;
int arr[5310][5310];
int n;
bool check(int v) {
  for (int i = 0; i < n; i += v) {
    for (int j = 0; j < n; j += v) {
      for (int i1 = 0; i1 < v; ++i1) {
        for (int j1 = 0; j1 < v; ++j1) {
          if (arr[i + i1][j + j1] != arr[i][j]) return false;
        }
      }
    }
  }
  return true;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin >> n;
  vector<int> fact;
  for (int i = 1; i < n + 1; ++i) {
    if (n % i == 0) fact.push_back(i);
  }
  cerr << (int)fact.size() << endl;
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < n / 4; ++j) {
      char c;
      cin >> c;
      int res = 0;
      if (c <= '9')
        res = c - 48;
      else
        res = c - 'A' + 10;
      for (int k = 3; k >= 0; k--) {
        arr[i][(j << 2) + k] = res & 1;
        res >>= 1;
      }
    }
  }
  reverse(fact.begin(), fact.end());
  for (auto v : fact) {
    if (check(v)) {
      cout << v << endl;
      return 0;
    }
  }
}
