#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  string in;
  vector<int> v;
  cin >> in;
  stringstream ss(in);
  while (ss >> t) {
    v.push_back(t);
  }
  sort(v.begin(), v.end());
  for (unsigned int i = 0; i < v.size(); i++) {
    if (i != v.size() - 1) {
      cout << v[i] << "+";
    } else {
      cout << v[i];
    }
  }
  return 0;
}
