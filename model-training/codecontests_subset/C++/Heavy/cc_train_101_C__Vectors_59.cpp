#include <bits/stdc++.h>
using namespace std;
const long long int INF = (long long int)1e9 + 10;
const long long int INFLL = (long long int)1e18 + 10;
const long double EPS = 1e-8;
const long double EPSLD = 1e-18;
const long long int MOD = 1e9 + 7;
template <class T>
T &chmin(T &a, const T &b) {
  return a = min(a, b);
}
template <class T>
T &chmax(T &a, const T &b) {
  return a = max(a, b);
}
long long int ax, ay, bx, by, bxa, bya, bxb, byb;
bool check(long long int arx, long long int ary) {
  long long int tx = bx - arx;
  long long int ty = by - ary;
  if (bxa == 0 && bya == 0) return tx == 0 && ty == 0;
  long long int dor = bxa * byb - bxb * bya;
  assert(dor != 0);
  long long int nx = byb * tx - bxb * ty;
  long long int ny = -bya * tx + bxa * ty;
  return nx % dor == 0 && ny % dor == 0;
}
int main() {
  scanf("%lld %lld", &ax, &ay);
  scanf("%lld %lld", &bx, &by);
  scanf("%lld %lld", &bxa, &bya);
  bxb = -bya;
  byb = bxa;
  if (check(ax, ay) || check(-ax, -ay) || check(ay, -ax) || check(-ay, ax))
    puts("YES");
  else
    puts("NO");
  return 0;
}
