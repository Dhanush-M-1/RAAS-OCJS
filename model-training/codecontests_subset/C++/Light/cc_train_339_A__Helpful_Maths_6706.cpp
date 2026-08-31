#include <bits/stdc++.h>
using namespace std;
int main() {
  string a;
  int A[100];
  int n = 0;
  cin >> a;
  for (int i = 0; i < a.size(); i++) {
    if (a[i] == '1') {
      A[n] = 1;
      n++;
    } else if (a[i] == '2') {
      A[n] = 2;
      n++;
    } else if (a[i] == '3') {
      A[n] = 3;
      n++;
    }
  }
  int SIZE;
  if (n == 1)
    SIZE = 1;
  else if (n > 1)
    SIZE = n + 1;
  sort(A, A + SIZE);
  for (int i = 0; i < n - 1; i++) cout << A[i] << "+";
  cout << A[n - 1];
  return 0;
}
