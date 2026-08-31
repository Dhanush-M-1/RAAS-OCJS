#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i, sum = 0, sum1 = 0, sum2 = 0;
  cin >> n;
  int arr[n];
  int brr[n - 1];
  int crr[n - 2];
  for (i = 0; i < n; i++) {
    cin >> arr[i];
    sum += arr[i];
  }
  for (i = 0; i < n - 1; i++) {
    cin >> brr[i];
    sum1 += brr[i];
  }
  for (i = 0; i < n - 2; i++) {
    cin >> crr[i];
    sum2 += crr[i];
  }
  cout << sum - sum1 << endl;
  cout << sum1 - sum2 << endl;
}
