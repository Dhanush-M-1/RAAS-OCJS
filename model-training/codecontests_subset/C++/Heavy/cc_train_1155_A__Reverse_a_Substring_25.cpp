#include <bits/stdc++.h>
using namespace std;
inline long long int read() {
  char c = getchar();
  long long int num, sign = 1;
  for (; c < '0' || c > '9'; c = getchar())
    if (c == '-') sign = -1;
  for (num = 0; c >= '0' && c <= '9';) {
    c -= '0';
    num = num * 10 + c;
    c = getchar();
  }
  return num * sign;
}
inline long long int pow(long long int b, long long int p) {
  long long int ans = 1;
  while (p > 0) ans = ans << b, p--;
  return ans;
}
inline bool isPrime(long long int n) {
  if (!(n % 2)) return false;
  for (long long int i = 3; i <= sqrt(n); i += 2)
    if (!(n % i)) return false;
  return true;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n;
  string str;
  cin >> n >> str;
  for (int i = 0; i < n - 1; i++) {
    if (str[i] > str[i + 1]) {
      cout << "YES" << endl;
      cout << i + 1 << " " << i + 2;
      return 0;
    }
  }
  cout << "NO" << endl;
  return 0;
}
