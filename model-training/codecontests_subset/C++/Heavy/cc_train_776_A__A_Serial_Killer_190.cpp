#include <bits/stdc++.h>
using namespace std;
long long int a1[1000000 + 10];
long long int b1[1000000 + 10];
long long int opp(long long int a) {
  for (int i = 63; i >= 0; i--) {
    if (a >> i & 1 == 1) {
      return i;
      break;
    }
  }
}
unsigned long long int p(int poo) {
  long long int lop = 0;
  while (poo != 0) {
    lop += poo - 1;
    poo--;
  }
  return lop;
}
long long int tav2(int p) {
  if (p == 0) {
    return 1;
  } else if (p % 2 != 0) {
    return (tav2(p - 1) * 2);
  } else {
    long long int l = tav2(p / 2);
    return (l * l);
  }
}
bool pol[1000];
int main() {
  int t1, a, b, c, d = 0, z = 0;
  string s, e;
  cin >> s >> e;
  cout << s << " " << e << endl;
  cin >> a;
  for (int i = 1; i <= a; i++) {
    string f1, f2;
    cin >> f1 >> f2;
    if (s == f1) {
      s = f2;
    } else {
      e = f2;
    }
    cout << s << " " << e << endl;
  }
}
