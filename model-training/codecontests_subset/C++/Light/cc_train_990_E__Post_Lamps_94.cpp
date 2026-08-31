#include <bits/stdc++.h>
int dr[] = {2, 2, -2, -2, 1, -1, 1, -1};
int dc[] = {1, -1, 1, -1, 2, 2, -2, -2};
int dr1[] = {0, 0, 1, 1, 1, -1, -1, -1};
int dc1[] = {1, -1, 1, 0, -1, 0, 1, -1};
int dr2[] = {0, 0, 1, -1};
int dc2[] = {1, -1, 0, 0};
using namespace std;
long long mark[1000005], a[1000005];
int main() {
  long long n, m, k, i, j, x;
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  while (cin >> n >> m >> k) {
    for (i = 0; i < n; i++) mark[i] = i;
    for (i = 1; i <= m; i++) {
      cin >> x;
      mark[x] = -1;
    }
    for (i = 1; i <= k; i++) cin >> a[i];
    if (mark[0] == -1) {
      cout << "-1" << endl;
      continue;
    }
    for (i = 1; i < n; i++)
      if (mark[i] == -1) mark[i] = mark[i - 1];
    long long min1 = 1000000000005;
    for (i = 1; i <= k; i++) {
      long long x = i;
      long long pos = 0;
      long long s = 0;
      bool f = 0;
      while (pos < n) {
        if (mark[pos] != pos && mark[pos] == pos - x) {
          f = 1;
          break;
        } else if (mark[pos] != pos)
          pos = mark[pos];
        pos += x;
        s += a[i];
      }
      if (f == 0) {
        min1 = min(min1, s);
      }
    }
    if (min1 == 1000000000005) min1 = -1;
    cout << min1 << endl;
  }
}
