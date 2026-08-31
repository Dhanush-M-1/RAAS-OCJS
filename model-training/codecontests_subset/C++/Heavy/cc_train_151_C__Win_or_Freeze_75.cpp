#include <bits/stdc++.h>
using namespace std;
void RD(int &x) { scanf("%d", &x); }
void RD(long long &x) { scanf("%I64d", &x); }
void RD(double &x) { scanf("%lf", &x); }
void RD(int &x, int &y) { scanf("%d%d", &x, &y); }
void RD(long long &x, long long &y) { scanf("%I64d%I64d", &x, &y); }
void RD(double &x, double &y) { scanf("%lf%lf", &x, &y); }
void RD(char *s) { scanf("%s", s); }
void RD(char &s) { scanf("%c", &s); }
void RD(string &s) { cin >> s; }
void PR(int x) { printf("%d\n", x); }
void PR(int x, int y) { printf("%d %d\n", x, y); }
void PR(long long x) { printf("%I64d\n", x); }
void PR(char x) { printf("%c\n", x); }
void PR(char *x) { printf("%s\n", x); }
void PR(string x) { cout << x << endl; }
const long long inf = 1;
const long long mod = 1LL;
long long solve(long long n) {
  long long i;
  for (i = 2; i * i < n; i++) {
    if (n % i == 0) {
      return solve(i);
    }
  }
  if (i * i == n) return solve(i);
  return n;
}
int main() {
  long long q, i;
  vector<long long> v;
  while (scanf("%I64d", &q) == 1) {
    (v.clear());
    for (i = 2; i * i < q; i++) {
      if (q % i == 0) {
        v.push_back(solve(i));
        v.push_back(solve(q / i));
        break;
      }
    }
    if (i * i == q) {
      v.push_back(solve(i));
      v.push_back(solve(i));
    }
    if ((int)v.size() == 0)
      printf("1\n0\n");
    else if (v[0] * v[1] < q)
      printf("1\n%I64d\n", v[0] * v[1]);
    else
      printf("2\n");
  }
  return 0;
}
