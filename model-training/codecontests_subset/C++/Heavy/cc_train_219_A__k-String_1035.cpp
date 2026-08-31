#include <bits/stdc++.h>
using namespace std;
int main() {
  string str;
  int arr[26] = {0}, arrindex[26];
  char str2[1000];
  char arr2[26] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
                   'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                   's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
  int count = 0, count2 = 0, n, size, x;
  bool flag = true;
  cin >> n >> str;
  size = str.size();
  for (int i = 0; i < 26; i++) {
    for (int j = 0; j < size; j++) {
      if (str[j] == arr2[i]) {
        arr[i]++;
      }
    }
  }
  for (int j = 0; j < 26; j++) {
    for (int i = 0; i < size; i++) {
      if (str[i] == arr2[j]) {
        str2[count] = arr2[j];
        arr2[j] = '*';
        count++;
        break;
      }
    }
  }
  for (int j = 0; j < 26; j++) {
    if (arr[j] > 0) {
      arrindex[count2] = arr[j];
      count2++;
    }
  }
  for (int j = 0; j < count2; j++) {
    if (arrindex[j] % n == 0) {
      continue;
    } else {
      flag = false;
      break;
    }
  }
  if (!flag) {
    cout << -1 << endl;
    return 0;
  } else {
    for (int j = 0; j < n; j++) {
      for (int i = 0; i < count2; i++) {
        x = arrindex[i];
        for (int k = 0; k < x / n; k++) cout << str2[i];
      }
    }
  }
  return 0;
}
