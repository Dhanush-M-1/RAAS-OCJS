#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native")
using namespace std;
string to_string(string s) { return '"' + s + '"'; }
string to_string(const char *s) { return to_string((string)s); }
string to_string(bool b) { return (b ? "true" : "false"); }
template <typename A, typename B>
string to_string(pair<A, B> p) {
  return "(" + to_string(p.first) + ", " + to_string(p.second) + ")";
}
template <typename A>
string to_string(A v) {
  bool first = true;
  string res = "{";
  for (const auto &x : v) {
    if (!first) {
      res += ", ";
    }
    first = false;
    res += to_string(x);
  }
  res += "}";
  return res;
}
void debug_out() { cerr << endl; }
template <typename Head, typename... Tail>
void debug_out(Head H, Tail... T) {
  cerr << " " << to_string(H);
  debug_out(T...);
}
long long mod_1097(long long a) {
  long long mod_a;
  if (a > 1000000007) {
    mod_a = a % 1000000007;
  } else {
    mod_a = a;
  }
  return mod_a;
}
vector<long long> get_primes(long long n) {
  vector<long long> primes = {};
  vector<long long> nums(n, 0);
  for (long long i = 2; i < n; i++) {
    if (nums[i] == 0) {
      primes.push_back(i);
      for (long long j = i * 2; j < n; j += i) {
        nums[j] = i;
      }
    }
  }
  return primes;
}
vector<long long> sieve(long long n) {
  vector<long long> res(n + 1, 0);
  res[n] = n;
  for (int i = 2; i < pow(n, 1 / 2); i++) {
    long long shuttle = i * i;
    while (shuttle < n) {
      res[shuttle] = i;
      shuttle += i;
    }
  }
  return res;
}
long long ceil_(long long a, long long b) {
  if (a % b == 0) {
    return a / b;
  } else {
    return a / b + 1;
  }
}
long long gcd(long long a, long long b) {
  for (;;) {
    if (a == 0) return b;
    b %= a;
    if (b == 0) return a;
    a %= b;
  }
}
long long lcm(long long a, long long b) {
  long long temp = gcd(a, b);
  return temp ? (a / temp * b) : 0;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  long long n;
  cin >> n;
  string s;
  cin >> s;
  int max_c = s[0] - 'a';
  int max_c_pos = 0;
  for (int i = 1; i < n; i++) {
    ;
    ;
    if ((s[i] - 'a') < max_c) {
      cout << "YES" << endl;
      cout << max_c_pos + 1 << " " << i + 1 << endl;
      return 0;
    } else {
      max_c = s[i] - 'a';
      max_c_pos = i;
    }
  }
  cout << "NO" << endl;
  cout << endl;
  return 0;
}
