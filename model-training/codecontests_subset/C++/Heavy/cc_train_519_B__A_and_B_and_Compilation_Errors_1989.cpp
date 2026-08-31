#include <bits/stdc++.h>
using namespace std;
int main() {
  vector<int> errors[3];
  int n;
  cin >> n;
  for (int i = 0; i < n; ++i) {
    int a;
    cin >> a;
    errors[0].push_back(a);
  }
  for (int i = 0; i < n - 1; ++i) {
    int a;
    cin >> a;
    errors[1].push_back(a);
  }
  for (int i = 0; i < n - 2; ++i) {
    int a;
    cin >> a;
    errors[2].push_back(a);
  }
  sort(errors[0].begin(), errors[0].end());
  sort(errors[1].begin(), errors[1].end());
  sort(errors[2].begin(), errors[2].end());
  int first, second;
  int sub_i = 0;
  for (int i = 0; i < n; ++i) {
    if (sub_i == n - 1) {
      first = errors[0][n - 1];
      break;
    }
    if (errors[0][i] != errors[1][sub_i]) {
      first = errors[0][i];
      break;
    } else {
      ++sub_i;
    }
  }
  sub_i = 0;
  for (int i = 0; i < n - 1; ++i) {
    if (sub_i == n - 2) {
      second = errors[1][n - 2];
      break;
    }
    if (errors[1][i] != errors[2][sub_i]) {
      second = errors[1][i];
      break;
    } else {
      ++sub_i;
    }
  }
  cout << first << endl << second << endl;
}
