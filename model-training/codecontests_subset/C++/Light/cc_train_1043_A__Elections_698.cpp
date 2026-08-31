#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int* arr = new int[n];
  int sum = 0;
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
    sum += arr[i];
  }
  int max = *max_element(arr, arr + n);
  int res = (2 * sum) / n;
  if (res < max) {
    cout << max << endl;
  } else {
    cout << ((2 * sum) / n) + 1 << endl;
  }
  return 0;
}
