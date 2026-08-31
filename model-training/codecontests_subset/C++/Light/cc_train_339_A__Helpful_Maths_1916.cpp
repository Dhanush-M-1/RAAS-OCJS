#include <bits/stdc++.h>
using namespace std;
string s;
int x, y, w = -1;
int main() {
  cin >> s;
  x = s.size();
  int n = (x + 1) / 2;
  int arr[n];
  for (int i = 0; i < x; i++) {
    if (s[i] != '+') {
      w++;
      y = s[i] - '0';
      arr[w] = y;
    }
  }
  sort(arr, arr + n);
  for (int i = 0; i < n; i++) {
    cout << arr[i];
    if (i != n - 1) {
      cout << '+';
    }
  }
  return 0;
}
