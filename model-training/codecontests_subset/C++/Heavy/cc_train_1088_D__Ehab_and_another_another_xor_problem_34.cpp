#include <bits/stdc++.h>
using namespace std;
int ask(int a, int b) {
  cout << "? " << a << " " << b << endl;
  fflush(stdout);
  int res;
  cin >> res;
  return res;
}
void answer(int a, int b) {
  cout << "! " << a << " " << b << endl;
  fflush(stdout);
  exit(0);
}
void solveEqual(int ans1, int ans2, int bit) {
  for (int i = bit; i >= 0; --i) {
    if (ask(ans1 | (1 << i), ans2) == -1) ans1 |= 1 << i, ans2 |= 1 << i;
  }
  answer(ans1, ans2);
}
void solve(int ma, int mb, int bit, int flag) {
  if (bit == -1) {
    answer(ma, mb);
  }
  if (flag > 0) {
    int res = ask(ma | (1 << bit), mb);
    if (res == 1) {
      int res2 = ask(ma | (1 << bit), mb | (1 << bit));
      if (res2 == 1) {
        solve(ma, mb, bit - 1, flag);
      } else {
        solve(ma | (1 << bit), mb, bit - 1, flag);
      }
    } else if (res == 0) {
      solveEqual(ma | (1 << bit), mb, bit - 1);
    } else {
      int res2 = ask(ma | (1 << bit), mb | (1 << bit));
      if (res2 == 1) {
        solve(ma | (1 << bit), mb | (1 << bit), bit - 1, flag);
      } else {
        solve(ma | (1 << bit), mb, bit - 1, flag * -1);
      }
    }
  } else {
    int res = ask(ma, mb | (1 << bit));
    if (res == -1) {
      int res = ask(ma | (1 << bit), mb | (1 << bit));
      if (res == -1) {
        solve(ma, mb, bit - 1, flag);
      } else {
        solve(ma, mb | (1 << bit), bit - 1, flag);
      }
    } else if (res == 0) {
      solveEqual(ma, mb | (1 << bit), bit - 1);
    } else {
      int res2 = ask(ma | (1 << bit), mb | (1 << bit));
      if (res2 == -1) {
        solve(ma | (1 << bit), mb | (1 << bit), bit - 1, flag);
      } else {
        solve(ma, mb | (1 << bit), bit - 1, flag * -1);
      }
    }
  }
}
int main() {
  int res = ask(0, 0);
  if (res == 0) {
    solveEqual(0, 0, 29);
  } else {
    solve(0, 0, 29, res);
  }
  return 0;
}
