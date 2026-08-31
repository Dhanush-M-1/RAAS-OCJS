#include <bits/stdc++.h>
int main() {
  char string[101];
  int arr[100];
  int map = 0;
  int temp;
  scanf("%s", &string);
  int length = strlen(string);
  for (int i = 0; i < length; i++) {
    if (string[i] == '1') {
      arr[map] = 1;
      map++;
    } else if (string[i] == '2') {
      arr[map] = 2;
      map++;
    } else if (string[i] == '3') {
      arr[map] = 3;
      map++;
    }
  }
  for (int i = 0; i < map - 1; i++) {
    for (int j = 0; j < map - 1 - i; j++) {
      if (arr[j] > arr[j + 1]) {
        temp = arr[j];
        arr[j] = arr[j + 1];
        arr[j + 1] = temp;
      }
    }
  }
  for (int i = 0; i < map; i++) {
    if (i == map - 1) {
      printf("%d", arr[i]);
    } else {
      printf("%d+", arr[i]);
    }
  }
  return 0;
}
