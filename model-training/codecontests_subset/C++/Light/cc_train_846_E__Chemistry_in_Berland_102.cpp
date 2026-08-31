#include <bits/stdc++.h>
using namespace std;
double ans[100001];
long long x[100001], k[100001];
int main() {
  int n, i;
  cin >> n;
  for (i = 1; i <= n; i++) cin >> ans[i];
  for (i = 1; i <= n; i++) {
    long long a;
    cin >> a;
    ans[i] = a - ans[i];
  }
  for (i = 2; i <= n; i++) cin >> x[i] >> k[i];
  for (i = n; i > 1; i--) {
    if (ans[i] > 0)
      ans[x[i]] += k[i] * ans[i];
    else
      ans[x[i]] += ans[i];
  }
  if (ans[1] < 0.5)
    cout << "YES";
  else
    cout << "NO";
}
