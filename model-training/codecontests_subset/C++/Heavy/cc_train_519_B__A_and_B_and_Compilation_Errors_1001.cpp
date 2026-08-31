#include <bits/stdc++.h>
using namespace std;
int main() {
  int n = 0, a = 0, b = 0;
  cin >> n;
  int* error1 = new int[n];
  int* error2 = new int[n - 1];
  int* error3 = new int[n - 2];
  for (int i = 0; i < n; i++) {
    cin >> error1[i];
  }
  b = n - 1;
  for (int i = 0; i < b; i++) {
    cin >> error2[i];
  }
  b = n - 2;
  for (int i = 0; i < b; i++) {
    cin >> error3[i];
  }
  sort(error1, error1 + n);
  sort(error2, error2 + n - 1);
  sort(error3, error3 + n - 2);
  for (int i = 0; i < n; i++) {
    if (error1[i] != error2[i]) {
      cout << error1[i] << '\n';
      break;
    }
  }
  for (int i = 0; i < n; i++) {
    if (error2[i] != error3[i]) {
      cout << error2[i] << '\n';
      break;
    }
  }
}
