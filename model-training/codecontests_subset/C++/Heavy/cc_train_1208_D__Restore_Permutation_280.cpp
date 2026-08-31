#include <bits/stdc++.h>
using namespace std;
long long a, b, c, d, i, e, f, g, n, m, k, l, A[200005], B[200005], mid, le, ri,
    BITree[4000005], ans, fix[200005];
long long getSum(long long index) {
  long long sum = 0;
  while (index > 0) {
    sum += BITree[index];
    index -= index & (-index);
  }
  return sum;
}
void updateBIT(long long index, long long val) {
  while (index <= 1000005) {
    BITree[index] += val;
    index += index & (-index);
  }
}
int main() {
  cin >> n;
  for (long long i = 1; i <= n; i++) {
    cin >> A[i];
    updateBIT(i, i);
  }
  for (long long i = n; i >= 1; i--) {
    le = 0;
    ri = n;
    while (le <= ri) {
      mid = (le + ri) / 2;
      a = getSum(mid);
      if (a > A[i]) {
        ri = mid - 1;
      } else if (a <= A[i]) {
        ans = mid;
        le = mid + 1;
      }
    }
    updateBIT(ans + 1, -(ans + 1));
    B[i] = ans + 1;
    fix[ans + 1] = 1;
  }
  for (long long i = 1; i <= n; i++) cout << B[i] << " ";
}
