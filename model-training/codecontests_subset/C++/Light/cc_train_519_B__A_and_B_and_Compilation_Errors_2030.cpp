#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  ;
  int arr1[n];
  int arr2[n - 1];
  int arr3[n - 2];
  int a = 0;
  int b = 0;
  int c = 0;
  for (int i = 0; i < n; i++) {
    cin >> arr1[i];
    a += arr1[i];
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> arr2[i];
    b += arr2[i];
  }
  for (int i = 0; i < n - 2; i++) {
    cin >> arr3[i];
    c += arr3[i];
  }
  cout << a - b << "\n";
  cout << b - c;
}
