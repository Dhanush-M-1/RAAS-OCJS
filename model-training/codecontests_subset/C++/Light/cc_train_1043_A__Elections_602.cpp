#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int arr[n];
  int lar = -1;
  int sum = 0, s = 0;
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
    sum += arr[i];
    if (arr[i] >= lar) lar = arr[i];
  }
  while (1) {
    s = 0;
    for (int i = 0; i < n; i++) {
      s += lar - arr[i];
    }
    if (s > sum) {
      cout << lar;
      break;
    } else
      lar++;
  }
  return 0;
}
