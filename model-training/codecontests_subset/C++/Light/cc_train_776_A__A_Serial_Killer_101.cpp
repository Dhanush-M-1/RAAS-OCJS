#include <bits/stdc++.h>
using namespace std;
string arr[10004][2];
int n;
int main() {
  cin >> arr[0][0] >> arr[0][1] >> n;
  for (int i = 1; i <= n; i++) {
    cin >> arr[i][0] >> arr[i][1];
    if (arr[i][0] == arr[i - 1][0]) {
      arr[i][0] = arr[i][1];
      arr[i][1] = arr[i - 1][1];
    } else if (arr[i][0] == arr[i - 1][1]) {
      arr[i][0] = arr[i - 1][0];
    }
  }
  for (int i = 0; i <= n; i++) {
    cout << arr[i][0] << " " << arr[i][1] << endl;
  }
  return 0;
}
