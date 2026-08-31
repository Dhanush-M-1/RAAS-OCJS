#include <bits/stdc++.h>
using namespace std;
long long x, y, z;
deque<long long> q;
int main() {
  ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  ;
  cin >> x;
  for (int i = 0; i < x; i++) {
    cin >> y;
    q.push_back(y);
  }
  sort(q.rbegin(), q.rend());
  z = q[0];
  while (true) {
    long long s = 0, ss = 0;
    for (int i = 0; i < x; i++) {
      ss += q[i];
      s += (z - q[i]);
    }
    if (s > ss) {
      cout << z << endl;
      return 0;
    }
    z++;
  }
  return 0;
}
