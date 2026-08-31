#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  map<int, int> a;
  for (int i = 0; i < n; i++) {
    int temp;
    cin >> temp;
    a[temp]++;
  }
  map<int, int> b;
  for (int i = 0; i < n - 1; i++) {
    int temp;
    cin >> temp;
    b[temp]++;
  }
  map<int, int> c;
  for (int i = 0; i < n - 2; i++) {
    int temp;
    cin >> temp;
    c[temp]++;
  }
  for (map<int, int>::iterator it = a.begin(); it != a.end(); ++it) {
    if (it->second != b[it->first]) {
      cout << it->first << endl;
      break;
    }
  }
  for (map<int, int>::iterator it = b.begin(); it != b.end(); ++it) {
    if (it->second != c[it->first]) {
      cout << it->first << endl;
      break;
    }
  }
  return 0;
}
