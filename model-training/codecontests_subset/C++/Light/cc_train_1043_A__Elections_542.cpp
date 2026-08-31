#include <bits/stdc++.h>
using namespace std;
int main() {
  std::ios::sync_with_stdio(false);
  cin.tie(NULL);
  long long int n;
  cin >> n;
  long long int a[n], max1 = 0, sum2 = 0;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    if (max1 < a[i]) max1 = a[i];
    sum2 += a[i];
  }
  while (1) {
    long long int sum = 0;
    for (int i = 0; i < n; i++) {
      sum = sum + max1 - a[i];
    }
    if (sum > sum2)
      break;
    else
      max1++;
  }
  cout << max1 << endl;
  return 0;
}
