#include <bits/stdc++.h>
using namespace std;
const long long MOD = 1e9 + 7;
const long double pi = 3.14159265358979323846264338327950288;
int second[1000001], near[1000001];
int main() {
  int n, k, m;
  cin >> n >> m >> k;
  int a[k];
  for (int i = 0; i < m; i++) {
    int tmp;
    scanf("%d", &tmp);
    second[tmp] = 1;
  }
  for (int i = 0; i < k; i++) scanf("%d", &a[i]);
  int cnt = 0, mx = 0;
  for (int i = 0; i < n; i++) {
    if (second[i] == 1)
      cnt++, near[i] = near[i - 1];
    else
      cnt = 0, near[i] = i;
    mx = max(mx, cnt);
  }
  if (mx >= k || second[0] == 1) {
    cout << -1 << endl;
  } else {
    long long ans = 1e18;
    for (int i = mx + 1; i <= k; i++) {
      long long tmp = 0;
      for (int j = 0; j < n; j += i) {
        int cmt = 0;
        if (near[j] <= j - i) {
          tmp = 1e18;
          break;
        }
        j = near[j];
        tmp += (long long)a[i - 1];
      }
      ans = min(tmp, ans);
    }
    if (ans == 1e18)
      cout << -1 << endl;
    else
      cout << ans << endl;
  }
}
