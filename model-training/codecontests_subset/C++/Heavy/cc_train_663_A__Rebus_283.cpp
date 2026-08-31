#include <bits/stdc++.h>
using namespace std;
long long sigma(long long n) { return (n * (n + 1) / 2); }
long long MOD(long long x) {
  if (x >= 0) return x;
  return (-x);
}
bool great(long long a, long long b) { return a > b; }
bool p_sm(pair<long long, long long> a, pair<long long, long long> b) {
  if (a.first == b.first) {
    return (a.second < b.second);
  }
  return (a.first < b.first);
}
long long max3(long long a, long long b, long long c) {
  return (max(a, max(b, c)));
}
long long max4(long long a, long long b, long long c, long long d) {
  return (max(max(a, b), max(c, d)));
}
long long min3(long long a, long long b, long long c) {
  return (min(a, min(b, c)));
}
long long min4(long long a, long long b, long long c, long long d) {
  return (min(min(a, b), min(c, d)));
}
vector<long long> factors(long long x) {
  vector<long long> v;
  for (long long i = 2; i * i <= x; i++) {
    if (x % i == 0) {
      v.push_back(i);
      if (i != x / i) {
        v.push_back(x / i);
      }
    }
  }
  return v;
}
vector<long long> ispr;
vector<long long> min_prime;
unordered_map<long long, long long> prime_fact(long long x) {
  unordered_map<long long, long long> mp;
  while (x != 1) {
    mp[min_prime[x]]++;
    x /= min_prime[x];
  }
  return mp;
}
map<long long, long long> factorizee(long long n) {
  map<long long, long long> mp;
  for (long long i = 2; i * i <= n; ++i) {
    while (n % i == 0) {
      mp[i]++;
      n /= i;
    }
  }
  if (n != 1) {
    mp[n]++;
  }
  return mp;
}
long long power(long long a, long long b, long long m) {
  long long ans = 1;
  while (b > 0) {
    if (b % 2) {
      ans = (ans * a) % m;
    }
    a = (a * a) % m;
    b = b / 2;
  }
  return ans;
}
int main() {
  string s;
  getline(cin, s);
  long long xx;
  string ss = "";
  long long po, ne, to;
  po = ne = to = 0;
  for (long long i = 0; i < s.size(); i++) {
    if (s[i] == ' ' || s[i] == '+') {
      continue;
    } else if (s[i] == '?') {
      to++;
    } else if (s[i] == '-') {
      ne++;
    } else if (s[i] != '=') {
      for (long long j = i; j < s.size(); j++) {
        ss += s[j];
      }
      break;
    }
  }
  po = to - ne;
  xx = stoll(ss);
  long long jj = xx + ne;
  if ((po * xx) < jj) {
    cout << "Impossible" << endl;
    exit(0);
    ;
  }
  long long n[ne];
  for (int i = 0; i < ne; i++) {
    n[i] = 0;
  };
  long long ns = -1;
  if (po > jj) {
    for (long long i = 1; i < 100000004; i++) {
      if (ne < i) {
        if ((ne * xx) >= i) {
          if ((i + xx) <= (xx * po)) {
            if ((xx * po) <= ((i + xx) * xx)) {
              ns = i;
            }
          }
        }
      }
    }
    if (ns == -1) {
      cout << "Impossible" << endl;
      exit(0);
      ;
    }
    long long ii = 0;
    long long i = 0;
    while (ii < ns) {
      n[i++]++;
      ii++;
      i %= ne;
    }
  } else {
    ns = ne;
    for (long long i = 0; i < ne; i++) {
      n[i] = 1;
    }
  }
  long long p[po];
  for (int i = 0; i < po; i++) {
    p[i] = 0;
  };
  long long ii = 0;
  long long i = 0;
  jj = xx + ns;
  while (ii < jj) {
    p[i++]++;
    i %= po;
    ii++;
  }
  long long ju = 0;
  char lc = '+';
  long long jk = 0;
  cout << "Possible" << endl;
  for (long long i = 0; i < s.size(); i++) {
    if (s[i] == '?') {
      if (lc == '+') {
        cout << p[ju++];
      } else {
        cout << n[jk++];
      }
    } else {
      cout << s[i];
    }
    if (s[i] == '+' || s[i] == '-') {
      lc = s[i];
    }
  }
}
