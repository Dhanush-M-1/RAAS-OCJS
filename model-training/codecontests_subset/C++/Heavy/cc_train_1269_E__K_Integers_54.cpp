#include <bits/stdc++.h>
using namespace std;
const int MAXN = 2e5 + 5;
long long sum1[MAXN], sum2[MAXN], a[MAXN], pos[MAXN];
void add1(long long x, long long y) {
  if (!x) return;
  for (; x < MAXN; x += x & -x) {
    sum1[x] += y;
  }
}
long long query1(long long x) {
  long long ans = 0;
  for (; x; x -= x & -x) {
    ans += sum1[x];
  }
  return ans;
}
void add2(long long x, long long y) {
  if (!x) return;
  for (; x < MAXN; x += x & -x) {
    sum2[x] += y;
  }
}
long long query2(long long x) {
  long long ans = 0;
  for (; x; x -= x & -x) {
    ans += sum2[x];
  }
  return ans;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int n;
  while (cin >> n) {
    memset(sum1, 0, sizeof(sum1));
    memset(sum2, 0, sizeof(sum2));
    long long ans = 0;
    for (int i = 1; i <= n; i++) cin >> a[i], pos[a[i]] = i;
    for (int i = 1; i <= n; i++) {
      int p = pos[i];
      add1(p, 1);
      add2(p, p);
      ans += i - query1(p);
      long long pp = ans;
      long long l = 1, r = n, temp;
      while (l <= r) {
        int mid = (l + r) >> 1;
        if (query1(mid) * 2 > i) {
          temp = mid;
          r = mid - 1;
        } else
          l = mid + 1;
      }
      long long x = query1(temp);
      pp += (temp - x + 1 + temp) * x / 2 - query2(temp);
      x = i - x;
      pp += query2(n) - query2(temp) - ((temp + 1 + temp + x) * x / 2);
      cout << pp << " ";
    }
    cout << endl;
  }
  return 0;
}
