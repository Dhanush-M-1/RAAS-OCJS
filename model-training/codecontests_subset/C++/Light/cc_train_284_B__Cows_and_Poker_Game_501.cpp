#include <bits/stdc++.h>
using namespace std;
int main() {
  int SIZE;
  cin >> SIZE;
  char arr[SIZE];
  for (int i = 0; i < SIZE; i++) {
    cin >> arr[i];
  }
  int cntr = 0;
  int k = 0;
  for (int i = 0; i < SIZE; i++) {
    if (arr[i] == 'A') {
      cntr++;
    }
    if (arr[i] == 'I') {
      k++;
    }
  }
  if (k == 1) {
    cout << 1;
  } else if (k > 1) {
    cout << 0;
  } else {
    cout << cntr;
  }
  return 0;
}
