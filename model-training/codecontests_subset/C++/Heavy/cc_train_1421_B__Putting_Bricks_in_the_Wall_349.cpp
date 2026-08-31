#include <bits/stdc++.h>
using namespace std;
int main() {
  int t, n, i, j, c;
  char chr;
  cin >> t;
  bool first_diag, second_diag;
  while (t--) {
    cin >> n;
    string arr[n];
    vector<int> v;
    c = 0;
    for (i = 0; i < n; i++) cin >> arr[i];
    first_diag = (arr[0][1] == arr[1][0]);
    second_diag = (arr[n - 2][n - 1] == arr[n - 1][n - 2]);
    if (first_diag && second_diag) {
      if (arr[n - 2][n - 1] == arr[0][1]) {
        c = 2;
        v.push_back(1);
        v.push_back(2);
        v.push_back(2);
        v.push_back(1);
      }
    } else if (first_diag) {
      c = 1;
      if (arr[n - 1][n - 2] == arr[0][1]) {
        v.push_back(n);
        v.push_back(n - 1);
      } else {
        v.push_back(n - 1);
        v.push_back(n);
      }
    } else if (second_diag) {
      c = 1;
      if (arr[n - 1][n - 2] == arr[0][1]) {
        v.push_back(1);
        v.push_back(2);
      } else {
        v.push_back(2);
        v.push_back(1);
      }
    } else {
      c = 2;
      v.push_back(1);
      v.push_back(2);
      if (arr[0][1] == arr[n - 2][n - 1]) {
        v.push_back(n);
        v.push_back(n - 1);
      } else {
        v.push_back(n - 1);
        v.push_back(n);
      }
    }
    cout << c << "\n";
    for (i = 0; i < c; i++) cout << v[2 * i] << " " << v[2 * i + 1] << "\n";
  }
  return 0;
}
