#include <bits/stdc++.h>
using namespace std;
void solve() {
  int n;
  cin >> n;
  vector<int> arr(n);
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
  }
  int count200 = 0;
  int count100 = 0;
  for (int i = 0; i < n; i++) {
    if (arr[i] == 100)
      count100++;
    else
      count200++;
  }
  if (count200 == 0) {
    if (count100 % 2 == 0) {
      cout << "YES" << endl;
    } else {
      cout << "NO" << endl;
    }
  } else {
    count200 = count200 % 2;
    if (count100 >= (2 * count200)) {
      if ((count100 - (2 * count200)) % 2 == 0) {
        cout << "YES" << endl;
        return;
      } else {
        cout << "NO" << endl;
        return;
      }
    } else {
      cout << "NO" << endl;
      return;
    }
  }
}
int main() {
  int t;
  t = 1;
  while (t--) {
    solve();
  }
}
