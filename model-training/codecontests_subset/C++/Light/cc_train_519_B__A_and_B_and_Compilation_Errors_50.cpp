#include <bits/stdc++.h>
using namespace std;
int main() {
  int sum = 0, sum1 = 0, sum2 = 0, a, b, n, i;
  cin >> n;
  for (i = 0; i < n; i++) {
    cin >> a;
    sum += a;
  }
  for (i = 0; i < n - 1; i++) {
    cin >> a;
    sum1 += a;
  }
  for (i = 0; i < n - 2; i++) {
    cin >> a;
    sum2 += a;
  }
  cout << sum - sum1 << endl << sum1 - sum2;
}
