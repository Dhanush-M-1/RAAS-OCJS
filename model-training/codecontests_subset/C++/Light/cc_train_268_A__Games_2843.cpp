#include <bits/stdc++.h>
using namespace std;
int main() {
  int c = 0;
  int n;
  cin >> n;
  int **a;
  a = (int **)malloc(sizeof(int *) * n);
  for (int i = 0; i < n; i++) {
    a[i] = (int *)malloc(sizeof(int) * 2);
    cin >> a[i][0] >> a[i][1];
  }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      if ((i == j) && (j < n - 1)) {
        j++;
      }
      if ((i == j) && (j == n - 1)) {
        break;
      }
      if (a[i][0] == a[j][1]) {
        c++;
      }
    }
  }
  cout << c;
  return 0;
}
