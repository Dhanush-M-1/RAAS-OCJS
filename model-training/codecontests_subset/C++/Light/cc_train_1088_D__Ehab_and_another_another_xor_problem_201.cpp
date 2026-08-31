#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e5;
int a[maxn];
int query(int a, int b) {
  printf("? %d %d\n", a, b);
  int tmp;
  cin >> tmp;
  return tmp;
}
int main() {
  int n;
  int abig = query(0, 0);
  long long a = 0, b = 0;
  for (int i = 29; i >= 0; i--) {
    int x = query(a ^ (1 << i), b), y = query(a, b ^ (1 << i));
    if (x == y) {
      if (abig == 1) {
        a ^= (1 << i);
      } else
        b ^= (1 << i);
      abig = x;
    } else {
      if (x == -1) {
        a ^= (1 << i);
        b ^= (1 << i);
      }
    }
  }
  cout << '!' << " " << a << " " << b << endl;
}
