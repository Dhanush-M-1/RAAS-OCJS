#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 10;
struct node {
  int t, a, b;
} ke[maxn], le[maxn], m[maxn];
int n, k;
bool cmp(node x, node y) { return x.t < y.t; }
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cin >> n >> k;
  int cnt1 = 0, cnt2 = 0, cnt0 = 0;
  for (int i = 0; i < n; i++) {
    node x;
    cin >> x.t >> x.a >> x.b;
    if (x.a && x.b) {
      m[cnt0] = x;
      cnt0++;
    } else if (x.a) {
      ke[cnt1] = x;
      cnt1++;
    } else if (x.b) {
      le[cnt2] = x;
      cnt2++;
    }
  }
  if (cnt1 + cnt0 < k || cnt2 + cnt0 < k) {
    cout << -1 << '\n';
    return 0;
  }
  sort(ke, ke + cnt1, cmp);
  sort(le, le + cnt2, cmp);
  sort(m, m + cnt0, cmp);
  int o1 = 0, o0 = 0;
  long long ans = 0;
  while (o1 + o0 < k) {
    if (o0 >= cnt0) {
      ans += ke[o1].t + le[o1].t;
      o1++;
    } else if (o1 < min(cnt1, cnt2) && m[o0].t > ke[o1].t + le[o1].t) {
      ans += ke[o1].t + le[o1].t;
      o1++;
    } else {
      ans += m[o0].t;
      o0++;
    }
  }
  cout << ans << '\n';
}
