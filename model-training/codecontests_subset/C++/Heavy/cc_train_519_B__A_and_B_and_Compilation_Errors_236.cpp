#include <bits/stdc++.h>
using namespace std;
int main() {
  int numbers;
  cin >> numbers;
  int arr[numbers];
  int arr2[numbers - 1];
  int arr3[numbers - 2];
  for (int i = 0; i < numbers; i++) {
    cin >> arr[i];
  }
  for (int k = 0; k < numbers - 1; k++) {
    cin >> arr2[k];
  }
  for (int l = 0; l < numbers - 2; l++) {
    cin >> arr3[l];
  }
  int count = 0;
  int count1 = 0;
  sort(arr, arr + numbers);
  sort(arr2, arr2 + numbers - 1);
  sort(arr3, arr3 + numbers - 2);
  for (int s = 0; s < numbers - 1; s++) {
    if (arr[s] == arr2[s]) {
      count++;
      continue;
    } else {
      cout << arr[s] << endl;
      break;
    }
  }
  if (count == numbers - 1) {
    cout << arr[numbers - 1] << endl;
  }
  for (int a = 0; a < numbers - 2; a++) {
    if (arr2[a] == arr3[a]) {
      count1++;
      continue;
    } else {
      cout << arr2[a];
      break;
    }
  }
  if (count1 == numbers - 2) {
    cout << arr2[numbers - 2] << endl;
  }
}
