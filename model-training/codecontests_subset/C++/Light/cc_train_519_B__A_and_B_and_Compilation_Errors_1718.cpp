#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, sum1 = 0, sum2 = 0, x;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> x;
    sum1 = sum1 + x;
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> x;
    sum2 = sum2 + x;
  }
  cout << sum1 - sum2 << endl;
  sum1 = 0;
  for (int i = 0; i < n - 2; i++) {
    cin >> x;
    sum1 = sum1 + x;
  }
  cout << sum2 - sum1;
  return 0;
}
