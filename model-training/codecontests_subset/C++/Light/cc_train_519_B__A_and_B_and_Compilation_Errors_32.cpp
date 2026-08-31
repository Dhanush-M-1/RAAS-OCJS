#include <bits/stdc++.h>
using namespace std;
int main() {
  int i, n;
  cin >> n;
  int s1 = 0, s2 = 0, s3 = 0;
  int* arr = new int[n];
  int* arr2 = new int[n - 1];
  int* arr3 = new int[n - 2];
  for (i = 0; i < n; i++) {
    cin >> arr[i];
    s1 += arr[i];
  }
  for (i = 0; i < n - 1; i++) {
    cin >> arr2[i];
    s2 += arr2[i];
  }
  for (i = 0; i < n - 2; i++) {
    cin >> arr3[i];
    s3 += arr3[i];
  }
  cout << s1 - s2 << endl;
  cout << s2 - s3 << endl;
}
