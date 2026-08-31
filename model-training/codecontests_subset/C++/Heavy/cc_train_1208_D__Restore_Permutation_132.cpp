#include <bits/stdc++.h>
using namespace std;
struct BIT {
  int size;
  vector<long long> bit;
  BIT() { size = 0; }
  BIT(int s) {
    size = s;
    bit.resize(size + 1);
    init();
  }
  void init() {
    for (int i = 1; i <= size; i++) bit[i] = 0;
  }
  long long query(long long i) {
    long long ret = 0;
    while (i > 0) {
      ret += bit[i];
      i -= i & (-i);
    }
    return ret;
  }
  void add(long long i, long long x) {
    while (i <= size) {
      bit[i] += x;
      i += i & (-i);
    }
  }
};
long long n;
long long s[200005];
long long ans[200005];
BIT bit(200005);
int main(void) {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cin >> n;
  for (int i = 1; i <= n; i++) cin >> s[i];
  for (int i = 1; i <= n; i++) bit.add(i, i);
  for (int i = n; i >= 1; i--) {
    long long ub = n, lb = 0, mid;
    while (ub - lb > 1) {
      mid = (ub + lb) / 2;
      if (bit.query(mid) <= s[i])
        lb = mid;
      else
        ub = mid;
    }
    ans[i] = ub;
    bit.add(ub, -ub);
  }
  for (int i = 1; i <= n; i++) cout << ans[i] << " ";
  cout << endl;
  return 0;
}
