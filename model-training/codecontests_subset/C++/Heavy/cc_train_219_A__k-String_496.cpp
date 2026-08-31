#include <bits/stdc++.h>
const long long inf = 1000000000000000000;
using namespace std;
long long gcd(long long a, long long b) {
  if (a < b) gcd(b, a);
  if (b == 0) return a;
  return gcd(b, a % b);
}
long long lcm(long long a, long long b) {
  long long x = (a / gcd(a, b)) * b;
  return x;
}
long long power(long long x, long long n, long long m = inf) {
  if (x == 0) {
    return 0;
  }
  if (n == 0) {
    return 1;
  }
  long long ans;
  if (n % 2 == 0) {
    long long smallAns = power(x, n / 2, m);
    ans = (smallAns * smallAns) % m;
  } else {
    long long smallAns = power(x, n - 1, m);
    ans = x;
    ans = (ans * smallAns) % m;
  }
  return (ans + m) % m;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t = 1;
  while (t--) {
    int k;
    cin >> k;
    string s;
    cin >> s;
    int arr[26];
    for (int i = 0; i < 26; i += 1) {
      arr[i] = 0;
    }
    int n = s.length();
    for (int i = 0; i < n; i += 1) {
      arr[s[i] - 'a']++;
    }
    for (int i = 0; i < 26; i += 1) {
      if (arr[i] % k != 0) {
        cout << -1 << '\n';
        return 0;
      }
    }
    string ab;
    for (int i = 0; i < 26; i += 1) {
      int val = arr[i] / k;
      for (int j = 0; j < val; j += 1) {
        ab += (char)(i + 'a');
      }
    }
    for (int i = 0; i < k; i += 1) cout << ab;
    cout << '\n';
  }
  return 0;
}
