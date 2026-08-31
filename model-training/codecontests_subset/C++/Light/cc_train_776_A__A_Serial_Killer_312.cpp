#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int n, i, k, j, l, m = 1, c = 0, o, x;
  string f, s, dead, newy, z;
  cin >> f >> s;
  cin >> n;
  deque<string> vics;
  deque<string> order;
  vics.push_front(f);
  vics.push_front(s);
  order.push_front(f);
  order.push_front(s);
  for (i = 0; i < n; i++) {
    cin >> dead >> newy;
    if (vics.front() == dead) {
      vics.pop_front();
      vics.push_front(newy);
    } else {
      vics.pop_back();
      vics.push_back(newy);
    }
    order.push_front(vics.front());
    order.push_front(vics.back());
  }
  while (order.size() != 0) {
    cout << order.back() << " ";
    order.pop_back();
    cout << order.back() << endl;
    order.pop_back();
  }
  return 0;
}
