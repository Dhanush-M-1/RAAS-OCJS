#include <bits/stdc++.h>
using namespace std;
int main() {
  string arr;
  int arr1[101];
  int i, j = 0, k, l, n;
  cin >> arr;
  l = arr.size();
  for (i = 0; i < l; i++) {
    arr1[j] = (arr[i] - '0');
    j++;
    i = i + 1;
  }
  sort(arr1, arr1 + j);
  for (k = 0; k <= j - 1; k++) {
    if (k == j - 1)
      cout << arr1[k] << endl;
    else
      cout << arr1[k] << "+";
  }
  return 0;
}
