#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  vector<int> home, guest;
  int h, g, i, count = 0;
  for (i = 0; i < n; i++) {
    cin >> h >> g;
    home.push_back(h);
    guest.push_back(g);
  }
  vector<int>::iterator h1 = home.begin();
  vector<int>::iterator g1 = guest.begin();
  while (h1 != home.end()) {
    g1 = guest.begin();
    while (g1 != guest.end()) {
      if (*h1 == *g1) count++;
      g1++;
    }
    h1++;
  }
  cout << count << endl;
  return 0;
}
