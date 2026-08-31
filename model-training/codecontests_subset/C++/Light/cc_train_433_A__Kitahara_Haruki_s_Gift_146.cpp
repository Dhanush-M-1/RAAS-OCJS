#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int cnt100 = 0, cnt200 = 0;
  for (int i = 0; i < n; i++) {
    int a;
    cin >> a;
    if (a == 100) {
      cnt100++;
    } else {
      cnt200++;
    }
  }
  if (cnt200 % 2 != 0) {
    cnt100 = cnt100 - 2;
  }
  if (cnt100 % 2 == 0 && cnt100 >= 0) {
    cout << "YES";
  } else {
    cout << "NO";
  }
  return 0;
}
