#include <bits/stdc++.h>
int main() {
  int i, j, len, count = 0, k = 0, val, temp;
  char str[110];
  gets(str);
  len = strlen(str);
  for (i = 0; i < len; i++) {
    if (str[i] == '1' || str[i] == '2' || str[i] == '3') {
      count++;
    }
  }
  int arr[count];
  for (i = 0; i < len; i++) {
    if (str[i] == '1' || str[i] == '2' || str[i] == '3') {
      val = str[i] - 48;
      arr[k] = val;
      k++;
    }
  }
  for (i = 0; i < count; i++) {
    temp = arr[i];
    for (j = i; j > 0 && temp < arr[j - 1]; j--) {
      arr[j] = arr[j - 1];
    }
    arr[j] = temp;
  }
  k = 0;
  for (i = 0; i < len; i++) {
    if (str[i] == '1' || str[i] == '2' || str[i] == '3') {
      str[i] = 48 + arr[k];
      k++;
    }
  }
  puts(str);
  return 0;
}
