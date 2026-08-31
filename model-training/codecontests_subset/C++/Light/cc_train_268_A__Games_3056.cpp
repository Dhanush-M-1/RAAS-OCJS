#include <bits/stdc++.h>
using namespace std;
int main() {
  int x, cnt = 0;
  cin >> x;
  int arr1[x], arr2[x];
  for (int i = 0; i < x; i++) {
    cin >> arr1[i] >> arr2[i];
  }
  for (int i = 0; i < x; i++) {
    for (int j = 0; j < x; j++) {
      if (i == j) {
        continue;
      }
      if (arr1[i] == arr2[j]) {
        cnt++;
      }
    }
  }
  cout << cnt;
}
