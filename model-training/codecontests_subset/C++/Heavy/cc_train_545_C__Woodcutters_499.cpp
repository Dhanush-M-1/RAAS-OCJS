#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n;
  cin >> n;
  long long a[n], b[n];
  for (int i = 0; i < n; i++) cin >> a[i] >> b[i];
  long long stop = a[0];
  int ans = 2;
  if (n == 1) {
    cout << "1";
    return 0;
  }
  for (int i = 1; i < n - 1; i++) {
    int y = a[i];
    if (y - b[i] > stop) {
      ans++;
      stop = a[i];
    } else if (y + b[i] < a[i + 1]) {
      stop = a[i] + y;
      ans++;
    } else
      stop = a[i];
  }
  int ans1 = 2;
  int stop1 = a[n - 1];
  for (int i = n - 2; i >= 1; i--) {
    int y = a[i];
    if (y + b[i] < stop1) {
      ++ans1;
      stop1 = a[i];
    } else if (y - b[i] > a[i - 1]) {
      stop1 = y - b[i];
      ++ans1;
    } else
      stop1 = a[i];
  }
  cout << max(ans, ans1) << endl;
}
