#include <bits/stdc++.h>
using namespace std;
int n;
long long a[300000], b[300000], C[300000];
int lowbit(int x) { return x & (-x); }
long long getSum(int x) {
  long long sum = 0;
  for (int i = x; i > 0; i -= lowbit(i)) sum += C[i];
  return sum;
}
void add(int x, int val) {
  for (int i = x; i < n; i += lowbit(i)) C[i] += val;
}
int main() {
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
    add(i, i);
  }
  for (int i = n; i >= 1; i--) {
    int l = 1, r = n;
    int mid;
    while (l < r) {
      mid = (l + r) / 2;
      if (getSum(mid) > a[i])
        r = mid;
      else
        l = mid + 1;
    }
    b[i] = r;
    add(r, -r);
  }
  for (int i = 1; i <= n; i++) {
    cout << b[i] << " ";
  }
}
