#include <bits/stdc++.h>
using namespace std;
int p1 = -1000000001;
int p2 = -1000000001;
int n;
int q1, h, q2, a, b, c1, c2;
int main() {
  cin >> n;
  for (; n; n--) {
    cin >> q1 >> h;
    q2 = q1 + h;
    a = -1;
    if (q1 - h > p1) a = max(a, c1 + 1);
    if (q1 > p1) a = max(a, c1);
    if (q1 - h > p2) a = max(a, c2 + 1);
    if (q1 > p2) a = max(a, c2);
    b = -1;
    if (q1 > p1) b = max(b, c1 + 1);
    if (q1 > p2) b = max(b, c2 + 1);
    p1 = q1;
    c1 = a;
    p2 = q2;
    c2 = b;
  }
  cout << max(c1, c2);
  return 0;
}
