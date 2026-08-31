#include <bits/stdc++.h>
using namespace std;
int main() {
  int x, y, z, i, j;
  vector<int> a;
  vector<int> b;
  vector<int> c;
  cin >> x >> y;
  for (i = 0; i < x; i++) {
    cin >> z;
    a.push_back(z);
  }
  int diff = 0;
  int counter2 = 0;
  for (i = 0; i < a.size(); i++) {
    if (i == x - 1) {
      break;
    }
    if (a[i] > a[i + 1]) {
      diff = a[i] - a[i + 1];
      c.push_back(diff);
      counter2++;
    }
  }
  if (counter2 == 0) {
    cout << "0";
  } else {
    int max = c[0];
    for (i = 0; i < c.size(); i++) {
      if (c[i] > max) {
        max = c[i];
      }
    }
    for (i = 0; i < a.size(); i++) {
      if (i == x - 1) {
        break;
      }
      if (a[i] - a[i + 1] == max) {
        if (a[i] - a[i + 1] - y < 0) {
          cout << "0";
          break;
        } else {
          cout << a[i] - a[i + 1] - y;
          break;
        }
      }
    }
  }
  return 0;
}
