#include <bits/stdc++.h>
using namespace std;
template <class T>
inline T bigmod(T p, T e, T M) {
  long long ret = 1;
  for (; e > 0; e >>= 1) {
    if (e & 1) ret = (ret * p) % M;
    p = (p * p) % M;
  }
  return (T)ret;
}
template <class T>
inline T gcd(T a, T b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
template <class T>
inline T modinverse(T a, T M) {
  return bigmod(a, M - 2, M);
}
vector<int> vc;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  vc.push_back(0);
  string s;
  while (cin >> s) {
    if (s == "?") continue;
    if (s == "=") break;
    if (s == "+") vc.push_back(0);
    if (s == "-") vc.push_back(1);
  }
  int n;
  cin >> n;
  int pos = 0, neg = 0;
  for (int i = (0); i < (vc.size()); ++i) {
    if (vc[i] == 0)
      pos++;
    else
      neg++;
  }
  if (n > 100) {
    if (pos == 1 && neg > 0) {
      cout << "Impossible" << endl;
      return 0;
    }
    cout << "Possible" << endl;
    cout << n << " ";
    pos--;
    for (int i = (1); i < (vc.size()); ++i) {
      if (pos < neg && vc[i] == 0) {
        int v = neg - pos + 1;
        cout << "+ " << v << " ";
        pos = neg;
      } else if (vc[i] == 0) {
        cout << "+ " << 1 << " ";
      } else if (neg < pos && vc[i] == 1) {
        int v = pos - neg + 1;
        cout << "- " << v << " ";
        neg = pos;
      } else if (vc[i] == 1) {
        cout << "- " << 1 << " ";
      }
    }
    cout << "= " << n << endl;
    return 0;
  }
  for (int i = pos; i <= pos * n; i++) {
    for (int j = neg; j <= neg * n; j++) {
      if (i - j != n) continue;
      cout << "Possible" << endl;
      int c1 = 0, c2 = 0;
      for (int k = (0); k < (vc.size()); ++k) {
        if (vc[k] == 0) {
          c1++;
          int v = i / pos;
          if (c1 <= (i % pos)) v++;
          if (k != 0) cout << "+ ";
          cout << v << " ";
        } else {
          c2++;
          int v = j / neg;
          if (c2 <= (j % neg)) v++;
          cout << "- ";
          cout << v << " ";
        }
      }
      cout << "= " << n << endl;
      return 0;
    }
  }
  cout << "Impossible" << endl;
}
