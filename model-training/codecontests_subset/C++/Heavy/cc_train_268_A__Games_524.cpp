#include <bits/stdc++.h>
using namespace std;
int main() {
  int arr[30][2];
  int n, k = 0;
  cin >> n;
  while (!(n >= 2 && n <= 30)) {
    cout << "Please enter a number from 2 to 30" << endl;
    cin >> n;
  }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < 2; j++) {
      cin >> arr[i][j];
      while (!(arr[i][j] >= 1 && arr[i][j] <= 100)) {
        cout << "Please enter a number from 1 to 100" << endl;
        cin >> arr[i][j];
      }
      while ((j == 1) && (arr[i][j] == arr[i][j - 1])) {
        cout << "please enter a number different to the home uniform" << endl;
        cin >> arr[i][j];
      }
    }
  }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      if (arr[i][0] == arr[j][1]) k++;
    }
  }
  cout << k << endl;
  return 0;
}
