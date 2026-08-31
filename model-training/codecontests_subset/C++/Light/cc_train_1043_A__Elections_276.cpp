#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, temp, sum = 0;
  cin >> n;
  int arr[n];
  memset(arr, 0, sizeof(arr));
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
    sum += arr[i];
    if (i == 0)
      temp = arr[0];
    else if (arr[i] > temp)
      temp = arr[i];
  }
  while (((temp * n) - sum) <= sum) {
    temp++;
  }
  cout << temp;
}
