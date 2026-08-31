#include <bits/stdc++.h>
using namespace std;
struct BigNum {
  vector<long long> value;
  void set(long long x) {
    value = *(new vector<long long>);
    value.push_back(x);
  }
  void duplicate(BigNum other) { value = other.value; }
  void add(BigNum other) {
    vector<long long> o = other.value;
    if (o.size() > value.size()) {
      vector<long long> t = value;
      value = o;
      o = t;
    }
    for (int i = 0; i < o.size(); i += 1) {
      value[i] += o[i];
      if (i < value.size() - 1 && value[i] >= (long long)1e9) {
        value[i + 1] += value[i] / (long long)1e9;
        value[i] = value[i] % (long long)1e9;
      }
    }
    if (value.back() >= (long long)1e9) {
      value.push_back(value.back() / (long long)1e9);
      value[value.size() - 2] = value[value.size() - 2] % (long long)1e9;
    }
  }
  void mul(long long mul) {
    for (int i = 0; i < value.size(); i += 1) {
      value[i] *= mul;
    }
    for (int i = 0; i < value.size() - 1; i += 1) {
      if (value[i] >= (long long)1e9) {
        value[i + 1] += value[i] / (long long)1e9;
        value[i] = value[i] % (long long)1e9;
      }
    }
    if (value.back() >= (long long)1e9) {
      value.push_back(value.back() / (long long)1e9);
      value[value.size() - 2] = value[value.size() - 2] % (long long)1e9;
    }
  }
  long double div(BigNum other1, BigNum other2) {
    int s = value.size();
    long double current = value.back();
    if (s >= 2) {
      current += ((long double)value[s - 2]) / (long long)1e9;
    }
    if (s >= 3) {
      current +=
          ((long double)value[s - 3]) / ((long long)1e9 * (long long)1e9);
    }
    int s1 = other1.value.size();
    int s2 = other2.value.size();
    long double other = 0;
    if (s1 + s2 - 1 == s) {
      other += other1.value.back() * other2.value.back();
      if (s1 >= 2) {
        other += ((long double)other1.value[s1 - 2] * other2.value.back()) /
                 (long long)1e9;
      }
      if (s2 >= 2) {
        other += ((long double)other2.value[s2 - 2] * other1.value.back()) /
                 (long long)1e9;
      }
      if (s1 >= 3) {
        other += ((long double)other1.value[s1 - 3] * other2.value.back()) /
                 ((long long)1e9 * (long long)1e9);
      }
      if (s2 >= 3) {
        other += ((long double)other2.value[s2 - 3] * other1.value.back()) /
                 ((long long)1e9 * (long long)1e9);
      }
    }
    if (s1 + s2 - 1 == s - 1) {
      other += other1.value.back() * other2.value.back();
      if (s1 >= 2) {
        other += ((long double)other1.value[s1 - 2] * other2.value.back()) /
                 (long long)1e9;
      }
      if (s2 >= 2) {
        other += ((long double)other2.value[s2 - 2] * other1.value.back()) /
                 (long long)1e9;
      }
      other /= (long long)1e9;
    }
    if (s1 + s2 - 1 == s - 2) {
      other += other1.value.back() * other2.value.back();
      other /= (long long)1e9 * (long long)1e9;
    }
    return other / current;
  }
  string stringify() {
    string out = to_string(value.back());
    for (int i = value.size() - 1 - 1; i > -1; i -= 1) {
      string cur = to_string(value[i] + (long long)1e9);
      out += cur.substr(1);
    }
    return out;
  }
};
long long gcd(long long a, long long b) {
  if (b == 0) {
    return a;
  }
  return gcd(b, a % b);
}
long long triangle(long long x) { return (((long long)(x + 1)) * (x)) / 2; }
long long modInverse(long long a) {
  long long m = 1000000007;
  long long y = 0, x = 1;
  while (a > 1) {
    long long q = a / m;
    long long t = m;
    m = a % m, a = t;
    t = y;
    y = x - q * y;
    x = t;
  }
  if (x < 0) {
    x += 1000000007;
  }
  return x;
}
long long modInverse(long long a, long long b) {
  long long m = b;
  long long y = 0, x = 1;
  while (a > 1) {
    long long q = a / m;
    long long t = m;
    m = a % m, a = t;
    t = y;
    y = x - q * y;
    x = t;
  }
  if (x < 0) {
    x += b;
  }
  return x;
}
long long pow(long long a, long long b) {
  if (a <= 1) {
    return a;
  }
  if (b == 0) {
    return 1;
  }
  if (b % 2 == 0) {
    return pow((a * a) % 1000000007, b / 2) % 1000000007;
  }
  return (a * pow((a * a) % 1000000007, b / 2)) % 1000000007;
}
vector<long long> dev(vector<pair<long long, long long> > divisors) {
  if (divisors.size() == 0) {
    vector<long long> cur;
    cur.push_back(1);
    return cur;
  }
  long long x = divisors.back().first;
  long long n = divisors.back().second;
  divisors.pop_back();
  vector<long long> ans = dev(divisors);
  vector<long long> cur;
  long long xi = 1;
  for (int i = 0; i < n + 1; i += 1) {
    for (int j = 0; j < ans.size(); j += 1) {
      cur.push_back(ans[j] * xi);
    }
    xi *= x;
  }
  return cur;
}
void add(vector<int>& x, vector<int>& y) {
  for (int i = 0; i < x.size(); i += 1) {
    x[i] += y[i];
  }
}
struct pt {
  long long x, y;
  long long d() const { return x * x + y * y; }
};
inline pt operator-(const pt& a) { return {-a.x, -a.y}; }
inline pt operator+(const pt& a, const pt& b) { return {a.x + b.x, a.y + b.y}; }
inline pt operator-(const pt& a, const pt& b) { return {a.x - b.x, a.y - b.y}; }
inline long long operator*(const pt& a, const pt& b) {
  return a.x * b.y - a.y * b.x;
}
inline bool operator<(const pt& a, const pt& b) { return a * b < 0; }
inline long long operator/(const pt& a, const pt& b) {
  return a.x * b.x + a.y * b.y;
}
inline bool operator==(const pt& a, const pt& b) {
  return a.x == b.x && a.y == b.y;
}
inline bool operator!=(const pt& a, const pt& b) {
  return a.x != b.x || a.y != b.y;
}
pt o;
bool comp(pt a, pt b) { return (a - o) * (b - o) < 0; }
vector<vector<long long> > segtre(20);
void fix(int i, int j) {
  long long t = min(segtre[i - 1][2 * j], segtre[i - 1][2 * j + 1]);
  segtre[i][j] += t;
  segtre[i - 1][2 * j] -= t;
  segtre[i - 1][2 * j + 1] -= t;
}
int findzero() {
  int i = 20 - 1;
  int j = 0;
  while (i > 0) {
    if (segtre[i - 1][2 * j]) {
      j = 2 * j + 1;
    } else {
      j = 2 * j;
    }
    i--;
  }
  return j;
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  long long n;
  cin >> n;
  for (int i = 0; i < 20; i += 1) {
    segtre[i].resize(2 * n);
  }
  for (int i = 0; i < n; i += 1) {
    cin >> segtre[0][n - i - 1];
  }
  for (int i = 1; i < 20; i += 1) {
    for (int j = 0; j < n; j += 1) {
      fix(i, j);
    }
  }
  vector<long long> a(n);
  for (int i = 0; i < n; i += 1) {
    long long cur = findzero();
    a[cur] = i + 1;
    segtre[0][cur] = n * n;
    for (int j = 0; j < 20; j += 1) {
      if ((1 << j) & cur) {
        segtre[j][(cur >> j) - 1] -= i + 1;
      }
    }
    for (int j = 1; j < 20; j += 1) {
      fix(j, cur >> j);
      fix(j, max((long long)0, (cur >> j) - 1));
    }
  }
  for (int i = n - 1; i > -1; i -= 1) {
    cout << a[i] << ' ';
  }
  cout << "" << endl;
  return 0;
}
