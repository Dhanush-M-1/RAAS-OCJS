#include <bits/stdc++.h>
using namespace std;
long long int a, b;
void print(long long int a, long long int b) {
  cout << "! " << a << " " << b << endl;
}
long long int ask(long long int c, long long int d) {
  cout << "? " << c << " " << d << endl;
  long long int ret;
  cin >> ret;
  return ret;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  long long int ret = ask(0, 0);
  if (ret == 0) {
    long long int val = 0;
    for (long long int i = 0; i <= 29; ++i) {
      long long int rr = ask(0, (1LL << i));
      if (rr == 1) val += (1LL << i);
    }
    print(val, val);
    return 0;
  }
  long long int sa = 0, sb = 0, va = 0, vb = 0;
  for (long long int i = 29; i >= 0; i--) {
    long long int rr = ask(sa + (1LL << i), sb + (1LL << i));
    if (rr == ret) {
      if (ret == 1) {
        long long int cc = ask(sa + (1LL << i), sb);
        if (cc == -1) {
          va += (1LL << i);
          vb += (1LL << i);
        }
      } else {
        long long int cc = ask(sa, sb + (1LL << i));
        if (cc == 1) {
          va += (1LL << i);
          vb += (1LL << i);
        }
      }
      continue;
    }
    if (ret == 1) {
      va += (1LL << i);
      sa += (1LL << i);
    } else {
      vb += (1LL << i);
      sb += (1LL << i);
    }
    if (!i) break;
    rr = ask(sa, sb);
    if (rr == 0) {
      long long int val = 0;
      for (long long int j = 0; j <= i - 1; ++j) {
        long long int rr = ask(sa, sb + (1LL << j));
        if (rr == 1) val += (1LL << j);
      }
      va += val;
      vb += val;
      break;
    } else
      ret = rr;
  }
  print(va, vb);
}
