#include <bits/stdc++.h>
using namespace std;
class SignedReader {
  char arr[262144];
  char *p, *e;
  int s, val;
  bool neg;
  void getTok() {
    p = arr;
    s = fread(arr, 1, 262144, stdin);
    e = arr + s;
  }
  void skip() {
    while (true) {
      if (p == e) getTok();
      if (*p == '-' || ((*p) >= '0' && (*p) <= '9')) return;
      p++;
    }
  }

 public:
  SignedReader() { getTok(); }
  int nextInt() {
    neg = false;
    skip();
    if (*p == '-') neg = true, p++;
    val = 0;
    while (true) {
      if (p == e) getTok();
      if (p == e) break;
      if (((*p) >= '0' && (*p) <= '9'))
        val = 10 * val + *p - 48, p++;
      else
        break;
    }
    if (neg) val = -val;
    return val;
  }
};
int main() {
  int a[105];
  int n, c;
  cin >> n >> c;
  int best = 0;
  for (int i = 0; i < n; i++) {
    scanf("%d", a + i);
    if (i) best = max(best, a[i - 1] - a[i] - c);
  }
  cout << best << endl;
  return 0;
}
