#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a = 1, b = 1000000, max = 0, temp;
  cin >> n;
  int arr[n];
  for (int i = 0; i < n; i++) cin >> arr[i];
  for (int i = 0; i < n; i++) {
    if (arr[i] <= (b / 2))
      temp = arr[i] - a;
    else
      temp = b - arr[i];
    if (temp > max) max = temp;
  }
  cout << max << endl;
  return 0;
}
