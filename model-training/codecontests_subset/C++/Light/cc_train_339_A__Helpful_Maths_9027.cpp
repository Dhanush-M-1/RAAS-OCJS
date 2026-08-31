#include <bits/stdc++.h>
using namespace std;
string x;
vector<int> n;
int main() {
  cin >> x;
  int li = x.length(), i;
  for (i = 0; i < li; i++) {
    if (x[i] == 49 || x[i] == 50 || x[i] == 51) {
      n.push_back(x[i]);
    }
  }
  sort(n.begin(), n.end());
  int si = n.size();
  for (i = 0; i < si; i++) {
    if (i == si - 1) {
      cout << n[i] - 48;
    } else {
      cout << n[i] - 48 << "+";
    }
  }
  return 0;
}
