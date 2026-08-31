#include <bits/stdc++.h>
using namespace std;
list<int> l1, l2, l3, l4;
int main() {
  int n, t, a, c;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> t;
    l1.push_back(t);
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> t;
    l2.push_back(t);
    l4.push_back(t);
  }
  for (int i = 0; i < n - 2; i++) {
    cin >> t;
    l3.push_back(t);
  }
  l1.sort();
  l2.sort();
  l3.sort();
  l4.sort();
  for (list<int>::iterator it = l1.begin(), itr = l2.begin(); it != l1.end();
       it++, itr++) {
    if (*it != *itr) {
      a = *it;
      break;
    }
  }
  for (list<int>::iterator it = l4.begin(), itr = l3.begin(); it != l4.end();
       it++, itr++) {
    if (*it != *itr) {
      c = *it;
      break;
    }
  }
  cout << a << "\n" << c << "\n";
  return 0;
}
