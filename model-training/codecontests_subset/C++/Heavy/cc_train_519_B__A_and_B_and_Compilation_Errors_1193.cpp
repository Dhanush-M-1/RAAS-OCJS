#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  vector<long long> arr, arr2, arr3;
  int temp;
  for (int i = 0; i < n; i++) {
    cin >> temp;
    arr.push_back(temp);
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> temp;
    arr2.push_back(temp);
  }
  for (int i = 0; i < n - 2; i++) {
    cin >> temp;
    arr3.push_back(temp);
  }
  sort(arr.begin(), arr.end());
  sort(arr2.begin(), arr2.end());
  sort(arr3.begin(), arr3.end());
  for (int i = 0, j = 0; i < n; i++, j++) {
    if (j < n - 1 && arr[i] != arr2[j]) {
      cout << arr[i] << endl;
      break;
    }
    if (j == n - 1) cout << arr[i] << endl;
  }
  for (int i = 0, j = 0; i < n - 1; i++, j++) {
    if (j < n - 2 && arr2[i] != arr3[j]) {
      cout << arr2[i] << endl;
      break;
    }
    if (j == n - 2) cout << arr2[i] << endl;
  }
}
