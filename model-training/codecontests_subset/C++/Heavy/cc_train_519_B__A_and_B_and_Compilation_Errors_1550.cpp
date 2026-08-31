#include <bits/stdc++.h>
using namespace std;
int first[100005];
int second[100005];
int third[100005];
int main() {
  int n;
  int j;
  cin >> n;
  for (int i = 0; i < n; ++i) {
    cin >> first[i];
  }
  for (int i = 0; i < n - 1; ++i) {
    cin >> second[i];
  }
  for (int i = 0; i < n - 2; ++i) {
    cin >> third[i];
  }
  sort(first, first + n);
  sort(second, second + n - 1);
  sort(third, third + n - 2);
  for (j = 0; j < n - 1; ++j) {
    if (first[j] != second[j]) {
      cout << first[j] << endl;
      break;
    }
  }
  if (j == n - 1) {
    cout << first[j] << endl;
  }
  for (j = 0; j < n - 2; ++j) {
    if (third[j] != second[j]) {
      cout << second[j] << endl;
      break;
    }
  }
  if (j == n - 2) {
    cout << second[j] << endl;
  }
  return 0;
}
