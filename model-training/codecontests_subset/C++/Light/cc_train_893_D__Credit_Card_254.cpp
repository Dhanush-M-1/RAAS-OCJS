#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e5 + 5;
int a[maxn];
int pre[maxn];
int use[maxn];
int main() {
  int n, d;
  cin >> n >> d;
  pre[0] = 0;
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
    pre[i] = pre[i - 1] + a[i];
  }
  use[n] = pre[n];
  for (int i = n - 1; i >= 1; i--) {
    use[i] = max(use[i + 1], pre[i]);
  }
  long long add = 0;
  long long ans = 0;
  int flag = 1;
  for (int i = 1; i <= n; i++) {
    if (a[i] == 0) {
      if (add + pre[i] < 0) {
        add += d - (use[i] + add);
        ans++;
      }
      if (add + pre[i] < 0 && flag) {
        flag = 0;
        cout << "-1" << endl;
      }
    } else {
      if (add + pre[i] > d && flag) {
        flag = 0;
        cout << "-1" << endl;
      }
    }
  }
  if (flag) cout << ans << endl;
  return 0;
}
