#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int arr[n];
  int brr[n];
  int max = 0;
  int sum1 = 0;
  int sum2 = 0;
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
    if (arr[i] > max) {
      max = arr[i];
    }
    sum1 += arr[i];
  }
  for (int i = 0; i < n; i++) {
    sum2 += (max - arr[i]);
  }
  while (sum2 <= sum1) {
    max++;
    sum2 += n;
  }
  cout << max;
  return 0;
}
