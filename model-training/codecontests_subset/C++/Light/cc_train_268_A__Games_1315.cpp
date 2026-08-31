#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, flag = 0;
  cin >> n;
  int arr[n][2];
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < 2; ++j) {
      cin >> arr[i][j];
    }
  }
  for (int k = 0; k < n; ++k) {
    for (int l = 0; l < n; ++l) {
      if (arr[k][0] == arr[l][1]) {
        flag++;
      }
    }
  }
  cout << flag;
  return 0;
}
