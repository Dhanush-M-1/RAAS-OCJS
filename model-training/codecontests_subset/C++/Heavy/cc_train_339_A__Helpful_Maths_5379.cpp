#include <bits/stdc++.h>
using namespace std;
int main() {
  string array;
  getline(cin, array);
  char num[array.length() + 1];
  int x = 0;
  for (int i = 0; i < array.length(); i++) {
    if (array[i] == '+' || array[i] == '\n' || array[i] == ' ') {
      continue;
    } else {
      num[x] = array[i];
      x++;
    }
  }
  for (int i = 0; i < x; i++) {
    for (int j = 0; j < x - i - 1; j++) {
      if (int(num[j]) > int(num[j + 1])) {
        char temp = num[j];
        num[j] = num[j + 1];
        num[j + 1] = temp;
      }
    }
  }
  for (int i = 0; i < x; i++) {
    if (i == x - 1) {
      cout << num[i] << endl;
    } else {
      cout << num[i] << "+";
    }
  }
  return 0;
}
