#include <bits/stdc++.h>
using namespace std;
int n, m;
vector<int> v;
int main() {
  cin >> n >> m;
  v.resize(n);
  for (int i = 0; i < v.size(); i++) {
    if (i % m == 0) {
      v.push_back(0);
    }
  }
  cout << v.size() - 1;
  return 0;
}
