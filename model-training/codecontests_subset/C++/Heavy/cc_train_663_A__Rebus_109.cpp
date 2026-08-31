#include <bits/stdc++.h>
using namespace std;
void print(long long int a[], long long int n) {
  for (long long int i = 0; i < n; i++) {
    cout << a[i] << " ";
  }
  cout << "\n";
}
long long int power(long long int x) {
  long long int u = 0;
  while (x % 2 == 0) {
    u++;
    x = x / 2;
  }
  return u;
}
long long int powM(long long int x, long long int y, long long int m) {
  if (m == 1) {
    return 0;
  }
  long long int ans = 1, r = 1;
  x %= m;
  while (r > 0 && r <= y) {
    if (r & y) {
      ans *= x;
      ans %= m;
    }
    r <<= 1;
    x *= x;
    x %= m;
  }
  return ans;
}
int powm(long long int a, long long int b) {
  long long int res = 1;
  while (b) {
    if (b & 1) res = (res * a);
    a = (a * a);
    b >>= 1;
  }
  return res;
}
long long int gcd(long long int a, long long int b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
bool isPrime(int n) {
  if (n <= 1) return false;
  if (n <= 3) return true;
  if (n % 2 == 0 || n % 3 == 0) return false;
  for (int i = 5; i * i <= n; i = i + 6)
    if (n % i == 0 || n % (i + 2) == 0) return false;
  return true;
}
unsigned int b(unsigned int n) {
  unsigned int count = 0;
  while (n) {
    count += n & 1;
    n >>= 1;
  }
  return count;
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int t1 = 1;
  long long int M = 1e9 + 7;
  while (t1--) {
    string s = "";
    char c;
    cin >> c;
    while (c != '=') {
      if (c != ' ') {
        s += c;
      }
      cin >> c;
    }
    s += c;
    long long int n;
    cin >> n;
    long long int p, m;
    p = 0;
    m = 0;
    s = '+' + s;
    long long int k = s.size();
    for (long long int i = 0; i < k; i++) {
      if (s[i] == '+') {
        p++;
      }
      if (s[i] == '-') {
        m++;
      }
    }
    long long int b;
    if (m == 0) {
      b = 1;
    } else {
      b = (p - n) / m;
      if (b <= 0) {
        b = 1;
      } else {
        if ((p - n) % m != 0) {
          b++;
        }
      }
    }
    n += (b * m);
    long long int u = n / p;
    long long int r = n % p;
    long long int o = 0;
    vector<long long int> v;
    for (long long int i = 0; i < k; i++) {
      if (o < r) {
        if (s[i] == '+') {
          v.push_back(u + 1);
          o++;
        }
        if (s[i] == '-') {
          v.push_back(b);
        }
      } else {
        if (s[i] == '+') {
          v.push_back(u);
        }
        if (s[i] == '-') {
          v.push_back(b);
        }
      }
    }
    long long int l = 1;
    n -= (b * m);
    for (long long int i = 0; i < v.size(); i++) {
      if (v[i] > n || v[i] < 1) {
        l = 0;
        break;
      }
    }
    if (!l) {
      cout << "Impossible";
    } else {
      cout << "Possible\n";
      long long int j = 0;
      for (long long int i = 1; i < k; i++) {
        if (s[i] == '?') {
          cout << v[j] << " ";
          j++;
        } else {
          cout << s[i] << " ";
        }
      }
      cout << n;
    }
  }
  return 0;
}
