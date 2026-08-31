#include <bits/stdc++.h>

using namespace std;


#define MAXN 100002
typedef long long ll;
ll sum[MAXN];
int r[MAXN], lo[MAXN], hi[MAXN];
int x, k;
void solve(int t, int a) {
  int i = upper_bound(r+1, r+k+2, t) - r - 1;
  int ans = (i%2 ? 1 : -1)*(t-r[i]);
  if (a<=lo[i]-sum[i]) {
    ans += lo[i];
  } else if (a<=hi[i]-sum[i]) {
    ans += sum[i] + a;
  } else {
    ans += hi[i];
  }
  cout << min(max(ans, 0), x) << endl;
}

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cin >> x >> k;
  for (int i = 1; i <= k; ++i) {
    cin >> r[i];
    sum[i] += sum[i-1] + ((i%2) ? -1 : 1)*(r[i]-r[i-1]);
  }
  r[k+1] = 2e9;
  hi[0] = x;
  for (int i = 1; i <= k+1; ++i) {
    if (i%2) {
      lo[i] = max(0, lo[i-1]-r[i]+r[i-1]);
      hi[i] = max(0, hi[i-1]-r[i]+r[i-1]);
    } else {
      lo[i] = min(x, lo[i-1]+r[i]-r[i-1]);
      hi[i] = min(x, hi[i-1]+r[i]-r[i-1]);
    }
  }
  int q;
  cin >> q;
  for (int i = 0; i < q; ++i) {
    int t, a;
    cin >> t >> a;
    solve(t, a);
  }
  return 0;
}
