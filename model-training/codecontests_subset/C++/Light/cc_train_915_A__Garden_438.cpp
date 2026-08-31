#include <bits/stdc++.h>
using namespace std;
template <typename... T>
void rd(T&... args) {
  ((cin >> args), ...);
}
template <typename... T>
void ql(T&&... args) {
  ((cout << args << ' '), ...);
}
template <typename... T>
void sd(T&&... args) {
  ((cout << args << '\n'), ...);
}
const char nl = '\n';
const int maxn = 2e5 + 17;
const int INF = 2000 * 1000 * 1000;
long long gcd(long long int a, long long int b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
long long lcm(long long a, long long b) { return (a / gcd(a, b)) * b; }
bool flase = false;
void notToday() {
  int k, n, time = INT_MAX;
  rd(n, k);
  int uh[n];
  for (int i = 0; i < int(n); ++i) rd(uh[i]);
  for (int i = 0; i < int(n); ++i) {
    if (k % uh[i] == 0 && k / uh[i] < time) time = k / uh[i];
  }
  sd(time);
}
int main(void) {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long TEST = 1;
  while (TEST--) {
    notToday();
  }
  return 0;
}
