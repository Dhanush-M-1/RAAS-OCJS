#include <bits/stdc++.h>
using namespace std;
void __print(int x) { cerr << x; }
void __print(long x) { cerr << x; }
void __print(long long x) { cerr << x; }
void __print(unsigned x) { cerr << x; }
void __print(unsigned long x) { cerr << x; }
void __print(unsigned long long x) { cerr << x; }
void __print(float x) { cerr << x; }
void __print(double x) { cerr << x; }
void __print(long double x) { cerr << x; }
void __print(char x) { cerr << '\'' << x << '\''; }
void __print(const char *x) { cerr << '\"' << x << '\"'; }
void __print(const string &x) { cerr << '\"' << x << '\"'; }
void __print(bool x) { cerr << (x ? "true" : "false"); }
template <typename T, typename V>
void __print(const pair<T, V> &x) {
  cerr << '{';
  __print(x.first);
  cerr << ',';
  __print(x.second);
  cerr << '}';
}
template <typename T>
void __print(const T &x) {
  int f = 0;
  cerr << '{';
  for (auto &i : x) cerr << (f++ ? "," : ""), __print(i);
  cerr << "}";
}
void _print() { cerr << "]\n"; }
template <typename T, typename... V>
void _print(T t, V... v) {
  __print(t);
  if (sizeof...(v)) cerr << ", ";
  _print(v...);
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int r1, r2, c1, c2, d1, d2;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  int ans[2][2];
  for (int i = 0; i < 2; i++)
    for (int j = 0; j < 2; j++) ans[i][j] = 1;
  for (int n1 = 1; n1 <= 9; n1++) {
    for (int n2 = 1; n2 <= 9; n2++) {
      for (int n3 = 1; n3 <= 9; n3++) {
        for (int n4 = 1; n4 <= 9; n4++) {
          if (n1 + n2 == r1 && n3 + n4 == r2 && n1 + n3 == c1 &&
              n2 + n4 == c2 && n1 + n4 == d1 && n2 + n3 == d2 && n1 != n2 &&
              n1 != n3 && n1 != n4 && n2 != n3 && n2 != n4 && n3 != n4) {
            cout << n1 << " " << n2 << endl;
            cout << n3 << " " << n4 << endl;
            return 0;
          }
        }
      }
    }
  }
  cout << "-1";
  return 0;
}
