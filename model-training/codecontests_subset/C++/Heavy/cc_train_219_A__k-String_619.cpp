#include <bits/stdc++.h>
using namespace std;
int main(int argc, char const *argv[]) {
  int k;
  string n;
  cin >> k;
  cin >> n;
  int len = n.length(), tmp = 1;
  char arr[10000], diffArr[1000];
  for (int i = 0; i < len; ++i) {
    arr[i] = n[i];
  }
  sort(arr, arr + len);
  int countChar[1000], countT = 0;
  for (int i = 0; i < len - 1; ++i) {
    if (arr[i] == arr[i + 1])
      tmp++;
    else {
      diffArr[countT] = arr[i];
      countChar[countT] = tmp;
      countT++;
      tmp = 1;
    }
  }
  tmp = 1;
  for (int i = len - 1; i >= 0; --i) {
    if (arr[i] == arr[i - 1])
      tmp++;
    else {
      diffArr[countT] = arr[i];
      countChar[countT] = tmp;
      countT++;
      break;
    }
  }
  bool check = true;
  for (int i = 0; i < countT; ++i) {
    if (countChar[i] % k != 0) {
      check = false;
      break;
    }
  }
  if (!check) {
    cout << -1;
    return 0;
  }
  for (int i = 0; i < k; ++i) {
    for (int t = 0; t < countT; ++t) {
      for (int j = 0; j < countChar[t] / k; ++j) {
        cout << diffArr[t];
      }
    }
  }
}
