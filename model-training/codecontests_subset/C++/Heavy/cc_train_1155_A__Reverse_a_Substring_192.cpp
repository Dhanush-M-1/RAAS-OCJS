#include <bits/stdc++.h>
using namespace std;
long long int gcd(long long int a, long long int b) {
  while (b) {
    long long int x = a % b;
    a = b;
    b = x;
  }
  return a;
}
long long int lcm(long long int a, long long int b) {
  return a / gcd(a, b) * b;
}
bool isPrime(long long int n) {
  if (n <= 1) return false;
  for (long long int i = 2; i <= sqrt(n); i++)
    if (n % i == 0) return false;
  return true;
}
int setbit(int n) {
  int c;
  while (n) {
    c += n & 1;
    n >>= 1;
  }
  return c;
}
bool sortinrev(const pair<int, int> &a, const pair<int, int> &b) {
  return (a.first > b.first);
}
const int N = 300050;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int tt = 1;
  while (tt--) {
    int n;
    string s;
    cin >> n >> s;
    for (int i = 0; i < n - 1; i++) {
      if (s[i] > s[i + 1]) {
        cout << "YES"
             << "\n";
        cout << i + 1 << " " << i + 2 << "\n";
        return 0;
      }
    }
    cout << "NO";
  }
}
