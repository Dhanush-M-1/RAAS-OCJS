#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a, b, first, sec, c = 0;
  cin >> n;
  vector<int> v;
  vector<int> u;
  while (n--) {
    cin >> a >> b;
    v.push_back(a);
    u.push_back(b);
  }
  for (int i = 0; i < v.size(); i++) {
    for (int j = 0; j < u.size(); j++) {
      if (v[i] == u[j]) {
        c += 1;
      }
    }
  }
  cout << c;
}
