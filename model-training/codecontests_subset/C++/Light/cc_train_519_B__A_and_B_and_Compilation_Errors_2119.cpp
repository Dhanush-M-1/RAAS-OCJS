#include <bits/stdc++.h>
using namespace std;
int main() {
  multiset<int> x, x2;
  multiset<int>::iterator it;
  int n, k;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> k;
    x.insert(k);
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> k;
    x2.insert(k);
    it = x.find(k);
    x.erase(it);
  }
  for (it = x.begin(); it != x.end(); ++it) cout << *it << "\n";
  for (int i = 0; i < n - 2; i++) {
    cin >> k;
    it = x2.find(k);
    if (it != x2.end()) x2.erase(it);
  }
  for (it = x2.begin(); it != x2.end(); ++it) cout << *it << "\n";
}
