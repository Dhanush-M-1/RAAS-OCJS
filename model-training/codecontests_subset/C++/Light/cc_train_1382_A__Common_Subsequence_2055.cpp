#include <bits/stdc++.h>
using namespace std;
int seach(int c, int arr[], int size) {
  for (int i = 0; i < size; i++) {
    if (arr[i] == c) {
      return 1;
    }
  }
  return 0;
}
int main() {
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    int k1;
    cin >> k1;
    int k2;
    cin >> k2;
    int arr1[k1];
    for (int j = 0; j < k1; j++) {
      int c;
      cin >> c;
      arr1[j] = c;
    }
    bool p = false;
    for (int j = 0; j < k2; j++) {
      int c;
      cin >> c;
      if (seach(c, arr1, k1) == 1) {
        if (!p) cout << "Yes\n1 " << c << endl;
        p = true;
      }
    }
    if (!p) cout << "No\n";
  }
}
