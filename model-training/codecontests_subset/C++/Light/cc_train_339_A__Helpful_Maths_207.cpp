#include <bits/stdc++.h>
using namespace std;
int main() {
  int i = 0, x = 0;
  char str[200] = {};
  cin >> str;
  int n = strlen(str), y = (n / 2 + 1);
  int arr[n];
  for (int i = 0; i < y; i++) {
    arr[i] = ((int)str[x] - 48);
    x += 2;
  }
  sort(arr, arr + y);
  for (int i = 0; i < y; i++) {
    if (i == 0)
      cout << arr[0];
    else
      cout << "+" << arr[i];
  }
  return 0;
}
