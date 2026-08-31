#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  string str;
  cin >> str;
  int ans = 0;
  int countA = 0;
  for (int i = 0; i < n; i++) {
    if (str[i] == 'I') {
      ans++;
    } else if (str[i] == 'A') {
      countA++;
    }
  }
  if (ans == 0) {
    cout << countA;
  } else {
    if (ans > 1) {
      cout << 0;
    } else {
      cout << 1;
    }
  }
  int end;
  cin >> end;
  return 0;
}
