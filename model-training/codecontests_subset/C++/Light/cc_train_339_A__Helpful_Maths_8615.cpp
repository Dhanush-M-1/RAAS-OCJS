#include <bits/stdc++.h>
using namespace std;
int main() {
  int c;
  vector<int> d;
  while (cin >> c) {
    d.push_back(c);
  }
  sort(d.begin(), d.end());
  cout << d[0];
  for (int i = 1; i < d.size(); ++i) {
    cout << "+" << d[i];
  }
  return 0;
}
