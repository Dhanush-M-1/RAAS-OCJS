#include <bits/stdc++.h>
using namespace std;
const int N = 1e6 + 5;
const int LOG = 21;
int n, r, c;
string lst[N];
int nx[LOG][N];
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> r >> c;
  for (int i = 0; i < n; ++i) cin >> lst[i];
  int sum = -1;
  int p2 = 0;
  for (int i = 0; i < n; ++i) {
    while (p2 < i) {
      sum += lst[p2].size() + 1;
      p2++;
    }
    if (i > 0) sum -= lst[i - 1].size() + 1;
    while (p2 < n && sum + lst[p2].size() + 1 <= c) {
      sum += lst[p2].size() + 1;
      p2++;
    }
    nx[0][i] = p2;
  }
  nx[0][n] = n;
  for (int i = 1; i < LOG; ++i) {
    for (int j = 0; j < n; ++j) {
      if (nx[i - 1][j] == n)
        nx[i][j] = n;
      else
        nx[i][j] = nx[i - 1][nx[i - 1][j]];
    }
    nx[i][n] = n;
  }
  int start = -1;
  int best = -1;
  for (int i = 0; i < n; ++i) {
    int tmp = r;
    int cur = i;
    for (int j = LOG - 1; j >= 0; --j) {
      if (tmp & (1 << j)) {
        cur = nx[j][cur];
      }
    }
    if (best < cur - i) {
      best = cur - i;
      start = i;
    }
  }
  while (r--) {
    for (int i = start; i < nx[0][start]; ++i) {
      if (i != start) cout << " ";
      cout << lst[i];
    }
    start = nx[0][start];
    cout << endl;
  }
}
