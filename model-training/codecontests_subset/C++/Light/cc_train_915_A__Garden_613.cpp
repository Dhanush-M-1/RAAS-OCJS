#include <bits/stdc++.h>
using namespace std;
int main() {
  unsigned short int n, k, i, max1, x, MIN_hours;
  cin >> n;
  cin >> k;
  unsigned short int *A = new unsigned short int[n];
  for (i = 0; i < n; i++) {
    cin >> x;
    A[i] = x;
  }
  max1 = 1;
  for (i = 0; i < n; i++) {
    if (x == 0) {
      cout << "error the bucket should water minimal a segment  " << endl;
      return 0;
    }
    if (k % A[i] == 0) {
      if (max1 <= A[i]) {
        max1 = A[i];
      }
    }
  }
  MIN_hours = k / max1;
  cout << MIN_hours;
  delete[] A;
  return 0;
}
