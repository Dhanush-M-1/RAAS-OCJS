#include <bits/stdc++.h>
using namespace std;
const int N = 1e6 + 5;
long long pos[N], s1[N], s2[N];
int a[N];
int n;
void add(long long s[], int pos, long long v) {
  while (pos <= n) {
    s[pos] += v;
    pos += pos & (-pos);
  }
}
long long query(long long s[], int pos) {
  long long res = 0;
  while (pos) {
    res += s[pos];
    pos -= pos & (-pos);
  }
  return res;
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &a[i]);
    pos[a[i]] = i;
  }
  long long ans = 0;
  for (int i = 1; i <= n; i++) {
    ans += i - 1 - query(s1, pos[i]);
    add(s1, pos[i], 1);
    add(s2, pos[i], pos[i]);
    int l = 1, r = n, mid;
    while (l <= r) {
      mid = (l + r) >> 1;
      if (query(s1, mid) * 2 <= i)
        l = mid + 1;
      else
        r = mid - 1;
    }
    long long ans2 = 0;
    long long cnt = query(s1, mid), sum = query(s2, mid);
    ans2 += mid * cnt - sum - cnt * (cnt - 1) / 2;
    cnt = i - cnt;
    sum = query(s2, n) - sum;
    ans2 += sum - cnt * (mid + 1) - cnt * (cnt - 1) / 2;
    printf("%lld ", ans + ans2);
  }
  return 0;
}
