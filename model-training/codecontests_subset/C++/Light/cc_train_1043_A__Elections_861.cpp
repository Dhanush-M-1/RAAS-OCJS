#include <bits/stdc++.h>
using namespace std;
int n;
int mx = 0, sum = 0;
int main() {
  cin >> n;
  for (int i = 1; i <= n; ++i) {
    int a;
    cin >> a;
    mx = max(mx, a);
    sum += a;
  }
  sum *= 2;
  sum += n;
  sum /= n;
  cout << max(sum, mx) << endl;
  return 0;
}
