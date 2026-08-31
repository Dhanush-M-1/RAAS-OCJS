#include <bits/stdc++.h>
const double PI = 3.141592653589793238460;
using namespace std;
long long pows(long long a, long long n, long long m) {
  a = a % 1000000007;
  long long res = 1;
  while (n) {
    if (n % 2 != 0) {
      res = (res * a) % m;
      n--;
    } else {
      a = (a * a) % m;
      n = n / 2;
    }
  }
  return res % m;
}
long long gcd(long long a, long long b) {
  if (b == 0)
    return a;
  else
    return gcd(b, a % b);
}
bool isprime(long long n) {
  if (n == 1) {
    return false;
  }
  for (long long i = 2; i * i <= n; i++) {
    if (n % i == 0) {
      return false;
    }
  }
  return true;
}
bool istrue(string s) {
  int i = 0;
  int j = s.size() - 1;
  while (i < j) {
    if (s[i] == s[j]) {
      i++;
      j--;
    } else {
      return false;
    }
  }
  return true;
}
int n, m;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> m;
  vector<int> ar[n + 1];
  vector<int> a(n);
  vector<int> good(n + 1);
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }
  int x, y;
  for (int i = 0; i < m; i++) {
    cin >> x >> y;
    ar[x].push_back(y);
    if (y == a[n - 1]) {
      good[x] = true;
    }
  }
  int ans = 0;
  set<int> s;
  for (int i = n - 2; i >= 0; i--) {
    if (good[a[i]] == false) {
      s.insert(a[i]);
    } else {
      int cnt = 0;
      for (int val : ar[a[i]]) {
        if (s.count(val)) {
          cnt++;
        }
      }
      if (cnt == s.size()) {
        ans++;
      } else {
        s.insert(a[i]);
      }
    }
  }
  cout << ans << endl;
}
