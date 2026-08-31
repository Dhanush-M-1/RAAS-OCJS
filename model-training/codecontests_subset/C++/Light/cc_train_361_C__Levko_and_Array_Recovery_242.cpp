#include <bits/stdc++.h>
using namespace std;
const int MAXN = 5023;
const int MAXM = 5023;
const long long INF = 1e9 + 1e4 * MAXN;
long long diff[MAXM][MAXN], max_a[MAXN];
struct command {
  int type, left, right, third;
} command[MAXN];
int main() {
  int n, m;
  cin >> n >> m;
  memset(diff, 0, sizeof(diff));
  fill_n(max_a, n, -INF);
  for (int i = 0; i < m; ++i) {
    int t, l, r, p;
    cin >> t >> l >> r >> p;
    command[i].type = t;
    command[i].left = --l;
    command[i].right = --r;
    command[i].third = p;
    if (i != 0) {
      copy(diff[i - 1], diff[i - 1] + n, diff[i]);
    }
    if (t == 1) {
      for (int j = l; j <= r; ++j) {
        diff[i][j] += p;
      }
    } else {
      for (int j = l; j <= r; ++j) {
        max_a[j] =
            max_a[j] == -INF ? p - diff[i][j] : min(max_a[j], p - diff[i][j]);
      }
    }
  }
  for (int i = 0; i < m; ++i) {
    int l = command[i].left;
    int r = command[i].right;
    if (command[i].type == 1) {
      continue;
    }
    long long mm = max_a[l] + diff[i][l];
    for (int j = l; j <= r; ++j) {
      mm = max(mm, max_a[j] + diff[i][j]);
    }
    if (mm != command[i].third) {
      cout << "NO";
      return 0;
    }
  }
  cout << "YES" << endl;
  for (int i = 0; i < n; ++i) {
    cout << max(max_a[i], (long long)-1e9) << ' ';
  }
  return 0;
}
