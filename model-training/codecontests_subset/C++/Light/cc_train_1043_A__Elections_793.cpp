#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int x[n], sum = 0, k = -1;
  for (int i = 0; i < n; i++) {
    cin >> x[i];
    sum += x[i];
    if (x[i] > k) k = x[i];
  }
  int sum2 = 0, var;
  for (int i = 0; i < n; i++) {
    sum2 += (k - x[i]);
  }
  while (sum2 <= sum) {
    k++;
    sum2 = 0;
    for (int i = 0; i < n; i++) {
      sum2 += (k - x[i]);
    }
  }
  cout << k;
  return 0;
}
