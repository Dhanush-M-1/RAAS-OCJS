#include <bits/stdc++.h>
using namespace std;
int main() {
  string str;
  cin >> str;
  int arr[4] = {0};
  for (int i = 0; i < str.length(); i += 2) {
    arr[str[i] - 48]++;
  }
  int i = 0;
  for (int i = 0; i < str.length(); i += 2) {
    if (arr[1] != 0) {
      str[i] = '1';
      arr[1]--;
    } else if (arr[2] != 0) {
      str[i] = '2';
      arr[2]--;
    } else if (arr[3] != 0) {
      str[i] = '3';
      arr[3]--;
    }
  }
  cout << str;
  return 0;
}
