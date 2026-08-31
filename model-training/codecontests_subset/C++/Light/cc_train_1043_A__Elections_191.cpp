#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, sum = 0, max = -1;
  cin >> n;
  int* arr = new int[n];
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
    if (arr[i] > max) max = arr[i];
    sum += arr[i];
  }
  int k = 2 * sum / n + 1;
  if (k < max) k = max;
  cout << k;
  return 0;
}
