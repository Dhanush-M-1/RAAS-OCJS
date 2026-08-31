#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c, m = 0, x, arr[1001];
  cin >> n >> c;
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
  }
  for (int i = 1; i < n; i++) {
    if (arr[i - 1] - arr[i] - c > m) m = arr[i - 1] - arr[i] - c;
  }
  cout << m;
  return 0;
}
