#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 5;
struct FTDown {
  long long ft[N + 5];
  FTDown() {
    for (int i = 1; i <= N; i++) ft[i] = 0;
  }
  void update(int p, long long v) {
    for (; p <= N; p += (p & -p)) ft[p] += v;
  }
  long long get(int p) {
    long long sum = 0;
    for (; p; p -= (p & -p)) sum += ft[p];
    return sum;
  }
};
int n, b[N];
pair<int, int> a[N];
FTDown sumXDown, cntDown;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin >> n;
  for (int i = 1; i <= n; i++) cin >> a[i].first;
  for (int i = 1; i <= n; i++) {
    cin >> a[i].second;
    b[i] = a[i].second;
  }
  b[n + 1] = 0;
  sort(b + 1, b + n + 2);
  int m = 1;
  for (int i = 2; i <= n + 1; i++)
    if (b[i] != b[m]) b[++m] = b[i];
  for (int i = 1; i <= n; i++)
    a[i].second = lower_bound(b + 1, b + m + 1, a[i].second) - b;
  sort(a + 1, a + n + 1);
  int ind0 = lower_bound(b + 1, b + m + 1, 0) - b;
  long long ans = 0;
  for (int i = 1; i <= n; i++) {
    long long cnt = cntDown.get(a[i].second);
    long long sumX = sumXDown.get(a[i].second);
    ans += cnt * a[i].first - sumX;
    cntDown.update(a[i].second, 1);
    sumXDown.update(a[i].second, a[i].first);
  }
  cout << ans;
  return 0;
}
