#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b;
  cin >> a >> b;
  int arr[a];
  cin >> arr[0];
  int ans = 0;
  for (int i = 1; i < a; i++) {
    cin >> arr[i];
    ans = max(arr[i - 1] - arr[i] - b, ans);
  }
  cout << ans << endl;
  return 0;
}
