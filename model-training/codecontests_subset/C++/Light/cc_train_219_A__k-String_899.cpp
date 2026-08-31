#include <bits/stdc++.h>
using namespace std;
int main() {
  int k;
  cin >> k;
  int arr[26] = {0};
  string st, result;
  cin >> st;
  bool flag = false;
  for (int i = 0; i < st.length(); i++) {
    arr[st[i] - 'a']++;
  }
  for (int j = 0; j < 26; j++) {
    if (arr[j] % k != 0) {
      flag = true;
      break;
    } else {
      if (arr[j] > 0) {
        for (int m = 0; m < arr[j] / k; m++) {
          result += (j + 'a');
        }
      }
    }
  }
  if (flag) {
    cout << -1 << "\n";
  } else {
    for (int i = 0; i < k; i++) {
      cout << result;
    }
  }
}
