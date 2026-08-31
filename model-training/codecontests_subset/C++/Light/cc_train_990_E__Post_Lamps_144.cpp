#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:256000000")
using namespace std;
const long long MOD = (int)1e9 + 7;
const long long MOR = (int)1e9 + 31;
const long long INF = (long long)1e15 + 100;
const int dx[] = {0, 1, 0, -1};
const int dy[] = {1, 0, -1, 0};
const int MAXN = (int)1e6 + 5;
const double pi = 3.14159265358979323846;
const int SZ = 1;
int n, m, k, pr[MAXN], c[MAXN], pos[MAXN];
bool us[MAXN];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> m >> k;
  for (int i = 0; i < m; i++) {
    int x;
    cin >> x;
    us[x] = 1;
  }
  for (int i = 1; i <= k; i++) cin >> c[i];
  if (us[0]) {
    cout << -1;
    return 0;
  }
  int p = 0, len = 0;
  for (int i = 0; i <= n; i++) {
    len = max(i - p, len);
    if (!us[i])
      p = i;
    else
      pr[i] = p;
  }
  if (len > k) {
    cout << -1;
    return 0;
  }
  long long ans = INF;
  for (int i = len; i <= k; i++) {
    long long cnt = 0;
    for (int j = 0; j <= n;) {
      cnt++;
      if (j + i >= n) break;
      if (us[j + i])
        j = pr[j + i];
      else
        j = j + i;
    }
    ans = min(ans, cnt * (long long)c[i]);
  }
  cout << ans;
}
