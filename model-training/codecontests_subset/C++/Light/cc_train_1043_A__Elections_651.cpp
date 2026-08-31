#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int sum = 0;
  int max = INT_MIN;
  int a[n];
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    sum += a[i];
    if (a[i] > max) max = a[i];
  }
  while (1) {
    int sum1 = 0;
    for (int i = 0; i < n; i++) {
      sum1 += (max - a[i]);
    }
    if (sum1 > sum) {
      cout << max;
      break;
    }
    max++;
  }
}
