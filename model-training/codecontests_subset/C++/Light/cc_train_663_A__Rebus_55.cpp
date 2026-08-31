#include <bits/stdc++.h>
using namespace std;
const int INF = 0x3f3f3f3f;
int main() {
  ios::sync_with_stdio(false);
  int ans;
  vector<int> Q;
  Q.push_back(1);
  int sum = 1;
  char mark;
  cin >> mark;
  while (cin >> mark) {
    if (mark == '+') {
      sum++;
      Q.push_back(1);
      cin >> mark;
    } else if (mark == '-') {
      sum--;
      Q.push_back(-1);
      cin >> mark;
    } else {
      cin >> ans;
      break;
    }
  }
  int delta = ans - sum;
  int k = 0;
  while (delta != 0 && k < Q.size()) {
    if (Q[k] > 0 && delta > 0) {
      if (delta >= ans - 1) {
        Q[k] = ans;
        delta -= ans - 1;
      } else {
        Q[k] += delta;
        delta = 0;
      }
    } else if (Q[k] < 0 && delta < 0) {
      if (delta <= -(ans - 1)) {
        Q[k] = -ans;
        delta += ans - 1;
      } else {
        Q[k] += delta;
        delta = 0;
      }
    }
    k++;
  }
  if (delta == 0) {
    cout << "Possible\n";
    cout << Q[0] << " ";
    for (int i = 1; i < Q.size(); i++) {
      if (Q[i] > 0) {
        cout << "+ " << Q[i] << " ";
      } else
        cout << "- " << -Q[i] << " ";
    }
    cout << "= " << ans << endl;
  } else
    cout << "Impossible\n";
  return 0;
}
