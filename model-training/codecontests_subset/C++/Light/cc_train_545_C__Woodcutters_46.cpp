#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  long long int a[n];
  long long int b[n];
  for (int i = 0; i < n; i++) {
    cin >> a[i] >> b[i];
  }
  long long int count = 0;
  if (n >= 2) {
    count = 2;
  } else if (n == 1) {
    count = 1;
  }
  for (int i = 1; i < n - 1; i++) {
    if (a[i] - b[i] > a[i - 1]) {
      count++;
    } else if (a[i] + b[i] < a[i + 1]) {
      count++;
      a[i] = a[i] + b[i];
    }
  }
  cout << count << "\n";
}
