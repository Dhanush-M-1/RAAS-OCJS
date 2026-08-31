#include <bits/stdc++.h>
using namespace std;
const double INFK = 1e20;
bool dy(double x, double y) { return x > y + 1e-6; }
bool xy(double x, double y) { return x < y - 1e-6; }
bool dyd(double x, double y) { return x > y - 1e-6; }
bool xyd(double x, double y) { return x < y + 1e-6; }
bool dd(double x, double y) { return fabs(x - y) < 1e-6; }
int k;
void f(int x) {
  int tot = 0;
  char ch[10000];
  while (x) {
    ch[tot++] = x % k + '0';
    x /= k;
  }
  for (int i = tot - 1; i >= 0; --i) {
    cout << ch[i];
  }
  cout << ' ';
}
int main() {
  while (cin >> k) {
    for (int i = 1; i < k; ++i) {
      for (int j = 1; j < k; ++j) f(i * j);
      cout << endl;
    }
  }
  return 0;
}
