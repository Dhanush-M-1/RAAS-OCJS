#include <bits/stdc++.h>
using namespace std;
const long long int mod = 1000000007LL;
const long long int big = 2.19e15 + 1;
const long double pai = 3.141592653589793238462643383279502884197;
const long double eps = 1e-15;
template <class T, class U>
void mineq(T& a, U b) {
  if (a > b) {
    a = b;
  }
}
template <class T, class U>
void maxeq(T& a, U b) {
  if (a < b) {
    a = b;
  }
}
long long int gcd(long long int a, long long int b) {
  if (a % b == 0) {
    return b;
  } else
    return gcd(b, a % b);
}
long long int lcm(long long int a, long long int b) {
  return a / gcd(a, b) * b;
}
template <class T>
void SO(T& ve) {
  sort(ve.begin(), ve.end());
}
template <class T>
void REV(T& ve) {
  reverse(ve.begin(), ve.end());
}
long long int LBI(vector<int>& ar, int in) {
  return lower_bound(ar.begin(), ar.end(), in) - ar.begin();
}
long long int UBI(vector<int>& ar, int in) {
  return upper_bound(ar.begin(), ar.end(), in) - ar.begin();
}
int main(void) {
  cin.tie(0);
  ios::sync_with_stdio(false);
  int i, h, n, m, K;
  cin >> n >> m >> K;
  vector<int> doco(n);
  for (i = 0; i < n; i++) {
    doco[i] = i;
  }
  for (i = 0; i < m; i++) {
    int s;
    cin >> s;
    if (s == 0) {
      cout << "-1" << endl;
      return 0;
    }
    doco[s] = doco[s - 1];
  }
  long long int ans = big;
  for (h = 1; h <= K; h++) {
    long long int gen = 1, bas = 0;
    while (bas + h < n) {
      if (doco[bas + h] == bas) {
        gen = big;
        break;
      }
      bas = doco[bas + h];
      gen++;
    }
    long long int a;
    cin >> a;
    if (gen > n) {
      continue;
    }
    mineq(ans, gen * a);
  }
  if (ans == big) {
    ans = -1;
  }
  cout << ans << endl;
  return 0;
}
