#include <bits/stdc++.h>
using namespace std;
int main() {
  string n;
  cin >> n;
  vector<int> a;
  for (int i = 0; i < n.size(); i += 2) {
    a.push_back(n[i] - 48);
  }
  sort(a.begin(), a.end());
  for (int i = 0; i < a.size() - 1; ++i) {
    cout << a[i] << "+";
  }
  cout << a[a.size() - 1];
  return 0;
}
