#include <bits/stdc++.h>
using namespace std;
template <class T>
T pwr(T b, T p) {
  T r = 1, x = b;
  while (p) {
    if (p & 1) r *= x;
    x *= x;
    p = (p >> 1);
  }
  return r;
}
template <class T>
T lcm(T a, T b) {
  return (a / __gcd(a, b)) * b;
}
template <class T>
T sqr(T a) {
  return a * a;
}
template <class T>
void xswap(T &x, T &y) {
  if (x != y) {
    x ^= y;
    y ^= x;
    x ^= y;
  }
}
template <typename T>
inline bool isOn(T &mask, int pos) {
  return ((mask) & (1LL << pos));
}
template <typename T>
inline T setf(T mask, int pos) {
  return mask = ((mask) & (~(1LL << pos)));
}
template <typename T>
inline T sett(T mask, int pos) {
  return mask = ((mask) | (1LL << pos));
}
template <typename T>
inline T flip(T mask, int pos) {
  return mask = ((mask) ^ (1LL << pos));
}
template <class T1>
void put(T1 e) {
  cout << e << endl;
}
template <class T1, class T2>
void put(T1 e1, T2 e2) {
  cout << e1 << " " << e2 << endl;
}
template <class T1, class T2, class T3>
void put(T1 e1, T2 e2, T3 e3) {
  cout << e1 << " " << e2 << " " << e3 << endl;
}
template <class T1, class T2, class T3, class T4>
void put(T1 e1, T2 e2, T3 e3, T4 e4) {
  cout << e1 << " " << e2 << " " << e3 << " " << e4 << endl;
}
template <class T1, class T2, class T3, class T4, class T5>
void put(T1 e1, T2 e2, T3 e3, T4 e4, T5 e5) {
  cout << e1 << " " << e2 << " " << e3 << " " << e4 << " " << e5 << endl;
}
template <class T1>
void putv(vector<T1> e1) {
  for (int i = 0; i < e1.size(); i++)
    (!i ? cout << e1[i] : cout << " " << e1[i]);
  cout << endl;
}
template <class T1>
void puta(T1 arr[], int l) {
  for (int i = 0; i < l; i++) (!i ? cout << arr[i] : cout << " " << arr[i]);
  cout << endl;
}
template <class T1>
bool tk(T1 &e1) {
  return (cin >> e1 ? true : false);
}
template <class T1, class T2>
bool tk(T1 &e1, T2 &e2) {
  return (cin >> e1 >> e2 ? true : false);
}
template <class T1, class T2, class T3>
bool tk(T1 &e1, T2 &e2, T3 &e3) {
  return (cin >> e1 >> e2 >> e3 ? true : false);
}
template <class T1, class T2, class T3, class T4>
bool tk(T1 &e1, T2 &e2, T3 &e3, T4 &e4) {
  return (cin >> e1 >> e2 >> e3 >> e4 ? true : false);
}
map<int, int> er;
map<int, int> er2;
map<int, int> er3;
int main() {
  int n, tmp, mx = -9;
  tk(n);
  for (int i = 0; i <= n - 1; ++i) {
    tk(tmp);
    mx = max(mx, tmp);
    er[tmp]++;
  }
  for (int i = 0; i <= n - 2; ++i) {
    tk(tmp);
    er2[tmp]++;
  }
  for (typeof((er).begin()) it = (er.begin()); it != (er).end(); ++it) {
    if (it->second == er2[it->first] + 1) {
      put(it->first);
      (it->second)--;
      break;
    }
  }
  for (int i = 0; i <= n - 3; ++i) {
    tk(tmp);
    er3[tmp]++;
  }
  for (typeof((er2).begin()) it = (er2.begin()); it != (er2).end(); ++it) {
    if (it->second == er3[it->first] + 1) {
      put(it->first);
      (it->second)--;
      break;
    }
  }
  return 0;
}
