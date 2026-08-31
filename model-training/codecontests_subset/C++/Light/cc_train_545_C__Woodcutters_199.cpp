#include <bits/stdc++.h>
using namespace std;
int n, a[100002], b[100002], ret = 2;
int main() {
  cin >> n;
  cin >> a[0] >> b[0];
  for (int i = 1; i < n; i++) cin >> a[i] >> b[i];
  for (int i = 1; i < n - 1; i++) {
    if (a[i] - b[i] > a[i - 1])
      ret++;
    else {
      if (a[i] + b[i] < a[i + 1]) {
        ret++;
        a[i] = a[i] + b[i];
      }
    }
  }
  if (n == 1) ret--;
  cout << ret;
}
