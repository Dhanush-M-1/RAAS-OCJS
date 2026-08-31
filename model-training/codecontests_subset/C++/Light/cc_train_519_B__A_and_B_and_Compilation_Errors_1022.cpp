#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int ar[n], ar2[n - 1], ar3[n - 2];
  for (int i = 0; i < n; i++) {
    cin >> ar[i];
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> ar2[i];
  }
  for (int i = 0; i < n - 2; i++) {
    cin >> ar3[i];
  }
  sort(ar, ar + n);
  sort(ar2, ar2 + n - 1);
  sort(ar3, ar3 + n - 2);
  ar2[n - 1] = 0;
  ar3[n - 2] = 0;
  for (int i = 0; i < n; i++) {
    if (ar[i] != ar2[i]) {
      cout << ar[i] << endl;
      break;
    }
  }
  for (int i = 0; i < n - 1; i++) {
    if (ar2[i] != ar3[i]) {
      cout << ar2[i] << endl;
      break;
    }
  }
}
