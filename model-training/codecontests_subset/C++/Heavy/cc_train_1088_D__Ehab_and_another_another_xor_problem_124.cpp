#include <bits/stdc++.h>
using namespace std;
inline int query(int x, int y) {
  cout << "? " << x << " " << y << endl;
  int p;
  cin >> p;
  return p;
}
inline void print(int x, int y) { cout << "! " << x << " " << y << endl; }
int num[30];
int main() {
  int tmp, tmp2, sum1 = 0, sum2 = 0, a = 0, b = 0;
  tmp = query(0, 0);
  for (int i = 29; ~i; --i) {
    sum1 |= (1 << i);
    sum2 |= (1 << i);
    tmp2 = query(sum1, sum2);
    if (tmp2 != tmp && tmp2) {
      num[i] = -tmp2;
      sum1 ^= (1 << i);
      tmp = query(sum1, sum2);
    } else
      num[i] = 0;
  }
  for (int i = 29; ~i; --i) {
    if (num[i] == 1) a |= (1 << i);
    if (num[i] == -1) b |= (1 << i);
    if (!num[i]) {
      tmp2 = query(sum1 ^ (1 << i), sum2);
      if (tmp2 == 1) a |= (1 << i), b |= (1 << i);
    }
  }
  print(a, b);
  return 0;
}
