#include <bits/stdc++.h>
using namespace std;
vector<long long int> xi;
vector<long long int> hi;
int main() {
  long long int n, x, h, ans = 1, temp, temp1, curr, i;
  scanf("%lld", &n);
  for (i = 0; i < n; i++) {
    scanf("%lld %lld", &x, &h);
    xi.push_back(x);
    hi.push_back(h);
  }
  curr = xi[0];
  for (i = 1; i < n; i++) {
    temp = xi[i] - hi[i];
    temp1 = xi[i] + hi[i];
    if (temp > curr) {
      ans++;
      curr = xi[i];
    } else {
      if (i + 1 < n && temp1 < xi[i + 1]) {
        ans++;
        curr = temp1;
      } else {
        if (i + 1 == n) ans++;
        curr = xi[i];
      }
    }
  }
  printf("%lld\n", ans);
  return 0;
}
