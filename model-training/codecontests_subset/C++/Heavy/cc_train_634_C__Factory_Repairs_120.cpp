#include <bits/stdc++.h>
using namespace std;
class BIT {
 public:
  int n, lim, bit[1000001];
  BIT(int ninp, int limp) {
    n = ninp;
    lim = limp;
    for (int i = 0; i <= n; i++) bit[i] = 0;
  }
  void increaseBit(int index, int newVal) {
    int sums = getSum(index, index);
    if (newVal + sums > lim) newVal = lim - sums;
    index++;
    while (index <= n) {
      bit[index] += newVal;
      index = index + index - (index & (index - 1));
    }
  }
  void updateBIT(int index, int newVal) {
    increaseBit(index, newVal - bit[index + 1]);
  }
  void constructBIT(int a[]) {
    for (int i = 0; i < n; i++) increaseBit(i, a[i]);
  }
  int getSum(int right) {
    if (right < 0) return 0;
    int sum = 0;
    right++;
    while (right > 0) {
      sum += bit[right];
      right = right & (right - 1);
    }
    return sum;
  }
  int getSum(int left, int right) { return (getSum(right) - getSum(left - 1)); }
};
int main() {
  int i, n, k, a, b, q, t, pos, inc, ans;
  cin >> n >> k >> a >> b >> q;
  BIT abit(n, a), bbit(n, b);
  while (q--) {
    cin >> t;
    if (t == 1) {
      cin >> pos >> inc;
      pos--;
      abit.increaseBit(pos, inc);
      bbit.increaseBit(pos, inc);
    } else {
      cin >> pos;
      pos--, ans = 0;
      if (pos > 0) ans = bbit.getSum(0, pos - 1);
      if (pos + k < n) ans += abit.getSum(pos + k, n - 1);
      cout << ans << endl;
    }
  }
  return 0;
}
