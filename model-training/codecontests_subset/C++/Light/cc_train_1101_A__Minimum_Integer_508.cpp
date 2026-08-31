#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int arr[n];
  for (int i = 0; i < n; i++) {
    long int l, r, d;
    cin >> l >> r >> d;
    if (d < l)
      arr[i] = d;
    else if (d >= l && d <= r) {
      if (r % d != 0)
        arr[i] = (r / d) * d + d;
      else
        arr[i] = r + d;
    } else
      arr[i] = d;
  }
  for (int i = 0; i < n; i++) cout << arr[i] << endl;
  return 0;
}
