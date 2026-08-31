#include <bits/stdc++.h>
using namespace std;
template <class T1>
inline void debug(T1 _x) {
  cout << _x << '\n';
}
template <class T1, class T2>
inline void debug(T1 _x, T2 _y) {
  cout << _x << ' ' << _y << '\n';
}
template <class T1, class T2, class T3>
inline void debug(T1 _x, T2 _y, T3 _z) {
  cout << _x << ' ' << _y << ' ' << _z << '\n';
}
template <class T1, class T2, class T3, class T4>
inline void debug(T1 _x, T2 _y, T3 _z, T4 _zz) {
  cout << _x << ' ' << _y << ' ' << _z << ' ' << _zz << '\n';
}
template <class T1>
inline void debug(T1 _array, int _size) {
  cout << "[";
  for (int i = 0; i < _size; ++i) {
    cout << ' ' << _array[i];
  }
  puts(" ]");
}
inline bool CI(int &_x) { return scanf("%d", &_x) == 1; }
inline bool CI(int &_x, int &_y) { return CI(_x) && CI(_y); }
inline bool CI(int &_x, int &_y, int &_z) { return CI(_x) && CI(_y) && CI(_z); }
inline bool CI(int &_x, int &_y, int &_z, int &_zz) {
  return CI(_x) && CI(_y) && CI(_z) && CI(_zz);
}
inline void wait(double seconds) {
  double endtime = clock() + (seconds * CLOCKS_PER_SEC);
  while (clock() < endtime) {
    ;
  }
}
const double eps = 1e-9;
int n, x, y;
inline void Read() { CI(n, x, y); }
inline string toS(double var) {
  char _buff[50];
  sprintf(_buff, "%.9lf", var);
  return (string)_buff;
}
inline void Proc() {
  long long xtra;
  for (xtra = 0;; ++xtra) {
    long long tmp = (xtra + x) * 100.;
    if (tmp >= ((long long)(y)*n)) break;
  }
  cout << xtra;
  puts("");
}
int main() {
  int tt = 1;
  for (int i = 1, j1 = tt + 1; i < j1; ++i) {
    Read();
    Proc();
  }
  return 0;
}
