#include <bits/stdc++.h>
using namespace std;
int main() {
  int x;
  int ans = 0;
  for (int i = 0; i < 5; i++) {
    cin >> x;
    ans += x;
  }
  if (ans == 0) {
    cout << "-1";
    return 0;
  }
  if (ans % 5 == 0) {
    cout << (int)(ans / 5);
  } else {
    cout << "-1";
  }
  return 0;
}
