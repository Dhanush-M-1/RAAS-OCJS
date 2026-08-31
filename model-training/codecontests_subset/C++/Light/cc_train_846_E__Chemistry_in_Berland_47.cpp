#include <bits/stdc++.h>
using namespace std;
double ans[100005];
long long x[100005], k[100005];
int main() {
  int i, n;
  cin >> i;
  for (n = 1; n <= i; n++) cin >> ans[n];
  for (n = 1; n <= i; n++) {
    long long a;
    cin >> a;
    ans[n] = a - ans[n];
  }
  for (n = 2; n <= i; n++) cin >> x[n] >> k[n];
  for (n = i; n > 1; n--) {
    if (ans[n] > 0)
      ans[x[n]] += k[n] * ans[n];
    else
      ans[x[n]] += ans[n];
  }
  if (ans[1] < 0.5)
    cout << "YES";
  else
    cout << "NO";
  cout << endl;
}
