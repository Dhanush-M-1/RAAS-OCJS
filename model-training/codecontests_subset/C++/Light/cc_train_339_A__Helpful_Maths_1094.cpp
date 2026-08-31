#include <bits/stdc++.h>
using namespace std;
bool f(int x, int y) { return x < y; }
int main() {
  int n, l, ch, i, t;
  string s;
  getline(cin, s);
  l = s.size();
  vector<int> a;
  for (i = 0; i < l; i++) {
    t = i + 1;
    if (t % 2 != 0) {
      ch = s[i] - 48;
      a.push_back(ch);
    }
  }
  sort(a.begin(), a.end(), f);
  vector<int>::iterator it;
  it = a.begin();
  cout << *it;
  for (it = a.begin() + 1; it < a.end(); it++) {
    cout << "+" << *it;
  }
  return 0;
}
