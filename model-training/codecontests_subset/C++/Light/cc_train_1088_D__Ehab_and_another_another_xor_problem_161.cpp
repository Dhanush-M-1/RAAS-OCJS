#include <bits/stdc++.h>
using namespace std;
int ask(int a, int b) {
  cout << "? " << a << ' ' << b << endl;
  int res;
  cin >> res;
  return res;
}
int main() {
  cout.flush();
  int currA(0), currB(0);
  int aIsBig = ask(0, 0);
  for (int i = 29; i >= 0; i--) {
    int f = ask(currA ^ (1 << i), currB);
    int s = ask(currA, currB ^ (1 << i));
    if (f == s) {
      if (aIsBig == 1) {
        currA ^= (1 << i);
      } else {
        currB ^= (1 << i);
      }
      aIsBig = f;
    } else if (f == -1) {
      currA ^= (1 << i);
      currB ^= (1 << i);
    }
  }
  cout << "! " << currA << " " << currB << endl;
}
