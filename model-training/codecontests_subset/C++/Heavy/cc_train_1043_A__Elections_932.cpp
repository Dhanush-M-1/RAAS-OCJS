#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int A[n];
  int m = 0, sum = 0;
  for (int i = 0; i < n; i++) {
    cin >> A[i];
    sum += A[i];
    m = max(A[i], m);
  }
  int sum2 = 0;
  for (int i = 0; i < n; i++) {
    sum2 += (m - A[i]);
  }
  if (sum2 > sum) {
    cout << m << "\n";
  } else {
    if (sum2 == sum) {
      cout << m + 1;
      return 0;
    }
    int k = sum - sum2;
    int nu = k / n == 0 ? k / n : k / n + 1;
    int sum3 = 0;
    for (int i = 0; i < n; i++) {
      sum3 += (nu + m - A[i]);
    }
    if (sum3 > sum)
      cout << nu + m;
    else {
      cout << nu + m + 1;
    }
  }
  return 0;
}
