#include <bits/stdc++.h>
using namespace std;
void solve() {}
const long long maxn = 200500;
long long N, K, A, B, Q;
long long cnt[maxn];
long long bita[maxn], bitb[maxn];
void upd(long long arr[], long long ind, long long val) {
  for (long long i = ind; i <= N; i += (i & (-i))) {
    arr[i] += val;
  }
}
long long query(long long arr[], long long l, long long r) {
  long long x = 0;
  for (long long i = l - 1; i >= 1; i -= (i & (-i))) {
    x += arr[i];
  }
  long long y = 0;
  for (long long i = r; i >= 1; i -= (i & (-i))) {
    y += arr[i];
  }
  return y - x;
}
signed main() {
  ios::sync_with_stdio(0);
  cin.sync_with_stdio(0);
  cin.tie(0);
  cin >> N >> K >> A >> B >> Q;
  while (Q--) {
    long long t;
    cin >> t;
    if (t == 1) {
      long long d, a;
      cin >> d >> a;
      long long cpy = cnt[d];
      cnt[d] += a;
      upd(bita, d, min(A, cnt[d]) - min(A, cpy));
      upd(bitb, d, min(B, cnt[d]) - min(B, cpy));
      for (long long i = 1; i <= N; i++) {
        if (false) cerr << cnt[i] << " ";
      }
      if (false) cerr << '\n';
    } else if (t == 2) {
      long long p;
      cin >> p;
      long long ans = query(bitb, 1, p - 1) + query(bita, p + K, N);
      cout << ans << '\n';
    }
  }
}
