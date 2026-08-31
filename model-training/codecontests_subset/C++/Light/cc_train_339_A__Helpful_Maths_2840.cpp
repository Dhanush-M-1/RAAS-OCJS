#include <bits/stdc++.h>
using namespace std;
int main() {
  string x;
  cin >> x;
  if (x.size() <= 2) {
    cout << x;
  } else {
    for (int i = 0; i < x.size(); i += 2) {
      for (int j = 0; j <= x.size() - 2; j += 2) {
        if (x[j] > x[j + 2]) {
          swap(x[j], x[j + 2]);
        }
      }
    }
    for (int i = 0; i < x.size(); i++) {
      cout << x[i];
    }
  }
}
