#include <bits/stdc++.h>
using namespace std;
int main() {
  long n, c;
  long i;
  cin >> n >> c;
  long a[n];
  for (i = 0; i < n; i++) {
    cin >> a[i];
  }
  int max = 0;
  for (i = 0; i < n - 1; i++) {
    int t = a[i] - a[i + 1] - c;
    if (t > max) {
      max = t;
    }
  }
  cout << max;
  return 0;
}
