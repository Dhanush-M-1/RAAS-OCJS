#include <bits/stdc++.h>
using namespace std;
int main() {
  int arr[30];
  int arr2[30];
  int counter = 0;
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> arr[i] >> arr2[i];
  }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      if (arr[i] == arr2[j]) {
        counter++;
      }
    }
  }
  cout << counter << endl;
  return 0;
}
