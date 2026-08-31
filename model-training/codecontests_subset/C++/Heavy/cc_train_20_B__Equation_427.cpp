#include <bits/stdc++.h>
using namespace std;
const long double EPS = (long double)1e-7;
const long double PI = acos(0) * 2;
bool isZero(const long double& x) { return abs(x) <= EPS; }
int sign(const long double& x) { return isZero(x) ? 0 : (0 < x ? 1 : -1); }
long long gcd(long long a, long long b) {
  for (; b; a %= b, swap(a, b)) {
  }
  return abs(a);
}
pair<long long, long long> operator+(const pair<long long, long long>& a,
                                     const pair<long long, long long>& b) {
  return pair<long long, long long>(a.first + b.first, a.second + b.second);
}
pair<long long, long long> operator-(const pair<long long, long long>& a,
                                     const pair<long long, long long>& b) {
  return pair<long long, long long>(a.first - b.first, a.second - b.second);
}
pair<long long, long long> operator*(const pair<long long, long long>& a,
                                     const long long& b) {
  return pair<long long, long long>(a.first * b, a.second * b);
}
long long operator*(const pair<long long, long long>& a,
                    const pair<long long, long long>& b) {
  return a.first * b.second - b.first * a.second;
}
long long ccw(const pair<long long, long long>& a,
              const pair<long long, long long>& b,
              const pair<long long, long long>& c) {
  return a * b + b * c + c * a;
}
void fg(vector<int> G[], int a, int b) {
  G[a].emplace_back(b);
  G[b].emplace_back(a);
}
void fg(vector<pair<int, int> > G[], int a, int b, int c) {
  G[a].emplace_back(b, c);
  G[b].emplace_back(a, c);
}
long long A, B, C;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin >> A >> B >> C;
  if (!A && !B) {
    puts(C ? "0" : "-1");
    exit(0);
  }
  if (!A) {
    printf("1\n%.10lf\n", double(-C) / B);
    exit(0);
  }
  long long D = B * B - 4 * A * C;
  if (D < 0) {
    puts("0");
    exit(0);
  }
  if (!D) {
    printf("1\n%.10lf\n", double(-B) / A / 2);
    exit(0);
  }
  if (A < 0) {
    A = -A;
    B = -B;
    C = -C;
  }
  printf("2\n%.10lf\n%.10lf\n", double(-B - sqrt(D)) / A / 2,
         double(-B + sqrt(D)) / A / 2);
  return 0;
}
