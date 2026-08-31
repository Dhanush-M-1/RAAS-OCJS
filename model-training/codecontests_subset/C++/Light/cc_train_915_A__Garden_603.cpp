#include <bits/stdc++.h>
using namespace std;
bool isPrime(long long n) {
  if (n <= 1) return false;
  for (long long i = 2; i < n; i++)
    if (n % i == 0) return false;
  return true;
}
long long isPalindrome(string str) {
  long long l = 0;
  long long h = str.length() - 1;
  while (h > l) {
    if (str[l++] != str[h--]) {
      return -1;
    }
  }
  return 1;
}
bool is_vowel(char c) {
  if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'y')
    return true;
  return false;
}
long long gcd(long long a, long long b) {
  for (long long i = min(a, b); i > 0; i--) {
    if (max(a, b) % i == 0 && min(a, b) % i == 0) {
      return i;
    }
  }
  return -1;
}
int32_t main() {
  long long n, k;
  cin >> n >> k;
  ;
  long long A[n];
  long long ans = -1;
  for (long long i = 0; i < n; i++) {
    cin >> A[i];
    if (k % A[i] == 0) {
      ans = max(ans, A[i]);
    }
  }
  cout << k / ans << endl;
  ;
}
