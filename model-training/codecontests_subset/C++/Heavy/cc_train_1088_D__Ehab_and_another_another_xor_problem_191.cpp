#include <bits/stdc++.h>
using namespace std;
template <class A>
void pr(A a) {
  cout << a;
  cout << endl;
}
template <class A, class B>
void pr(A a, B b) {
  cout << a << ' ';
  pr(b);
}
template <class A, class B, class C>
void pr(A a, B b, C c) {
  cout << a << ' ';
  pr(b, c);
}
template <class A, class B, class C, class D>
void pr(A a, B b, C c, D d) {
  cout << a << ' ';
  pr(b, c, d);
}
template <class A>
void PR(A a, long long n) {
  for (long long i = (long long)(0); i < (long long)(n); i++) {
    if (i) cout << ' ';
    cout << a[i];
  }
  cout << endl;
}
long long check(long long n, long long m, long long x, long long y) {
  return x >= 0 && x < n && y >= 0 && y < m;
}
const long long MAX = 1e9 + 7, MAXL = 1LL << 61, dx[4] = {-1, 0, 1, 0},
                dy[4] = {0, 1, 0, -1};
void Main() {
  long long x = 0, y = 0, a, b, c;
  pr('?', x, y);
  cin >> a;
  for (long long i = (long long)(30) - 1; i >= 0; i--) {
    pr('?', x | (1 << i), y);
    cin >> b;
    if (!a) {
      if (b < 0) {
        x |= 1 << i;
        y |= 1 << i;
      }
    } else if (a > 0) {
      if (!b) {
        x |= 1 << i;
        a = b;
      } else if (b < 0) {
        pr('?', x, y | (1 << i));
        cin >> c;
        x |= 1 << i;
        if (b != c)
          y |= 1 << i;
        else
          a = b;
      } else {
        pr('?', x, y | (1 << i));
        cin >> c;
        if (b == c) {
          x |= 1 << i;
          a = b;
        }
      }
    } else {
      if (!b) {
        y |= 1 << i;
        a = b;
      } else if (b > 0) {
        pr('?', x, y | (1 << i));
        cin >> c;
        if (b == c) {
          y |= 1 << i;
          a = c;
        }
      } else {
        pr('?', x, y | (1 << i));
        cin >> c;
        y |= 1 << i;
        if (b != c)
          x |= 1 << i;
        else
          a = c;
      }
    }
  }
  pr('!', x, y);
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  Main();
  return 0;
}
