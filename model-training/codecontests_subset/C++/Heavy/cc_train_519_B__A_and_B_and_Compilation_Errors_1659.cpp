#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  vector<int> first(n);
  vector<int> second(n - 1);
  vector<int> third(n - 2);
  for (int i = 0; i < n; i++) {
    cin >> first[i];
  }
  sort(first.begin(), first.end());
  for (int i = 0; i < n - 1; i++) {
    cin >> second[i];
  }
  sort(second.begin(), second.end());
  for (int i = 0; i < n - 2; i++) {
    cin >> third[i];
  }
  sort(third.begin(), third.end());
  bool found = false;
  for (int i = 0; i < n - 1; i++) {
    if (first[i] != second[i]) {
      if (second[i] == first[i + 1]) {
        cout << first[i] << endl;
      } else {
        cout << second[i] << endl;
      }
      found = true;
      break;
    }
  }
  if (!found) {
    if (first[n - 1] != second[n - 2]) {
      cout << first[n - 1] << endl;
    } else {
      cout << second[n - 2] << endl;
    }
  }
  found = false;
  for (int i = 0; i < n - 2; i++) {
    if (third[i] != second[i]) {
      if (third[i] == second[i + 1]) {
        cout << second[i];
      } else {
        cout << third[i];
      }
      found = true;
      break;
    }
  }
  if (!found) {
    if (second[n - 2] != third[n - 3]) {
      cout << second[n - 2];
    } else {
      cout << third[n - 3];
    }
  }
  return 0;
}
