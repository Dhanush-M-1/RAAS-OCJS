#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int A[n];
  int H[n];
  int count;
  if (n >= 2) {
    count = 2;
  } else
    count = 1;
  for (int i = 0; i < n; i++) {
    cin >> A[i] >> H[i];
  }
  long long s = 0;
  int index = -2;
  for (int i = 1; i < n - 1; i++) {
    int d1 = A[i] - A[i - 1];
    int d2 = A[i + 1] - A[i];
    if (index + 1 != i) {
      s = 0;
    }
    if (H[i] < d1 - s) {
      count++;
    } else if (H[i] >= d1 - s && H[i] < d2) {
      count++;
      s = H[i];
      index = i;
    } else {
      continue;
    }
  }
  cout << count;
  return 0;
}
