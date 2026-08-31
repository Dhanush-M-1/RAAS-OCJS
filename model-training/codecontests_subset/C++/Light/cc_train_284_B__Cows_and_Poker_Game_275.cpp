#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i, in = 0;
  int fol = 0;
  int all = 0;
  char* A;
  cin >> n;
  A = new char[n];
  for (i = 0; i < n; i++) cin >> A[i];
  for (i = 0; i < n; i++) {
    if (A[i] == 'A') {
      all++;
    }
    if (A[i] == 'I') {
      in++;
    }
    if (A[i] == 'F') {
      fol++;
    }
  }
  if (in == 0) {
    cout << all;
  } else if (in == 1) {
    cout << "1";
  } else if (n > 1) {
    cout << "0";
  }
  return 0;
}
