#include <bits/stdc++.h>
using namespace std;
long long max(long long a, long long b) {
  if (a >= b)
    return a;
  else
    return b;
}
long long min(long long a, long long b) {
  if (a <= b)
    return a;
  else
    return b;
}
long long diff(long long a, long long b) {
  if (a >= b)
    return a - b;
  else
    return b - a;
}
long long isPrime(long long n) {
  if (n < 2) return 0;
  if (n < 4) return 1;
  if (n % 2 == 0 or n % 3 == 0) return 0;
  for (long long i = 5; i * i <= n; i += 6)
    if (n % i == 0 or n % (i + 2) == 0) return 0;
  return 1;
}
long long gcd(long long a, long long b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
void sort(long long arr[], long long n) {
  for (long long i = 0; i <= n; i++) {
    for (long long j = i; j <= n; j++) {
      if (arr[i] > arr[j]) {
        long long t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
      }
    }
  }
}
long long modd(long long n, long long m) {
  if (n - m > 0) {
    return n - m;
  } else {
    return m - n;
  }
}
long long mod(long long n) {
  if (n >= 0) {
    return n;
  } else {
    return -n;
  }
}
long long isperfectsquare(long long n) {
  long long k = sqrt(n);
  if (n % k == 0 && n / k == k) {
    return 1;
  } else {
    return 0;
  }
}
vector<long long> q;
vector<long long> v[500005];
map<long long, long long> ct;
long long vis[500005];
long long cnt = 1;
void dfs(long long x) {
  vis[x] = cnt;
  for (long long i = 0; i < v[x].size(); i++) {
    if (vis[v[x][i]] == 0) {
      dfs(v[x][i]);
    }
  }
}
void pairsort(long long a[], long long b[], long long n) {
  pair<long long, long long> pairt[n];
  for (long long i = 0; i < n; i++) {
    pairt[i].first = a[i];
    pairt[i].second = b[i];
  }
  sort(pairt, pairt + n);
  for (long long i = 0; i < n; i++) {
    a[i] = pairt[i].first;
    b[i] = pairt[i].second;
  }
}
long long ispalindrome(string s) {
  long long palindrome = 1;
  long long n = s.length();
  for (long long i = 0; i < (n / 2); i++) {
    if (s[i] != s[n - 1 - i]) {
      palindrome = 0;
      break;
    }
  }
  return palindrome;
}
int32_t main() {
  string p;
  cin >> p;
  long long n;
  cin >> n;
  string s[n];
  long long done = 0;
  for (long long i = 0; i < n; i++) {
    cin >> s[i];
    if (s[i] == p) {
      done = 1;
    }
  }
  long long d1 = 0, d2 = 0;
  if (done == 0) {
    for (long long i = 0; i < n; i++) {
      if (s[i][0] == p[1]) {
        d1++;
      }
      if (s[i][1] == p[0]) {
        d2++;
      }
    }
  }
  if (d1 != 0 && d2 != 0) {
    done = 1;
  }
  if (done == 1) {
    cout << "YES";
  } else {
    cout << "NO";
  }
  return 0;
}
