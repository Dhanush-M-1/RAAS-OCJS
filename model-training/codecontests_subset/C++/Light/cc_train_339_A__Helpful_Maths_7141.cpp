#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  cin >> s;
  char arr[100];
  int d = s.length();
  for (int i = 0; i < d; i++) {
    arr[i] = s[i];
  }
  sort(arr, arr + d);
  for (int i = 0; i < d; i++) {
    if (i == d - 1) {
      cout << arr[i];
    } else {
      if (arr[i] >= 49) cout << arr[i] << '+';
    }
  }
  return 0;
}
