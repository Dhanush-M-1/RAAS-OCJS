#include <bits/stdc++.h>
using namespace std;
int main() {
  char arr[100];
  cin >> arr;
  int size = strlen(arr);
  int count1 = 0, count2 = 0, count3 = 0, l = 0;
  for (int i = 0; i < size; i++) {
    if (arr[i] == '1') count1++;
    if (arr[i] == '2') count2++;
    if (arr[i] == '3') count3++;
  }
  for (int d = 0; d < count1; d++) {
    if (l == size - 1)
      cout << "1";
    else
      cout << "1+";
    l += 2;
  }
  for (int s = 0; s < count2; s++) {
    if (l == size - 1)
      cout << "2";
    else
      cout << "2+";
    l += 2;
  }
  for (int a = 0; a < count3; a++) {
    if (l == size - 1)
      cout << "3";
    else
      cout << "3+";
    l += 2;
  }
  return 0;
}
