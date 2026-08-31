#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 7;
int a[maxn];
class BIT {
 public:
  long long a[maxn];
  void add(int x, long long c) {
    for (int i = x; i < maxn; i += i & -i) a[i] += c;
  }
  long long sum(int x) {
    long long res = 0;
    for (int i = x; i > 0; i -= i & -i) res += a[i];
    return res;
  }
} b1, b2;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int n, x;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> x;
    a[x] = i;
  }
  long long inv = 0;
  for (int i = 1; i <= n; i++) {
    b1.add(a[i], 1);
    inv += i - b1.sum(a[i]);
    b2.add(a[i], a[i]);
    x = i / 2 + 1;
    long long res = b2.sum(n);
    int l = 1, r = n;
    while (l < r) {
      int mid = (l + r) >> 1;
      if (b1.sum(mid) >= x)
        r = mid;
      else
        l = mid + 1;
    }
    long long pos = l;
    long long s = b2.sum(pos);
    long long lans = pos * (pos + 1) / 2 - s - (pos - x) * (pos - x + 1) / 2;
    long long rans = res - s - (i - x) * (pos + 1 + i - x + pos) / 2;
    cout << lans + rans + inv << ' ';
  }
  cout << endl;
  return 0;
}
