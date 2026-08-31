#include <bits/stdc++.h>
using namespace std;
int main() {
  string x;
  int arr[100] = {0};
  int count = 0, ibef = 0, jbef = 0, min = 100, counter = 0;
  cin >> x;
  int z = x.size();
  for (int i = 0; i < z; i++) {
    if (x[i] != '+' && x[i] != 0) {
      arr[count++] = x[i] - 48;
      counter++;
    }
  }
  for (int i = 0; i < count; i++) {
    min = arr[i];
    for (int j = i + 1; j < count; j++) {
      if (arr[j] < arr[i]) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }
  }
  for (int i = 0; i < count; i++) {
    if (i == count - 1) {
      cout << arr[i];
      return 0;
    }
    cout << arr[i] << "+";
  }
  return 0;
}
