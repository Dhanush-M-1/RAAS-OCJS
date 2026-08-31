#include <bits/stdc++.h>
using namespace std;
int main() {
  string str;
  int len, i, j = 0;
  int arr[3];
  arr[0] = arr[1] = arr[2] = 0;
  cin >> str;
  len = str.length();
  for (i = 0; i < len; i += 2) {
    if (str[i] == '1') {
      arr[0] += 1;
    } else if (str[i] == '2') {
      arr[1] += 1;
    } else {
      arr[2] += 1;
    }
  }
  for (i = 0; i < len; i += 2) {
    if (arr[j] > 0) {
      str[i] = '0' + j + 1;
      arr[j] -= 1;
    } else {
      j += 1;
      i -= 2;
    }
  }
  cout << str;
  return 0;
}
