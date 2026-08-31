#include <bits/stdc++.h>
using namespace std;
int a[100000];
int b[100000];
int main() {
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> a[i] >> b[i];
  }
  if (n <= 2) {
    cout << n << endl;
    return 0;
  }
  int cnt = 2;
  for (int i = 1; i < n - 1; i++) {
    if (a[i - 1] < a[i] - b[i]) {
      cnt++;
    } else if (a[i + 1] > a[i] + b[i]) {
      cnt++;
      a[i] = a[i] + b[i];
    }
  }
  cout << cnt << endl;
  return 0;
}
