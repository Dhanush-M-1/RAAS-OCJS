#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a, i, sum1 = 0, sum2 = 0, sum3 = 0;
  cin >> n;
  for (i = 0; i < n; i++) {
    cin >> a;
    sum1 = sum1 + a;
  }
  for (i = 0; i < n - 1; i++) {
    cin >> a;
    sum2 = sum2 + a;
  }
  for (i = 0; i < n - 2; i++) {
    cin >> a;
    sum3 = sum3 + a;
  }
  cout << sum1 - sum2 << endl;
  cout << sum2 - sum3 << endl;
}
