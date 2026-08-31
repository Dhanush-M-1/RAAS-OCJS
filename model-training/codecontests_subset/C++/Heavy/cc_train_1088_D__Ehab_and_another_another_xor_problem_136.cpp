#include <bits/stdc++.h>
using namespace std;
int x, y;
set<int> s1;
int getResponse(int a, int b) {
  int temp;
  cout << "? " << a << " " << b << endl;
  fflush(stdout);
  cin >> temp;
  return temp;
}
void getEqual(int a, int b) {
  for (int i = 0; i < 30; i++) {
    if (s1.find(i) == s1.end()) {
      s1.insert(i);
      if (getResponse(a ^ (1 << i), (b)) == -1) {
        x ^= (1 << i);
        y ^= (1 << i);
      }
    }
  }
}
void getGreater(int a, int b, int resp, int bit) {
  if (bit < 0) {
    getEqual(a, b);
  } else if (resp == 1) {
    resp = getResponse(a ^ (1 << bit), b ^ (1 << bit));
    if (resp == 1) {
      getGreater(a, b, resp, bit - 1);
    } else {
      x ^= 1 << bit;
      s1.insert(bit);
      resp = getResponse(a ^ (1 << bit), b);
      getGreater(a ^ (1 << bit), b, resp, bit - 1);
    }
  } else if (resp == -1) {
    resp = getResponse(a ^ (1 << bit), b ^ (1 << bit));
    if (resp == -1) {
      getGreater(a, b, resp, bit - 1);
    } else {
      y ^= 1 << bit;
      s1.insert(bit);
      resp = getResponse(a ^ (1 << bit), b);
      getGreater(a, b ^ (1 << bit), resp, bit - 1);
    }
  } else if (resp == 0) {
    getEqual(a, b);
  }
}
int main() {
  int resp;
  resp = getResponse(0, 0);
  int a = 0, b = 0;
  x = 0;
  y = 0;
  if (resp == 0) {
    getEqual(a, b);
    cout << "! " << x << " " << y << endl;
    fflush(stdout);
  } else {
    getGreater(a, b, resp, 29);
    cout << "! " << x << " " << y << endl;
    fflush(stdout);
  }
  return 0;
}
