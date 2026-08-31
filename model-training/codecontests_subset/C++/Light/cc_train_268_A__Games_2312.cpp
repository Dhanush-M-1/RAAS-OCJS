#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, cnt1 = 0, cnt2 = 0;
  cin >> n;
  int arr[n][2];
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < 2; j++) {
      cin >> arr[i][j];
    }
  }
  for (int i = 0; i < n; i++) {
    for (int k = 0; k < n; k++) {
      if (arr[i][0] == arr[k][1]) {
        cnt1 += 1;
      }
    }
  }
  cout << cnt1 << endl;
}
