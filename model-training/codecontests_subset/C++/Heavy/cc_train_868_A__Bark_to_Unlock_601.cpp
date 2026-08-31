#include <bits/stdc++.h>
using namespace std;
inline void scd(int &a) { scanf("%d", &a); }
inline void scdd(int &a, int &b) { scanf("%d %d", &a, &b); }
inline void sctd(int &a, int &b, int &c) { scanf("%d %d %d", &a, &b, &c); }
inline void sctlld(long long int &a, long long int &b, long long int &c) {
  scanf("%I64d %I64d %I64d", &a, &b, &c);
}
inline void scdlld(long long int &a, long long int &b) {
  scanf("%I64d %I64d", &a, &b);
}
inline void sclld(long long int &a) { scanf("%I64d", &a); }
inline void scllu(unsigned long long int &a) { scanf("%I64u", &a); }
inline void scdllu(unsigned long long int &a, unsigned long long int &b) {
  scanf("%I64u %I64u", &a, &b);
}
inline void sctllu(unsigned long long int &a, unsigned long long int &b,
                   unsigned long long int &c) {
  scanf("%I64u %I64u %I64u", &a, &b, &c);
}
template <class Ver>
inline void prd(Ver a) {
  cout << a << "\n";
};
template <class Ver>
inline void prdd(Ver a, Ver b) {
  cout << a << " " << b << "\n";
};
template <class Ver>
inline void prtd(Ver a, Ver b, Ver c) {
  cout << a << " " << b << " " << c << "\n";
};
inline void debug() { printf("asd\n"); }
template <class Ver>
inline void debugd(Ver a) {
  cout << "--- " << a << endl;
};
template <class Ver>
inline void debugdd(Ver a, Ver b) {
  cout << "--- " << a << " " << b << endl;
};
template <class Ver>
inline void debugtd(Ver a, Ver b, Ver c) {
  cout << "--- " << a << " " << b << " " << c << endl;
};
void st() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
}
int main() {
  st();
  int ver = 0, niy = 0, hbk = 0;
  string a;
  cin >> a;
  cin >> hbk;
  string b[200];
  string c = "";
  for (int i = 0; i < hbk; ++i) {
    cin >> b[i];
  }
  for (int i = 0; i < hbk; ++i) {
    for (int j = hbk - 1; j >= i; --j) {
      c += b[i];
      c += b[j];
    }
  }
  for (int j = hbk - 1; j >= 0; --j) {
    for (int i = 0; i < j; ++i) {
      c += b[j];
      c += b[i];
    }
  }
  size_t d = c.find(a);
  if (d != string::npos)
    prd("YES");
  else
    prd("NO");
  return 0;
}
