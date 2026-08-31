#include <bits/stdc++.h>
using namespace std;
template <class T>
inline void mini(T &a, T b) {
  if (b < a) a = b;
}
template <class T>
inline void maxi(T &a, T b) {
  if (b > a) a = b;
}
long long x;
int main() {
  int n;
  cin >> n;
  long long fs, ss, ts;
  fs = ss = ts = 0;
  for (int i = 0; i < n; i++) {
    cin >> x;
    fs += x;
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> x;
    ss += x;
  }
  for (int i = 0; i < n - 2; i++) {
    cin >> x;
    ts += x;
  }
  cout << fs - ss << "\n" << ss - ts << endl;
  return 0;
}
