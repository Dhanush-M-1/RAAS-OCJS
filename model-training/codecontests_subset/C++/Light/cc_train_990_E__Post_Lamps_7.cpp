#include <bits/stdc++.h>
using namespace std;
const int MAXN = 1e+6 + 50;
const long long INF = 1e+18;
int n, m, k;
int len[MAXN];
int broken[MAXN];
long long lamp[MAXN];
int main(int argc, char *argv[]) {
  while (cin >> n >> m >> k) {
    memset(len, 0, sizeof(len));
    memset(broken, 0, sizeof(broken));
    for (int i = 1; i <= m; i++) {
      int num;
      cin >> num;
      broken[num] = 1;
    }
    for (int i = 1; i <= k; i++) {
      cin >> lamp[i];
    }
    if (broken[0] == 1) {
      cout << "-1" << endl;
      continue;
    }
    int cnt = 0;
    for (int i = 0; i <= n; i++) {
      if (broken[i] == 0) {
        len[i] = 0;
      } else {
        len[i] = len[i - 1] + 1;
      }
      cnt = max(cnt, len[i]);
    }
    long long ans = INF;
    for (int i = cnt + 1; i <= k; i++) {
      long long count = 0;
      for (int s = 0; s < n; s += i) {
        if (broken[s] == 1) {
          s -= len[s];
        }
        count++;
      }
      ans = min(ans, count * lamp[i]);
    }
    if (ans >= INF) {
      cout << "-1" << endl;
    } else
      cout << ans << endl;
  }
  return 0;
}
