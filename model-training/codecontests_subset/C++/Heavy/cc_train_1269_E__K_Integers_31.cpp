#include <bits/stdc++.h>
using namespace std;
const long long maxn = 200000;
long long a[200005], pos[200005];
long long sum1[200005], sum2[200005];
void add(long long *sum1, long long x, long long val) {
  while (x <= maxn) {
    sum1[x] += val;
    x += x & (-x);
  }
}
long long sum(long long *sum1, long long pos) {
  long long res = 0;
  while (pos) {
    res += sum1[pos];
    pos -= pos & (-pos);
  }
  return res;
}
signed main() {
  long long n;
  cin >> n;
  for (long long i = 1; i <= n; i++) {
    cin >> a[i];
    pos[a[i]] = i;
  }
  long long ans1 = 0, ans2 = 0;
  for (long long i = 1; i <= n; i++) {
    ans1 += i - 1 - sum(sum1, pos[i]);
    add(sum1, pos[i], 1);
    add(sum2, pos[i], pos[i]);
    long long l = 1, r = n;
    while (l < r) {
      long long mid = l + r + 1 >> 1;
      if (sum(sum1, mid) * 2 <= i) {
        l = mid;
      } else
        r = mid - 1;
    }
    long long cnt = sum(sum1, l);
    long long sum3 = sum(sum2, l);
    ans2 = 0;
    ans2 += cnt * l - sum3 - cnt * (cnt - 1) / 2;
    cnt = i - cnt;
    sum3 = sum(sum2, n) - sum(sum2, l);
    ans2 += sum3 - cnt * (l + 1) - cnt * (cnt - 1) / 2;
    cout << ans1 + ans2 << " ";
  }
  cout << endl;
}
