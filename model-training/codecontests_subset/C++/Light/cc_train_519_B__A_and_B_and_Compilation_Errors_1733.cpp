#include <bits/stdc++.h>
using namespace std;
const double epsilon = 1e-7;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n;
  cin >> n;
  int err;
  long long sum1 = 0, sum2 = 0, sum3 = 0;
  for (int i = 0; i < n; i++) {
    cin >> err;
    sum1 += err;
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> err;
    sum2 += err;
  }
  for (int i = 0; i < n - 2; i++) {
    cin >> err;
    sum3 += err;
  }
  cout << sum1 - sum2 << endl;
  cout << sum2 - sum3 << endl;
  return 0;
}
