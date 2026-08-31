#include <bits/stdc++.h>
using namespace std;
const int N = 101;
int a, b, y[N], x[N];
int ji = 1, j3;
string s[N];
inline void alloc(int n) {
  int start = 0, lin = 0;
  for (int i = 0; i < b; i++) {
    if (x[i]) {
      start = i + 1;
      lin = 0;
    } else {
      lin++;
      if (lin == n) {
        for (int j = start; j < start + n; j++) x[j] = ji;
        cout << ji << endl;
        ji++;
        return;
      }
    }
  }
  cout << "NULL\n";
  return;
}
inline void erase(int n) {
  bool ans = false;
  for (int i = 0; i < b; i++) {
    if (x[i] == n) {
      ans = true;
      x[i] = 0;
    }
  }
  if (!ans || n < 0 || j3 == 0 || n > j3) {
    cout << "ILLEGAL_ERASE_ARGUMENT\n";
    return;
  }
  return;
}
inline void defragment() {
  int lc[N], l = 0;
  memset(lc, 0, N * sizeof(int));
  for (int i = 0; i < b; i++) {
    if (x[i]) {
      lc[l] = x[i];
      x[i] = 0;
      l++;
    }
  }
  for (int i = 0; i < l; i++) x[i] = lc[i];
  return;
}
int main() {
  cin >> a >> b;
  for (int i = 0; i < a; i++) {
    cin >> s[i];
    if (s[i] != "defragment") cin >> y[i];
    if (s[i] == "alloc") j3++;
  }
  for (int i = 0; i < a; i++) {
    if (s[i] == "alloc")
      alloc(y[i]);
    else if (s[i] == "erase")
      erase(y[i]);
    else
      defragment();
  }
  return 0;
}
