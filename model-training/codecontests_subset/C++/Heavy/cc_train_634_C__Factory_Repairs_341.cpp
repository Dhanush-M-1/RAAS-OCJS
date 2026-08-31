#include <bits/stdc++.h>
using namespace std;
long long int bt1[200011];
long long int bt2[200011];
long long int as[200011];
long long int bs[200011];
int n;
void update(int ind, int val, long long int *bt) {
  while (ind <= n) {
    bt[ind] += val;
    ind += (ind & -ind);
  }
}
long long int query(int ind, long long int *bt) {
  long long int ans = 0;
  while (ind > 0) {
    ans += bt[ind];
    ind -= (ind & -ind);
  }
  return ans;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  ;
  long long int k, a, b, q;
  cin >> n >> k >> b >> a >> q;
  int t, p, d, ai;
  while (q--) {
    cin >> t;
    if (t == 1) {
      cin >> d >> ai;
      update(d, -as[d], bt1);
      as[d] += ai;
      as[d] = min(as[d], a);
      update(d, as[d], bt1);
      update(d, -bs[d], bt2);
      bs[d] += ai;
      bs[d] = min(bs[d], b);
      update(d, bs[d], bt2);
    } else {
      cin >> p;
      long long int ans =
          query(p - 1, bt1) + query(n, bt2) - query(p + k - 1, bt2);
      cout << ans << "\n";
    }
  }
}
