#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n, sum = 0;
  cin >> n;
  long long a[n];
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    sum += a[i];
  }
  sort(a, a + n);
  for (int i = a[n - 1];; i++) {
    if (n * i - sum > sum) {
      cout << i;
      break;
    }
  }
  return 0;
}
