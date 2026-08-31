#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, w, one = 0, two = 0, sum = 0;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> w;
    if (w == 100) {
      one++;
    } else {
      two++;
    }
    sum += w;
  }
  if (two % 2 == 0) {
    if (one % 2 == 0) {
      cout << "YES";
    } else {
      cout << "NO";
    }
  } else {
    one -= 2;
    if (one < 0) {
      cout << "NO";
      return 0;
    }
    if (one % 2 == 0) {
      cout << "YES";
    } else {
      cout << "NO";
    }
  }
  return 0;
}
