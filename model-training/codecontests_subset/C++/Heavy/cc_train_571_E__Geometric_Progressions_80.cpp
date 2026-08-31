#include <bits/stdc++.h>
using namespace std;
const int mod = 1e9 + 7;
long long power(long long x, long long y) {
  long long re = 1;
  while (y) {
    if (y & 1) re = re * x % mod;
    x = x * x % mod;
    y >>= 1;
  }
  return re;
}
long long mul(long long x, long long y, long long mod) {
  if (y < 0) {
    x = -x;
    y = -x;
  }
  long long re = 0;
  while (y) {
    if (y & 1) re = (re + x) % mod;
    x = (x << 1) % mod;
    y >>= 1;
  }
  return re;
}
long long gcd(long long a, long long b) { return b == 0 ? a : gcd(b, a % b); }
long long exgcd(long long a, long long b, long long &x, long long &y) {
  if (b == 0) {
    x = 1, y = 0;
    return a;
  }
  int d = exgcd(b, a % b, y, x);
  y -= a / b * x;
  return d;
}
long long lcm(long long a, long long b) {
  long long d = gcd(a, b);
  return a / d * b;
}
long long inver(long long a, long long b) {
  long long x, y;
  exgcd(a, b, x, y);
  x = (x % b + b) % b;
  return x;
}
int ord(int a, int p) {
  int re = 0;
  while (a % p == 0) {
    ++re;
    a /= p;
  }
  return re;
}
vector<int> Merge(const vector<int> &a, const vector<int> &b) {
  vector<int> re(a.size() + b.size());
  merge(a.begin(), a.end(), b.begin(), b.end(), re.begin());
  re.resize(unique(re.begin(), re.end()) - re.begin());
  return re;
}
struct AP {
  long long s, t;
  AP(long long s = -1, long long t = -1) : s(s), t(t) {}
  void print() { cerr << s << ' ' << t << endl; }
};
AP trace(AP A, AP B) { return AP((A.s - B.s) / B.t, A.t / B.t); }
AP subsec(AP A, AP B) { return AP(A.s + B.s * A.t, A.t * B.t); }
AP intersect(AP A, AP B) {
  if (A.s == -1 || B.s == -1) {
    return AP();
  }
  if (A.t == 0 && B.t == 0) {
    if (A.s == B.s) {
      return A;
    }
    return AP();
  }
  if (B.t == 0) {
    swap(A, B);
  }
  if (A.t == 0) {
    if (A.s >= B.s && (A.s - B.s) % B.t == 0) {
      return A;
    }
    return AP();
  }
  long long d = gcd(A.t, B.t);
  if (A.s % d != B.s % d) {
    return AP();
  }
  if (A.s < B.s) {
    swap(A, B);
  }
  long long a = A.t / d;
  long long b = B.t / d;
  long long c = (B.s - A.s) / d;
  long long y = mul((-c) % a, inver(b, a), a);
  y += a * max(0LL, (-c - y * b + a * b - 1) / (a * b));
  return AP(B.s + B.t * y, lcm(A.t, B.t));
}
AP strong_intersect(AP a, AP b) {
  if (a.t == b.t) {
    if (a.s == b.s) return a;
    return AP();
  }
  if (a.s == b.s) {
    return AP(a.s, 0);
  }
  if (a.s < b.s) {
    swap(a, b);
  }
  long long num = (a.s - b.s);
  long long den = (b.t - a.t);
  if (den < 0 || num % den) {
    return AP();
  }
  num /= den;
  return AP(a.s + a.t * num, 0);
}
long long fix(int A0, int B0, long long fix0, int A1, int B1,
              const vector<int> p, bool &flag) {
  long long fix = -1;
  for (unsigned int i = 0; i < p.size(); ++i) {
    int P = p[i];
    AP A(ord(A0, P), ord(B0, P));
    if (fix0 != -1) {
      A.s += A.t * fix0;
      A.t = 0;
    }
    AP B(ord(A1, P), ord(B1, P));
    AP I = intersect(A, B);
    if (I.s == -1) {
      flag = true;
      return -1;
    }
    if (I.t == 0 && B.t != 0) {
      long long nfix = (I.s - B.s) / B.t;
      if (fix != -1 && fix != nfix) {
        flag = true;
        return -1;
      }
      fix = nfix;
    }
  }
  return fix;
}
AP calc(int A0, int B0, int A1, int B1, const vector<int> &p) {
  bool flag = 0;
  long long fix0, fix1;
  fix1 = fix(A0, B0, -1, A1, B1, p, flag);
  fix0 = fix(A1, B1, fix1, A0, B0, p, flag);
  fix1 = fix(A0, B0, fix0, A1, B1, p, flag);
  if (flag) {
    return AP();
  }
  if (fix0 != -1) {
    return AP(fix0, 0);
  }
  AP I0(0, 1);
  AP I1(0, 1);
  bool was = false;
  for (unsigned int i = 0; i < p.size(); ++i) {
    int P = p[i];
    AP A(ord(A0, P), ord(B0, P));
    AP B(ord(A1, P), ord(B1, P));
    AP I = intersect(A, B);
    if (A.t == 0 || B.t == 0) {
      continue;
    }
    AP AA = trace(I, A);
    AP BB = trace(I, B);
    if (!was) {
      was = 1;
      I0 = AA;
      I1 = BB;
      continue;
    }
    AP X = intersect(AA, I0);
    AP Y = intersect(BB, I1);
    if (X.s == -1 || Y.s == -1) {
      return AP();
    }
    AP subold0 = trace(X, I0);
    AP subold1 = trace(Y, I1);
    AP subold2 = intersect(subold0, subold1);
    if (subold2.s == -1) {
      return AP();
    }
    I0 = subsec(I0, subold2);
    I1 = subsec(I1, subold2);
    AP subnew0 = trace(I0, AA);
    AP subnew1 = trace(I1, BB);
    AP subnew2 = strong_intersect(subnew0, subnew1);
    if (subnew2.s == -1) {
      return AP();
    }
    I0 = subsec(AA, subnew2);
    I1 = subsec(BB, subnew2);
    if (I1.t == 0) {
      fix1 = I1.s;
      fix0 = fix(A1, B1, fix1, A0, B0, p, flag);
      if (flag) {
        return AP();
      }
      I0 = AP(fix0, 0);
    }
    if (I0.t == 0) {
      fix0 = I0.s;
      fix1 = fix(A0, B0, fix0, A1, B1, p, flag);
      if (flag) {
        return AP();
      }
      return AP(fix0, 0);
    }
  }
  return I0;
}
int n;
int a[105], b[105];
vector<int> p[105];
bool check(int a, int b, int x) {
  if (x % a) {
    return false;
  }
  x /= a;
  if (b == 1) {
    return x == 1;
  }
  while (x > 1) {
    if (x % b) {
      return false;
    }
    x /= b;
  }
  return x == 1;
}
vector<int> getprime(int n) {
  vector<int> p;
  for (int i = 2; i <= n / i; ++i)
    if (n % i == 0) {
      p.push_back(i);
      while (n % i == 0) {
        n /= i;
      }
    }
  if (n > 1) {
    p.push_back(n);
  }
  return p;
}
int solve() {
  for (int i = 1; i <= n; ++i)
    if (b[i] == 1) {
      for (int j = 1; j <= n; ++j) {
        if (!check(a[j], b[j], a[i])) return -1;
      }
      return a[i];
    }
  for (int i = 1; i <= n; ++i) {
    p[i] = Merge(getprime(a[i]), getprime(b[i]));
  }
  AP I(0, 1);
  for (int i = 2; i <= n; ++i) {
    vector<int> P = Merge(p[1], p[i]);
    I = intersect(I, calc(a[1], b[1], a[i], b[i], P));
    if (I.s == -1) {
      return -1;
    }
  }
  return a[1] * power(b[1], I.s) % mod;
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; ++i) {
    scanf("%d%d", &a[i], &b[i]);
  }
  printf("%d\n", solve());
  return 0;
}
