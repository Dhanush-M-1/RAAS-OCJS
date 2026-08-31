#include <bits/stdc++.h>
const long double PI = acos(-1.0);
using namespace std;
struct Po {
  long long Old, New;
  Po(long long O = 0, long long E = 0) : Old(O), New(E) {}
  inline Po operator+(const Po& x) {
    Po tem;
    tem.Old = this->Old + x.Old;
    tem.New = this->New + x.New;
    return tem;
  }
  inline Po& operator+=(const Po& x) {
    this->New += x.New;
    this->Old += x.Old;
    return *this;
  }
};
Po T[8 * (200000 + 100)];
long long tt[(200000 + 100)];
int E;
int a, b;
void init(int n) {
  E = 1;
  while (E <= n + 1) E <<= 1;
  memset(T, 0, sizeof(T));
  memset(tt, 0, sizeof(tt));
}
void Push_up(int t) { T[t] = T[t << 1] + T[t << 1 | 1]; }
void aP(int k1, int k2) {
  k1 += E;
  if (k2 < a)
    T[k1].New = k2;
  else
    T[k1].New = a;
  if (k2 < b)
    T[k1].Old = k2;
  else
    T[k1].Old = b;
  for (k1 >>= 1; k1; k1 >>= 1) Push_up(k1);
}
long long query(int L, int R, int p) {
  Po sum;
  for (L += E - 1, R += E + 1; L ^ R ^ 1; L >>= 1, R >>= 1) {
    if (~L & 1) sum += T[L ^ 1];
    if (R & 1) sum += T[R ^ 1];
  }
  if (p == 1)
    return sum.Old;
  else
    return sum.New;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  int n, k, q;
  cin >> n >> k >> a >> b >> q;
  int i, p;
  init(n);
  for (i = 1; i <= q; i++) {
    cin >> p;
    if (p == 1) {
      int k1, k2;
      cin >> k1 >> k2;
      tt[k1] += k2;
      aP(k1, tt[k1]);
    } else {
      int k1;
      cin >> k1;
      long long sum = query(1, k1 - 1, 1) + query(k1 + k, n, 2);
      cout << sum << endl;
    }
  }
  return 0;
}
