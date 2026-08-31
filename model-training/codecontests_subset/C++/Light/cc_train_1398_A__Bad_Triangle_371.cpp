#include <bits/stdc++.h>
using namespace std;
int main() {
  int64_t cases, total, elements, i;
  cin >> cases;
  for (i = 0; i < cases; i++) {
    int flag = 0, val = 0;
    vector<int> x = {};
    cin >> total;
    for (int j = 0; j < total; j++) {
      cin >> elements;
      x.push_back(elements);
    }
    for (int l = 1; l <= x.size() - 2; l++) {
      if (x[0] + x[l] <= x[x.size() - 1]) {
        flag = 1;
        val = l;
        break;
      }
    }
    if (flag == 0) {
      cout << -1 << endl;
    } else {
      cout << 1 << " " << val + 1 << " " << x.size() << endl;
    }
  }
  return 0;
}
