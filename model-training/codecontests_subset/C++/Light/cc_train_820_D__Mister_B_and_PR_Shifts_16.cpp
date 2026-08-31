#include <bits/stdc++.h>
using namespace std;
int a[2000005];
int n;
int tp[1000005];
long long ans = 0;
int x = 0;
int neg = 0, pos = 0;
vector<int> modify[2000005];
void solve() {
  for (int i = 1; i <= n; i++) {
    neg += a[i] - i < 0;
    pos += a[i] - i >= 0;
    ans += abs(a[i] - i);
    if (a[i] < i) modify[i - a[i]].push_back(i);
  }
  long long cnt = ans;
  for (int i = 1; i < n; i++) {
    int l = i + 1, r = i + n;
    cnt -= a[i] - 1, cnt += abs(a[r] - n);
    pos--;
    cnt += pos - neg;
    neg += a[r] - n < 0, pos += a[r] - n >= 0;
    for (vector<int>::iterator j = modify[i].begin(); j != modify[i].end();
         ++j) {
      if (*j <= i) continue;
      pos++, neg--;
    }
    if (a[r] < n) modify[n - a[r] + i].push_back(r);
    if (cnt < ans) ans = cnt, x = n - i;
  }
  cout << ans << " " << x << endl;
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) scanf("%d", &a[i]);
  for (int i = 1; i <= n; i++) a[i + n] = a[i];
  solve();
  return 0;
}
