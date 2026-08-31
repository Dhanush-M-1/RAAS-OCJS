#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, sum = 0;
  cin >> n;
  int A[n], B[2] = {0};
  for (int i = 0; i < n; i++) {
    cin >> A[i];
    sum += A[i];
    if (A[i] == 100) {
      B[0]++;
    } else {
      B[1]++;
    }
  }
  if (n == 1) {
    cout << "NO\n";
    return 0;
  }
  if (sum % 200 == 0) {
    if (B[0] == 0 && n % 2 != 0) {
      cout << "NO\n";
    } else {
      cout << "YES\n";
    }
  } else {
    cout << "NO\n";
  }
  return 0;
}
