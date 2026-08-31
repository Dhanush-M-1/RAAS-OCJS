#include <bits/stdc++.h>
using namespace std;
int n;
bitset<6000> c[6000], r[6000], t;
set<int> se;
int solve(int h) {
  int w = n / h;
  for (int i = 0; i < w; i++) {
    for (int j = 1; j < h; j++) {
      if (r[i * h] != r[i * h + j]) {
        return 0;
      }
    }
  }
  for (int i = 0; i < w; i++) {
    for (int j = 1; j < h; j++) {
      if (c[i * h] != c[i * h + j]) {
        return 0;
      }
    }
  }
  return h;
}
inline int toint(char cc) {
  if (cc >= '0' && cc <= '9')
    return cc - '0';
  else
    return cc - 'A' + 10;
}
int main() {
  cin >> n;
  se.clear();
  for (int i = 1; i <= sqrt(n); i++) {
    if (!(n % i)) {
      se.insert(i);
      se.insert(n / i);
    }
  }
  for (int i = 0; i < n; i++) {
    string t;
    cin >> t;
    for (int j = 0; j < t.size(); j++) {
      int tt = toint(t[j]);
      if (tt & 1) {
        r[i].set(j * 4);
        c[j * 4 + 3].set(i);
      }
      if (tt & 2) {
        r[i].set(j * 4 + 1);
        c[j * 4 + 2].set(i);
      }
      if (tt & 4) {
        r[i].set(j * 4 + 2);
        c[j * 4 + 1].set(i);
      }
      if (tt & 8) {
        r[i].set(j * 4 + 3);
        c[j * 4].set(i);
      }
    }
  }
  int yes = 0;
  for (set<int>::reverse_iterator i = se.rbegin(); i != se.rend(); i++) {
    yes = solve(*i);
    if (yes) break;
  }
  if (yes == 0)
    cout << 1 << endl;
  else
    cout << yes << endl;
}
