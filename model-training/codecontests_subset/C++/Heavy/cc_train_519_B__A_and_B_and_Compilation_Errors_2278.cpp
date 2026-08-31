#include <bits/stdc++.h>
using namespace std;
int main() {
  long int i, n;
  cin >> n;
  long long int first[n], second[n - 1], third[n - 2];
  for (i = 0; i < n; i++) cin >> first[i];
  for (i = 0; i < n - 1; i++) cin >> second[i];
  for (i = 0; i < n - 2; i++) cin >> third[i];
  sort(first, first + n);
  sort(second, second + (n - 1));
  sort(third, third + (n - 2));
  long long int a = 0, b = 0;
  for (i = 0; i < n - 1; i++) {
    if (first[i] != second[i]) {
      a = first[i];
      break;
    }
  }
  if (i == n - 1) a = first[i];
  for (i = 0; i < n - 2; i++) {
    if (second[i] != third[i]) {
      b = second[i];
      break;
    }
  }
  if (i == n - 2) b = second[i];
  cout << a << endl;
  cout << b << endl;
}
