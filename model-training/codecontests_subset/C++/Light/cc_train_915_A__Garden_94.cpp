#include <bits/stdc++.h>
using namespace std;
int arr[105];
int main() {
  int n;
  int k;
  cin >> n >> k;
  for (int i = 0; i < n; i++) cin >> arr[i];
  int count = 105;
  int ans;
  for (int i = 0; i < n; i++) {
    if (k % arr[i] == 0) {
      ans = k / arr[i];
    }
    count = min(count, ans);
  }
  cout << count;
  return 0;
}
