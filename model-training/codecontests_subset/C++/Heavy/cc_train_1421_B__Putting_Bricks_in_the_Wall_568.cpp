#include <bits/stdc++.h>
using namespace std;
bool cmp(const pair<int, int> &left, const pair<int, int> &right) {
  return left.first > right.first ||
         (left.first == right.first && left.second < right.second);
}
int main() {
  int t, cs = 1;
  cin >> t;
  while (t--) {
    int n, m, a, b, c, i, j, k, mx = 0, mn = 1e9;
    string ar[2000];
    int bs[2000] = {0};
    cin >> n;
    for (i = 0; i < n; i++) cin >> ar[i];
    if (ar[0][1] == ar[1][0] && ar[n - 1][n - 2] == ar[n - 2][n - 1]) {
      if (ar[0][1] != ar[n - 1][n - 2])
        cout << 0 << endl;
      else {
        cout << 2 << endl;
        cout << 1 << " " << 2 << endl;
        cout << 2 << " " << 1 << endl;
      }
    } else if (ar[0][1] == ar[1][0] && ar[n - 1][n - 2] != ar[n - 2][n - 1]) {
      if (ar[0][1] == ar[n - 1][n - 2]) {
        cout << 1 << endl;
        cout << n << " " << n - 1 << endl;
      } else {
        cout << 1 << endl;
        cout << n - 1 << " " << n << endl;
      }
    } else if (ar[0][1] != ar[1][0] && ar[n - 1][n - 2] == ar[n - 2][n - 1]) {
      if (ar[0][1] == ar[n - 1][n - 2]) {
        cout << 1 << endl;
        cout << 1 << " " << 2 << endl;
      } else {
        cout << 1 << endl;
        cout << 2 << " " << 1 << endl;
      }
    } else {
      if (ar[0][1] == ar[n - 1][n - 2]) {
        cout << 2 << endl;
        cout << 1 << " " << 2 << endl;
        cout << n - 1 << " " << n << endl;
      } else {
        cout << 2 << endl;
        cout << 2 << " " << 1 << endl;
        cout << n - 1 << " " << n << endl;
      }
    }
  }
  return 0;
}
