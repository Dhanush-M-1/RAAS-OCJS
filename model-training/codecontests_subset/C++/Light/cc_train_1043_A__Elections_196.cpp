#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int a[n];
  int sum = 0, max = 0;
  for (int i = 0; i < n; i++) cin >> a[i];
  for (int i = 0; i < n; i++) {
    sum = sum + a[i];
    if (a[i] > max) max = a[i];
  }
  while (true) {
    int s = 0;
    for (int i = 0; i < n; i++) {
      s = s - a[i] + max;
    }
    if (s > sum) {
      cout << max << endl;
      break;
    } else
      max++;
  }
  return 0;
}
