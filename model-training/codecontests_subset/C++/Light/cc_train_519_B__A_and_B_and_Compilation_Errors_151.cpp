#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  long int ar1[n], ar2[n], ar3[n], i, j, k;
  long long sum1 = 0, sum2 = 0, sum3 = 0;
  for (i = 0; i < n; i++) {
    cin >> ar1[i];
    sum1 = sum1 + ar1[i];
  }
  for (i = 0; i < n - 1; i++) {
    cin >> ar2[i];
    sum2 = sum2 + ar2[i];
  }
  for (i = 0; i < n - 2; i++) {
    cin >> ar3[i];
    sum3 = sum3 + ar3[i];
  }
  cout << sum1 - sum2 << "\n" << sum2 - sum3;
}
