#include <bits/stdc++.h>
using namespace std;
template <class T>
inline void smax(T &x, T y) {
  x = max((x), (y));
}
template <class T>
inline void smin(T &x, T y) {
  x = min((x), (y));
}
inline void sc(int &x) {
  bool f = 0;
  x = 0;
  char c = getchar();
  while ((c < '0' || c > '9') && c != '-') c = getchar();
  if (c == '-') {
    f = 1;
    c = getchar();
  }
  while (c >= '0' && c <= '9') {
    x = x * 10 + c - '0';
    c = getchar();
  }
  if (f) x = -x;
  return;
}
void sc(char &x) { scanf("%c", &x); }
void sc(int &x, int &y) {
  sc(x);
  return sc(y);
}
void sc(int &x, int &y, int &z) {
  sc(x);
  sc(y);
  return sc(z);
}
const double eps = 1e-7;
int n, k;
char str[2000005];
int main() {
  std::ios::sync_with_stdio(false);
  char c;
  vector<char> inp;
  cin >> c;
  cin >> c;
  inp.push_back('+');
  while (c != '=') {
    inp.push_back(c);
    cin >> c;
    cin >> c;
  }
  cin >> n;
  if (count((inp).begin(), (inp).end(), '+') >
          (count((inp).begin(), (inp).end(), '-') + 1) * n ||
      count((inp).begin(), (inp).end(), '-') >
          (count((inp).begin(), (inp).end(), '+') - 1) * n) {
    cout << "Impossible\n" << endl;
    return 0;
  }
  int full = 0, rem = 0;
  int sum = n - count((inp).begin(), (inp).end(), '+') +
            count((inp).begin(), (inp).end(), '-');
  cout << "Possible\n";
  ;
  if (sum >= 0) {
    full = sum / count((inp).begin(), (inp).end(), '+');
    rem = sum % count((inp).begin(), (inp).end(), '+');
    ;
    cout << (rem > 0 ? rem--, full + 2 : full + 1);
    for (int i = 1; i < int((inp).size()); i++) {
      if (inp[i] == '+')
        cout << " + " << (rem > 0 ? rem--, full + 2 : full + 1);
      else
        cout << " - " << 1;
    }
    cout << " = " << n << endl;
  } else {
    full = sum / count((inp).begin(), (inp).end(), '-');
    rem = abs(sum % count((inp).begin(), (inp).end(), '-'));
    ;
    cout << 1;
    for (int i = 1; i < int((inp).size()); i++) {
      if (inp[i] == '-')
        cout << " - " << (rem > 0 ? rem--, -(full - 2) : -(full - 1));
      else
        cout << " + " << 1;
    }
    cout << " = " << n << endl;
  }
  return 0;
}
