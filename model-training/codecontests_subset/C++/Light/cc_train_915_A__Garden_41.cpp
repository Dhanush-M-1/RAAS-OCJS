#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k;
  cin >> n >> k;
  int arr[n];
  int a = k;
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
    if (k % arr[i] == 0) {
      a = min(k / arr[i], a);
    }
  }
  cout << a << endl;
  return 0;
}
