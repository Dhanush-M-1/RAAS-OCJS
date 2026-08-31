#include <bits/stdc++.h>
using namespace std;
int main() {
  int arr[10] = {0};
  string number;
  int x = 0;
  cin >> number;
  for (int i = 0; i < number.length(); i++) {
    if (number[i] != '+') arr[(int)number[i] - 49]++;
  }
  for (int i = 0; i < 10; i++) {
    for (int j = 0; j < arr[i]; j++) {
      if (x == 0)
        cout << i + 1;
      else
        cout << "+" << i + 1;
      x++;
    }
  }
}
