#include <bits/stdc++.h>
using namespace std;
int main() {
  char arr[101];
  int len;
  char Temp;
  int i;
  cin >> arr;
  len = strlen(arr);
  while (len--)
    for (i = 0; i < len; i += 2)
      if (arr[i] > arr[i + 2]) {
        Temp = arr[i];
        arr[i] = arr[i + 2];
        arr[i + 2] = Temp;
      }
  cout << arr << endl;
  return 0;
}
