#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  int cnt1 = 0, cnt2 = 0;
  int x, sum = 0, ans = 0;
  int i;
  ;
  cin >> n;
  for (i = 0; i < n; i++) {
    cin >> x;
    if (x == 100) {
      cnt1++;
    } else {
      cnt2++;
    }
  }
  if (cnt2 == 0) {
    if (cnt1 % 2 != 0) {
      cout << "NO";
    } else {
      cout << "YES";
    }
  }
  if (cnt1 == 0) {
    if (cnt2 % 2 == 0) {
      cout << "YES";
    } else {
      cout << "NO";
    }
  }
  if (cnt1 != 0 && cnt2 != 0) {
    if (cnt1 % 2 != 0 && cnt2 % 2 != 0) {
      cout << "NO";
    }
    if (cnt1 % 2 != 0 && cnt2 % 2 == 0) {
      cout << "NO";
    }
    if (cnt1 % 2 == 0 && cnt2 % 2 != 0) {
      cout << "YES";
    }
    if (cnt1 % 2 == 0 && cnt2 % 2 == 0) {
      cout << "YES";
    }
  }
  return 0;
}
