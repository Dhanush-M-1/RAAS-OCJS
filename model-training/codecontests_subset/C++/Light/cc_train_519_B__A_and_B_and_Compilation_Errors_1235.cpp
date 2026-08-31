#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  long long n, sum1, sum2, sum3;
  sum1 = sum2 = sum3 = 0;
  cin >> n;
  long long arr1[n], arr2[n], arr3[n];
  for (int i = 0; i < n; i++) {
    cin >> arr1[i];
    sum1 += arr1[i];
  }
  for (int j = 0; j < n - 1; j++) {
    cin >> arr2[j];
    sum2 += arr2[j];
  }
  for (int k = 0; k < n - 2; k++) {
    cin >> arr3[k];
    sum3 += arr3[k];
  }
  cout << abs(sum1 - sum2) << '\n';
  cout << abs(sum2 - sum3) << '\n';
  return 0;
}
