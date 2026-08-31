#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  int sum = 0;
  cin >> n;
  int a[n];
  int b[n];
  for (int i = 0; i < n; i++) {
    cin >> a[i] >> b[i];
  }
  for (int j = 0; j < n; j++) {
    for (int i = j; i < n; i++) {
      if (a[j] == b[i + 1]) {
        sum++;
      }
      if (b[j] == a[i + 1]) {
        sum++;
      }
    }
  }
  cout << sum;
  return 0;
}
