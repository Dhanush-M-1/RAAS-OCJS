#include <bits/stdc++.h>
using namespace std;
int main() {
  char q, op;
  cin >> q;
  int pos = 1, neg = 0;
  vector<bool> pos_entry(1, true);
  int n = -1;
  while (true) {
    cin >> op;
    if (op == '=') {
      cin >> n;
      break;
    } else {
      cin >> q;
      if (op == '+') {
        pos++;
        pos_entry.push_back(true);
      } else {
        neg++;
        pos_entry.push_back(false);
      }
    }
  }
  if (pos - neg * n <= n && n <= pos * n - neg) {
    cout << "Possible" << endl;
    int target = n - pos + neg;
    for (int i = 0; i < pos_entry.size(); i++) {
      if (i > 0) cout << (pos_entry[i] ? "+ " : "- ");
      int qn = 1;
      if ((target < 0 && !pos_entry[i]) || (target > 0 && pos_entry[i])) {
        qn = min(abs(target) + 1, n);
        if (target > 0)
          target -= (qn - 1);
        else
          target += (qn - 1);
      }
      cout << qn << " ";
    }
    cout << "= " << n << endl;
  } else {
    cout << "Impossible" << endl;
  }
  return 0;
}
