#include <bits/stdc++.h>
using namespace std;
int main() {
  int arr[3] = {0, 0, 0};
  string s;
  cin >> s;
  if (s.size() == 1) {
    cout << s << '\n';
  } else if (s.size() == 3) {
    if (s[0] > s[2])
      cout << s[2] << '+' << s[0] << '\n';
    else
      cout << s << '\n';
  } else {
    int size = 0;
    for (int i = 0; i < s.size(); i = i + 2) {
      arr[s[i] - '0' - 1]++;
      size++;
    }
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < arr[i]; j++) {
        --size;
        if (size <= 1 && i == 2 && j == arr[i] - 1) {
          cout << i + 1;
        } else {
          cout << i + 1 << '+';
        }
      }
    }
  }
  return 0;
}
