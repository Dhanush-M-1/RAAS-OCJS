#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n, a, sum, res;
  sum = res = 0;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> a;
    sum += a;
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> a;
    res += a;
  }
  cout << sum - res << endl;
  sum = 0;
  for (int i = 0; i < n - 2; i++) {
    cin >> a;
    sum += a;
  }
  cout << res - sum << endl;
}
