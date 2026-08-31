#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  long arr[n], arr1[n], height[n];
  cin >> arr[0] >> height[0];
  arr1[0] = arr[0];
  for (int i = 1; i < n; i++) {
    cin >> arr[i] >> height[i];
    arr1[i] = arr[i] - arr[i - 1];
  }
  if (n == 1)
    cout << 1 << endl;
  else {
    int sum = 0;
    for (int i = 1; i < n - 1; i++) {
      if (height[i] < arr1[i]) {
        arr1[i] = arr1[i] - height[i];
        sum++;
      } else if (height[i] < arr1[i + 1]) {
        arr1[i + 1] = arr1[i + 1] - height[i];
        sum++;
      } else
        continue;
    }
    cout << sum + 2 << endl;
  }
}
