#include <bits/stdc++.h>
using namespace std;
int a[100000];
long long n, d;
int main() {
  scanf("%d%d", &n, &d);
  for (int i = 0; i < n; ++i) scanf("%d", a + i);
  long long sum = 0;
  long long k = 0;
  long long ans = 0;
  for (int i = 0; i < n; ++i) {
    sum += a[i];
    if (sum > d) {
      if (sum - k > d) {
        cout << -1;
        return 0;
      }
      k -= sum - d;
      sum = d;
    }
    if (a[i] == 0) {
      if (sum < 0) {
        sum = d;
        k = d;
        ++ans;
      } else
        k = min(k, sum);
    }
  }
  cout << ans << endl;
}
