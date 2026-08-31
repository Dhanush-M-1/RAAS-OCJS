#include <bits/stdc++.h>
using namespace std;
const int MAXN = 5e5;
void update(long long in, long long x, vector<long long> &sum, long long c) {
  x = min(sum[in] + x, c) - sum[in];
  while (in != 0) {
    sum[in] += x;
    in /= 2;
  }
}
long long get_sum(long long l, long long r, vector<long long> &sum) {
  if (r < l) {
    return 0;
  }
  if (l == r) {
    return sum[l];
  }
  if (l % 2 == 1) {
    if (r % 2 == 0) {
      return get_sum(l + 1, r - 1, sum) + sum[l] + sum[r];
    } else {
      return get_sum(l + 1, r, sum) + sum[l];
    }
  } else if (r % 2 == 0) {
    return get_sum(l, r - 1, sum) + sum[r];
  } else {
    return get_sum(l / 2, r / 2, sum);
  }
}
vector<long long> sum1(MAXN);
vector<long long> sum2(MAXN);
int main() {
  ios_base::sync_with_stdio(0);
  long long n, k, a, b, q;
  cin >> n >> k >> a >> b >> q;
  long long cur = 1;
  while (cur < n) {
    cur *= 2;
  }
  n = cur;
  for (int i = 0; i < q; ++i) {
    int ind;
    cin >> ind;
    if (ind == 1) {
      long long c, d;
      cin >> d >> c;
      d += n - 1;
      update(d, c, sum1, b);
      update(d, c, sum2, a);
    } else {
      long long l;
      cin >> l;
      --l;
      long long r = l + k;
      l += n, r += n;
      cout << get_sum(n, l - 1, sum1) + get_sum(r, n * 2 - 1, sum2) << endl;
    }
  }
  return 0;
}
