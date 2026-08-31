#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, counter = 0;
  cin >> n;
  int arr1[n], arr2[n];
  for (int x = 0; x < n; x++) {
    cin >> arr1[x] >> arr2[x];
  }
  for (int x = 0; x < n; x++) {
    for (int y = 0; y < n; y++) {
      if (arr1[x] == arr2[y]) counter++;
    }
  }
  cout << counter << endl;
  return 0;
}
