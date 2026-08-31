#include <bits/stdc++.h>
using namespace std;
int ar[100005];
int ar1[100005];
int ar2[100005];
int main() {
  int a, b, c, d, i, j, k, l, n;
  cin >> n;
  for (i = 0; i < n; i++) cin >> ar[i];
  for (j = 0; j < n - 1; j++) cin >> ar1[j];
  for (k = 0; k < n - 2; k++) cin >> ar2[k];
  sort(ar, ar + n);
  sort(ar1, ar1 + (n - 1));
  sort(ar2, ar2 + (n - 2));
  for (i = 0; i < n; i++) {
    if (ar[i] != ar1[i]) {
      cout << ar[i] << endl;
      break;
    }
  }
  for (i = 0; i < n - 1; i++) {
    if (ar1[i] != ar2[i]) {
      cout << ar1[i] << endl;
      break;
    }
  }
  return 0;
}
