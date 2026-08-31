#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c;
  cin >> n >> c;
  int ar[n], arr[n - 1];
  for (int i = 0; i < n; i++) {
    cin >> ar[i];
  }
  for (int i = 0; i < n - 1; i++) {
    arr[i] = ar[i] - ar[i + 1] - c;
  }
  int *max;
  max = max_element(arr, arr + (n - 1));
  if ((*max) > 0) {
    cout << *max;
  } else {
    cout << 0;
  }
  return 0;
}
