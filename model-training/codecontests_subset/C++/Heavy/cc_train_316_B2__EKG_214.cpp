#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x;
  int a[1001];
  bool hasPred[1001] = {};
  cin >> n >> x;
  for (int i = 1; i <= n; ++i) {
    cin >> a[i];
    if (a[i] != 0) {
      hasPred[a[i]] = true;
    }
  }
  int lengths[1000];
  int size = 0;
  for (int i = 1; i <= n; ++i) {
    if (!hasPred[i] && i != x) {
      lengths[size] = 0;
      bool metX = false;
      for (int j = i; j != 0; j = a[j]) {
        ++lengths[size];
        metX |= j == x;
      }
      if (!metX) {
        ++size;
      }
    }
  }
  int pos = 0;
  for (int i = x; i != 0; i = a[i]) {
    ++pos;
  }
  bool possible[1000] = {};
  possible[0] = true;
  for (int i = 0; i < size; ++i) {
    for (int j = n - 1; j > 0; --j) {
      if (j >= lengths[i]) {
        possible[j] |= possible[j - lengths[i]];
      }
    }
  }
  for (int i = 0; i < n; ++i) {
    if (possible[i]) {
      cout << i + pos << endl;
    }
  }
}
