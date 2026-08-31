#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, h = 0;
  cin >> n;
  int **ary = new int *[n];
  for (int i = 0; i < n; ++i) {
    ary[i] = new int[2];
  }
  for (int i = 0; i < n; i++) {
    for (int q = 0; q < 2; q++) cin >> ary[i][q];
  }
  for (int q = 0; q < n; q++) {
    for (int i = 0; i < n; i++) {
      if (ary[i][0] == ary[q][1]) {
        h++;
      }
    }
  }
  cout << h << endl;
  for (int i = 0; i < n; ++i) {
    delete[] ary[i];
  }
  delete[] ary;
  return 0;
}
