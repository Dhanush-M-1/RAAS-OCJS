#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x;
  map<int, int> m, m1, m2;
  map<int, int>::iterator it, it1, it2;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> x;
    m[x]++;
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> x;
    m1[x]++;
  }
  for (it = m.begin(), it1 = m1.begin(); it != m.end(); it++, it1++)
    if (it->first != it1->first || it->second != it1->second) {
      cout << it->first << endl;
      break;
    }
  for (int i = 0; i < n - 2; i++) {
    cin >> x;
    m2[x]++;
  }
  for (it1 = m1.begin(), it2 = m2.begin(); it1 != m.end(); it1++, it2++)
    if (it1->first != it2->first || it1->second != it2->second) {
      cout << it1->first;
      break;
    }
  return 0;
}
