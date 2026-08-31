#include <bits/stdc++.h>
using namespace std;
int main() {
  multiset<int> s1, s2;
  int n;
  cin >> n;
  for (int i = 0; i < n; ++i) {
    int x;
    cin >> x;
    s1.insert(x);
  }
  for (int i = 0; i < n - 1; ++i) {
    int x;
    cin >> x;
    s2.insert(x);
    s1.erase(s1.find(x));
  }
  cout << *s1.begin() << endl;
  for (int i = 0; i < n - 2; ++i) {
    int x;
    cin >> x;
    s2.erase(s2.find(x));
  }
  cout << *s2.begin() << endl;
  return 0;
}
