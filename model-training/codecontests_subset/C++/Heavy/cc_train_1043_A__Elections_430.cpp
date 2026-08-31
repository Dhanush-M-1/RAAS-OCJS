#include <bits/stdc++.h>
using namespace std;
long long int Lpow(long long int a, long long int b) {
  long long int ans = 1;
  while (b > 0) {
    if (b % 2) ans = (ans * a);
    a = (a * a);
    b = b / 2;
  }
  return ans;
}
long long int gcd(long long int a, long long int b) {
  if (a % b == 0)
    return b;
  else
    return gcd(b, a % b);
}
signed main() {
  ios_base::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL);
  int n;
  cin >> n;
  vector<int> arr(n);
  int ma = 0;
  int x;
  int sum = 0;
  for (int i = 0; i < n; i++) {
    cin >> x;
    sum += x;
    ma = max(ma, x);
  }
  int l = ma;
  int r = 250;
  while (l < r) {
    int mid = (l + r) / 2;
    int now = mid * n - sum;
    if (now > sum)
      r = mid;
    else
      l = mid + 1;
  }
  cout << l << '\n';
  return 0;
}
