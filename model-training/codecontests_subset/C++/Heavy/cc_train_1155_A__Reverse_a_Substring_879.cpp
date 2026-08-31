#include <bits/stdc++.h>
using namespace std;
long long int add(long long int a, long long int b) {
  return (a % 100000000 + b % 100000000) % 100000000;
}
long long int sub(long long int a, long long int b) {
  return (a % 100000000 - b % 100000000 + 100000000) % 100000000;
}
long long int mul(long long int a, long long int b) {
  return (a % 100000000 * b % 100000000) % 100000000;
}
long long int poww(long long int a, long long int b) {
  long long int res = 1;
  while (b) {
    if (b & 1) {
      res *= a;
    }
    a = a * a;
    b >>= 1;
  }
  return res;
}
long long int poww(long long int a, long long int b, long long int MOD) {
  long long int res = 1;
  while (b) {
    if (b & 1) {
      res *= a;
      res %= MOD;
    }
    a = a * a;
    a %= MOD;
    b >>= 1;
  }
  return res;
}
int main(int argc, char const *argv[]) {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int n;
  cin >> n;
  string s;
  cin >> s;
  string t = s;
  sort((t).begin(), (t).end());
  if (t == s) {
    cout << "NO\n";
  } else {
    for (int i = 1; i < n; i++)
      if (s[i] < s[i - 1]) {
        cout << "YES\n" << i << " " << i + 1;
        return 0;
      }
  }
  return 0;
}
