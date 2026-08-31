#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int n, i, cnt = 0, sum;
  cin >> n;
  long long int a[n];
  for (i = 0; i < n; i++) {
    cin >> a[i];
    cnt += a[i];
  }
  sort(a, a + n);
  for (i = a[n - 1]; i <= 100000; i++) {
    sum = 0;
    for (long long int j = 0; j < n; j++) {
      sum += (i - a[j]);
    }
    if (sum > cnt) {
      cout << i;
      return 0;
    }
  }
}
