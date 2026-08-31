#include <bits/stdc++.h>
using namespace std;
const int NIL = -1;
template <class T>
inline T mx(T a, T b) {
  return a > b ? a : b;
}
template <class T>
inline T mi(T a, T b) {
  return a < b ? a : b;
}
template <class T>
inline void sw(T &a, T &b) {
  T t = a;
  a = b;
  b = t;
}
template <class T>
inline T mabs(T x) {
  return x < 0 ? -x : x;
}
inline char gc() {
  char ret;
  while ((ret = getchar()) == ' ' || ret == '\n' || ret == '\t')
    ;
  return ret;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL), cout.tie(NULL);
  string str[2];
  cin >> str[0] >> str[1];
  string u, v;
  int n;
  cin >> n;
  cout << str[0] << ' ' << str[1] << '\n';
  while (n--) {
    cin >> u >> v;
    for (int i = 0; i < 2; i++) {
      if (str[i] == u) str[i] = v;
    }
    cout << str[0] << ' ' << str[1] << '\n';
  }
  return 0;
}
