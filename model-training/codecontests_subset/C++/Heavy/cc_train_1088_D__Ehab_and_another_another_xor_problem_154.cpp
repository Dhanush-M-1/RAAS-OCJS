#include <bits/stdc++.h>
using namespace std;
long long a, b, in;
long long shift(long long i) { return (1 << i); }
void getx(long long x, long long y) {
  cout << "? " << x << " " << y << endl;
  cin >> in;
  return;
}
int main() {
  ios_base::sync_with_stdio(false);
  long long curbit = 29;
  getx(0, 0);
  long long start = in;
  while (curbit >= 0) {
    if (start == 0) {
      getx(a ^ shift(curbit), b);
      if (in == -1) {
        a |= shift(curbit);
        b |= shift(curbit);
        getx(a, b);
        start = in;
      }
      curbit--;
      continue;
    }
    getx(a ^ shift(curbit), b ^ shift(curbit));
    while (in == start) {
      if (start == 1) {
        getx(a ^ shift(curbit), b);
        if (in == -1) {
          a |= shift(curbit);
          b |= shift(curbit);
        }
      } else {
        getx(a, b ^ shift(curbit));
        if (in == 1) {
          a |= shift(curbit);
          b |= shift(curbit);
        }
      }
      if (curbit == 0) break;
      curbit--;
      getx(a ^ shift(curbit), b ^ shift(curbit));
    }
    if (in != start) {
      if (start == 1)
        a |= shift(curbit);
      else if (start == 0) {
        a |= shift(curbit);
        b |= shift(curbit);
      } else
        b |= shift(curbit);
      getx(a, b);
      start = in;
    }
    curbit--;
  }
  cout << "! " << a << " " << b << endl;
  return 0;
}
