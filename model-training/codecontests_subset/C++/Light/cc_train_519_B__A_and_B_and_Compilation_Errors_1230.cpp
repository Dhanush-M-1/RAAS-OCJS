#include <bits/stdc++.h>
using namespace std;
int sum(int a[], int size) {
  int sum = 0;
  for (int i = 0; i < size; i++) {
    sum = sum + a[i];
  }
  return sum;
}
int main() {
  int n;
  cin >> n;
  int a1[n], a2[n - 1], a3[n - 3];
  for (int i = 0; i < n; i++) {
    cin >> a1[i];
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> a2[i];
  }
  for (int i = 0; i < n - 2; i++) {
    cin >> a3[i];
  }
  cout << sum(a1, n) - sum(a2, n - 1) << endl
       << sum(a2, n - 1) - sum(a3, n - 2);
  return 0;
}
