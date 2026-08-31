#include <bits/stdc++.h>
using namespace std;
using namespace std;
int a = 0;
int b = 0;
int n;
bool shouldSwap = false;
int A = 83886724;
int B = 83886724;
int ask(int x, int y) {
  if (shouldSwap) swap(x, y);
  cout << "? " << x << " " << y << endl;
  int ans = 0;
  int q = A ^ x;
  int v = B ^ y;
  if (q < v) ans = -1;
  if (q > v) ans = 1;
  cin >> ans;
  if (shouldSwap) ans = -ans;
  return ans;
}
void runEq() {
  for (int i = n + 1 - 1; i >= 0; --i) {
    int a1 = a | (1 << i);
    int bit = 1;
    if (ask(a1, b) == 1) {
      bit = 0;
    }
    a |= (bit << i);
    b |= (bit << i);
  }
}
void runSimple() {
  while (n >= 0) {
    int a1 = a | (1 << n);
    int b1 = b | (1 << n);
    int ans = ask(a1, b1);
    if (ans == 1) {
      b |= (1 << n);
      int alb = ask(a, b);
      if (alb == 0) {
        --n;
        runEq();
        return;
      } else if (alb == 1) {
        swap(a, b);
        shouldSwap = !shouldSwap;
      }
    } else {
      a1 = a | (1 << n);
      b1 = b;
      int ans = ask(a1, b1);
      int bit = 1;
      if (ans == 1) {
        bit = 0;
      }
      a |= (bit << n);
      b |= (bit << n);
    }
    --n;
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  n = 29;
  int alb = ask(0, 0);
  if (alb == 0) {
    runEq();
    cout << "! " << a << " " << b << endl;
    return 0;
  }
  if (alb == 1) {
    shouldSwap = true;
  }
  runSimple();
  if (shouldSwap) swap(a, b);
  cout << "! " << a << " " << b << endl;
  return 0;
}
