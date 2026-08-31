#include <bits/stdc++.h>
using namespace std;
multiset<int> s;
multiset<int> s1;
multiset<int> s2;
multiset<int> s3;
multiset<int> s4;
int main() {
  int n, x;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> x;
    s.insert(x);
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> x;
    s1.insert(x);
  }
  for (int i = 0; i < n - 2; i++) {
    cin >> x;
    s2.insert(x);
  }
  for (auto j : s1) {
    s.erase(s.find(j));
  }
  for (auto j : s2) {
    s1.erase(s1.find(j));
  }
  for (auto i : s) {
    cout << i << '\n';
  }
  for (auto i : s1) {
    cout << i << '\n';
  }
  return 0;
}
