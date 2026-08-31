#include <bits/stdc++.h>
using namespace std;
bool anagram(char *s1, char *s2) {
  long long int count[256];
  memset(count, 0, sizeof(count));
  long long int i;
  for (i = 0; s1[i] && s2[i]; i++) {
    count[s1[i]]++;
    count[s2[i]]--;
  }
  if (s1[i] || s2[i]) {
    return false;
  }
  for (long long int i = 0; i < 256; i++) {
    if (count[i]) {
      return false;
    }
  }
  return true;
}
long long int moduloMultiplication(long long int a, long long int b,
                                   long long int zz) {
  long long int res = 0;
  a %= 1000000007;
  while (b) {
    if (b & 1) res = (res + a) % zz;
    a = (2 * a) % zz;
    b >>= 1;
  }
  return res;
}
long long int convert(string s) {
  bool o = true;
  long long int ans = 0;
  for (long long int i = 0; i < s.length(); i++) {
    ans = ans * 10 + (s[i] - 48);
  }
  return ans;
}
long long int powmod(long long int a, long long int b, long long int modulo) {
  if (b == 0 || a == 1) return 1;
  long long int half = powmod(a, (b / 2), modulo) % modulo;
  long long int full = (half * half) % modulo;
  if (b % 2) return (full * a) % modulo;
  return full % modulo;
}
long long int invmod(long long int a, long long int modulo) {
  long long int check = powmod(a, modulo - 2, modulo) % modulo;
  return check;
}
long long int max(long long int a, long long int b) {
  if (a > b) {
    return a;
  }
  return b;
}
long long int min(long long int a, long long int b) {
  if (a < b) {
    return a;
  }
  return b;
}
long long int min(long long int a, long long int b, long long int c) {
  if (a < b) {
    return min(a, c);
  } else {
    return min(b, c);
  }
}
long long int max(long long int a, long long int b, long long int c) {
  if (a < b) {
    return max(b, c);
  } else {
    return min(a, c);
  }
}
long long int min(long long int a, int b) {
  if (a < b) return a;
  return b;
}
long long int min(int a, long long int b) {
  if (a < b) return a;
  return b;
}
long long int max(long long int a, int b) {
  if (a > b) return a;
  return b;
}
long long int max(int a, long long int b) {
  if (a > b) return a;
  return b;
}
long long int gcd(long long int a, long long int b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
long long int lcm(long long int a, long long int b) {
  return a / gcd(a, b) * b;
}
void yes() {
  cout << "YES"
       << "\n";
}
void no() {
  cout << "NO"
       << "\n";
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long int n, k, m, ans = 0, flag = 0, temp = 0, f1 = 0, count = 0, f2 = 0,
                         sum = 0, xx = 0, minn1 = 1e18, minn2 = 1e18,
                         maxx1 = -1e18, maxx2 = -1e18;
  cin >> n;
  long long int a[n][2];
  for (long long int i = 0; i < n; i++) {
    cin >> a[i][0] >> a[i][1];
  }
  for (long long int i = 0; i < n; i++) {
    for (long long int j = 0; j < n; j++) {
      if (a[i][0] == a[j][1]) {
        count++;
      }
    }
  }
  cout << count << "\n";
  return 0;
}
