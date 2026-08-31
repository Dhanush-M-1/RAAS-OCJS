#include <bits/stdc++.h>
const int inf = INT_MAX;
const int MAX = 3e6 + 9;
const long long MOD = 1e9 + 7;
const int TOT_PRIMES = 1e6 + 9;
const int MAX_A = 71;
const int LN = 20;
using namespace std;
long long bt[MAX];
long long arr[MAX];
void update(int x, long long val) {
  for (int i = x; i < MAX; i += i & -i) bt[i] += val;
}
long long query(int x) {
  long long res = 0;
  for (int i = x; i > 0; i -= i & -i) res = res + bt[i];
  return res;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(0);
  int n;
  cin >> n;
  for (int i = 1; i <= n; i++) cin >> arr[i];
  for (int i = 1; i <= n; i++) update(i, i);
  int ans[n + 1];
  for (int i = n; i >= 1; i--) {
    int l = 0, r = n;
    while (l <= r) {
      int mid = (l + r) / 2;
      if (query(mid) > arr[i])
        r = mid - 1;
      else
        l = mid + 1;
    }
    ans[i] = l;
    update(l, -l);
  }
  for (int i = 1; i <= n; i++) cout << ans[i] << " ";
}
