#include <bits/stdc++.h>
using namespace std;
int main() {
  int a;
  cin >> a;
  while (a--) {
    int b, c;
    cin >> b >> c;
    int arr1[b], arr2[c];
    set<int> check;
    for (int j = 0; j < b; j++) {
      cin >> arr1[j];
      check.insert(arr1[j]);
    }
    int x = -1;
    for (int j = 0; j < c; j++) {
      cin >> arr2[j];
      if (check.count(arr2[j])) x = arr2[j];
    }
    if (x == -1)
      cout << "NO\n";
    else {
      cout << "YES\n";
      cout << "1"
           << " " << x << "\n";
    }
  }
}
