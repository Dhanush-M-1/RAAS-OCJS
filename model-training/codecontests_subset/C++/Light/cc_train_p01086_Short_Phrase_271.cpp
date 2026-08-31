#include <iostream>
#include <vector>
#include <string>
using namespace std;
int main() {
  int n, t, x, j;
  string s;
  vector<int> v, u;
  while (cin >> n, n) {
    for (int i = 0; i < n; ++i) {
      cin >> s;
      v.push_back(s.size());
    }
    t = 0;
    u = {5, 7, 5, 7, 7, 0};
    for (int i = 0; i < n; ++i) {
      j = i;
      t = 0;
      x = 5;
      while (x >= 0 && t < 5) {
	x -= v[j];
	if (!x) {
	  ++t;
	  x = u[t];
	} else if (x < 0) break;
	++j;
      }
      if (t == 5) {
	cout << i+1 << endl;
	break;
      }
    }
    v.erase(v.begin(), v.end());
  }
  return 0;
}