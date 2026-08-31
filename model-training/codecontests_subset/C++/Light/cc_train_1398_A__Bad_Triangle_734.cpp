#include <bits/stdc++.h>
using namespace std;
int main() {
  int t, n, flag, j;
  cin >> t;
  int arr1[t];
  for (int i = 0; i < t; i++) {
    cin >> n;
    int arr[n];
    for (j = 0; j < n; j++) {
      cin >> arr[j];
    }
    flag = 0;
    for (j = 2; j < n; j++) {
      if (arr[j] >= arr[0] + arr[1]) {
        flag = 1;
        break;
      }
    }
    if (flag == 1)
      arr1[i] = j + 1;
    else
      arr1[i] = -1;
  }
  for (int i = 0; i < t; i++) {
    if (arr1[i] != -1)
      cout << "1 2"
           << " " << arr1[i] << endl;
    else
      cout << "-1" << endl;
  }
}
