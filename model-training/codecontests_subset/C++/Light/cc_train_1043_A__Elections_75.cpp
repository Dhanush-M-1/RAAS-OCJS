#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i;
  cin >> n;
  int arr[n], tot = 0, mx = 0;
  for (i = 0; i < n; i++) {
    cin >> arr[i];
    tot += arr[i];
    mx = max(mx, arr[i]);
  }
  mx--;
  int tot2 = 0;
  while (tot2 <= tot) {
    mx++;
    tot2 = 0;
    for (i = 0; i < n; i++) {
      tot2 += mx - arr[i];
    }
  }
  cout << mx << endl;
}
