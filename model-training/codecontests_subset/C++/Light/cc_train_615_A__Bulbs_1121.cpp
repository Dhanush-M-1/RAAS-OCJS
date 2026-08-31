#include <bits/stdc++.h>
using namespace std;
const int maxN = 1e5 + 100;
int main() {
  long long int key, lmp;
  cin >> key >> lmp;
  bool a[lmp];
  for (long long int i = 0; i < lmp; i++) a[i] = false;
  for (long long int i = 0; i < key; i++) {
    long long int d;
    cin >> d;
    for (long long int i = 0; i < d; i++) {
      long long int f;
      cin >> f;
      a[f - 1] = true;
    }
  }
  for (long long int i = 0; i < lmp; i++) {
    if (a[i] == false) {
      cout << "NO\n";
      return 0;
    }
  }
  cout << "YES\n";
  return 0;
}
