#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int cnt1 = 0, cnt2 = 0;
  for (int i = 0; i < n; i++) {
    int x;
    cin >> x;
    if (x == 100) {
      cnt1++;
    } else {
      cnt2++;
    }
  }
  if (cnt1) {
    if (cnt1 % 2 == 0) {
      cout << "YES";
    } else {
      cout << "NO";
    }
  } else {
    if (cnt2 % 2 == 0) {
      cout << "YES";
    } else {
      cout << "NO";
    }
  }
}
