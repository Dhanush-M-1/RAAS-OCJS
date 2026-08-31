#include <bits/stdc++.h>
using namespace std;
long long Min(long long i, long long j) { return i < j ? i : j; }
long long Max(long long i, long long j) { return i > j ? i : j; }
long long w[5005], b[5005];
int main() {
  long long a, i, j, k, l, m, n;
  vector<long long> cur;
  while (cin >> n >> m) {
    for (i = 1; i <= n; i++) cin >> w[i];
    for (i = 1; i <= m; i++) cin >> b[i];
    a = 0;
    cur.clear();
    for (i = 1; i <= m; i++) {
      bool bb = true;
      for (j = 0; j < cur.size(); j++) {
        if (cur[j] == b[i]) {
          bb = false;
          break;
        }
        a += w[cur[j]];
      }
      for (++j; j < cur.size(); j++) {
        cur[j - 1] = cur[j];
        bb = false;
      }
      if (cur.size() && !bb) cur.pop_back();
      cur.push_back(0);
      for (j = ((long long)cur.size()) - 2; j >= 0; j--) cur[j + 1] = cur[j];
      cur[0] = b[i];
    }
    cout << a << endl;
  }
  return 0;
}
