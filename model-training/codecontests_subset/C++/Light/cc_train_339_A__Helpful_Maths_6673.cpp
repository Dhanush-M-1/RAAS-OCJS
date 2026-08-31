#include <bits/stdc++.h>
using namespace std;
int main() {
  string a;
  cin >> a;
  vector<long long> v;
  for (int i = 0; i < a.length(); i += 2) {
    a[i] = a[i] - '0';
    v.push_back(a[i]);
  }
  sort(v.begin(), v.end());
  for (int i = 0; i < v.size(); i++) {
    cout << v[i];
    if (i != v.size() - 1) cout << "+";
  }
}
