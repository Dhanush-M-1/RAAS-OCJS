#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c, arr[105], maxx = 0;
  cin >> n >> c;
  for (int i = 0; i < n; i++) cin >> arr[i];
  for (int i = 0; i < n - 1; i++) {
    if (arr[i] - arr[i + 1] > maxx) maxx = arr[i] - arr[i + 1];
  }
  if (maxx - c > 0)
    cout << maxx - c;
  else
    cout << "0";
  return 0;
}
