#include <bits/stdc++.h>
using namespace std;
int ask(int c, int d) {
  cout << "? " << c << " " << d << endl;
  fflush(stdout);
  int x;
  cin >> x;
  return x;
}
void go(int a, int b) {
  cout << "! " << a << " " << b << endl;
  fflush(stdout);
  exit(0);
}
bool same[50];
signed main() {
  int type = ask(0, 0);
  if (type == 0) {
    int ans = 0;
    for (int i = 29; i >= 0; i--) {
      int q = ask((1 << i), 0);
      if (q == 0) {
        continue;
      }
      if (q == 1) {
        ans += 0;
      } else {
        ans += (1 << i);
      }
    }
    go(ans, ans);
  }
  bool A, B;
  if (type == 1) {
    A = 1;
    B = 0;
  } else {
    A = 0;
    B = 1;
  }
  int ansA = 0, ansB = 0;
  for (int i = 29; i >= 0; i--) {
    int q = ask(ansA + (1 << i), ansB + (1 << i));
    if (q == 0) {
      for (int pos = i; pos >= 0; pos--) {
        same[pos] = 1;
      }
      break;
    }
    if (A == 1) {
      if (q == 1) {
        same[i] = 1;
      } else {
        ansA += (1 << i);
        ansB += 0;
        int qq = ask(ansA, ansB);
        if (qq == 1) A = 1, B = 0;
        if (qq == -1) A = 0, B = 1;
      }
    } else {
      if (q == -1) {
        same[i] = 1;
      } else {
        ansA += 0;
        ansB += (1 << i);
        int qq = ask(ansA, ansB);
        if (qq == 1) A = 1, B = 0;
        if (qq == -1) A = 0, B = 1;
      }
    }
  }
  for (int i = 29; i >= 0; i--) {
    if (same[i]) {
      int q = ask(ansA + (1 << i), ansB);
      if (q == 0) {
        continue;
      }
      if (q == 1) {
        ansA += 0;
        ansB += 0;
      } else {
        ansA += (1 << i);
        ansB += (1 << i);
      }
    }
  }
  go(ansA, ansB);
}
