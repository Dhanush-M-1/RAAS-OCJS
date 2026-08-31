#include <bits/stdc++.h>
using namespace std;
int main() {
  char row[100];
  cin >> row;
  int length = 0;
  for (int i = 0; row[i] != '\0'; i++) {
    length++;
  }
  for (int i = 0; i < length; i += 2) {
    int minindex = i;
    for (int j = i + 2; j < length; j += 2)
      if (row[j] < row[minindex]) minindex = j;
    if (minindex != i) {
      char temp = row[minindex];
      row[minindex] = row[i];
      row[i] = temp;
    }
  }
  cout << row;
  return 0;
}
