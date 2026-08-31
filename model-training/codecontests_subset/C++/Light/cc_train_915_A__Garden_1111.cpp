#include <bits/stdc++.h>
const int nmax = 100;
using namespace std;
void swap(int *a, int k1, int k2) {
  if (k1 < nmax && k2 < nmax) {
    int m = a[k1];
    a[k1] = a[k2];
    a[k2] = m;
  }
}
void sortb(int *a, char s, int n) {
  int m1 = 0, m2 = m1;
  if (s == '<') {
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - 1 - i; j++) {
        if (a[j + 1] < a[j]) {
          swap(a, j, j + 1);
          m1++;
        }
      }
      if (m2 == m1) break;
      m2 = m1;
    }
  }
  if (s == '>') {
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - 1 - i; j++) {
        if (a[j + 1] > a[j]) {
          swap(a, j, j + 1);
          m1++;
        }
      }
      if (m2 == m1) break;
      m2 = m1;
    }
  }
}
int main() {
  int n, k;
  int a[nmax];
  cin >> n >> k;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }
  sortb(a, '<', n);
  for (int i = n - 1; i >= 0; i--) {
    if (k % a[i] == 0) {
      cout << k / a[i];
      ;
      break;
    }
  }
  return 0;
}
