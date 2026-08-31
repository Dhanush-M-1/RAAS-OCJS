#include <bits/stdc++.h>
using namespace std;
int main() {
  string arr;
  int str[100];
  int i, j = 0;
  cin >> arr;
  for (i = 0; i < arr.length(); i++) {
    if (arr[i] >= 49 && arr[i] <= 51) str[j++] = arr[i] - 48;
  }
  sort(str, str + j);
  for (i = 0; i < j; i++) {
    cout << str[i];
    if (i < j - 1) cout << "+";
  }
  return 0;
}
