#include <bits/stdc++.h>
using namespace std;
const int __SIZE = 1 << 18;
char ibuf[__SIZE], *iS, *iT;
template <typename T>
inline void read(T &x) {
  char ch, t = 0;
  x = 0;
  while (!isdigit(ch = (iS == iT
                            ? (iT = (iS = ibuf) + fread(ibuf, 1, __SIZE, stdin),
                               (iS == iT ? EOF : *iS++))
                            : *iS++)))
    t |= ch == '-';
  while (isdigit(ch))
    x = x * 10 + (ch ^ 48),
    ch = (iS == iT ? (iT = (iS = ibuf) + fread(ibuf, 1, __SIZE, stdin),
                      (iS == iT ? EOF : *iS++))
                   : *iS++);
  x = t ? -x : x;
}
inline int read_int() {
  int x;
  return read(x), x;
}
inline long long read_ll() {
  long long x;
  return read(x), x;
}
template <typename T>
inline void chkmin(T &a, T b) {
  a = a < b ? a : b;
}
template <typename T>
inline void chkmax(T &a, T b) {
  a = a > b ? a : b;
}
const int mod = 1e9 + 7;
inline int fsp(int x, long long k) {
  int s = 1;
  while (k) {
    if (k & 1) s = 1LL * s * x % mod;
    x = 1LL * x * x % mod, k >>= 1;
  }
  return s;
}
int tot;
int pri[31700];
int chk[31700];
inline void Sieve(int n = 31650) {
  for (int i = 2; i <= n; i++) {
    if (!chk[i]) pri[++tot] = i;
    for (int j = 1; j <= tot; j++) {
      if (i * pri[j] > n) break;
      chk[i * pri[j]] = 1;
      if (i % pri[j] == 0) break;
    }
  }
}
struct Num {
  int sz;
  long long p[510], k[510], b[510];
  inline int val() {
    int res = 1;
    for (int i = 1; i <= sz; i++) res = 1LL * res * fsp(p[i], b[i]) % mod;
    return res;
  }
  inline void Ins(int pr, int &x, int &y) {
    p[++sz] = pr, k[sz] = b[sz] = 0;
    while (x % pr == 0) ++b[sz], x /= pr;
    while (y % pr == 0) ++k[sz], y /= pr;
  }
  inline void init(int x, int y) {
    sz = 0;
    for (int i = 1; i <= tot; i++) {
      int pr = pri[i];
      if (pr > x && pr > y) break;
      if (x % pr && y % pr) continue;
      Ins(pr, x, y);
    }
    if (x < y) {
      if (x > 1) Ins(x, x, y);
      if (y > 1) Ins(y, x, y);
    } else {
      if (y > 1) Ins(y, x, y);
      if (x > 1) Ins(x, x, y);
    }
    p[sz + 1] = 1919810;
  }
} res, now, ans;
struct Seq {
  int a, b;
} s[110];
int ct;
long long vA[20];
long long vB[20];
long long vC[20];
inline long long sgn(long long x) { return x < 0 ? -1ll : min(x, 1ll); }
inline long long gcd(long long a, long long b) {
  return !b ? a : gcd(b, a % b);
}
inline long long lcm(long long a, long long b) {
  return !a && !b ? 0ll : a / gcd(a, b) * b;
}
inline void exgcd(long long a, long long b, long long &x, long long &y) {
  if (!b) return x = 1, y = 0, void();
  exgcd(b, a % b, y, x), y -= a / b * x;
}
inline void Solve(long long A, long long B, long long C, long long a,
                  long long b, long long c, long long &x, long long &y) {
  long long d = gcd(a, A), P = a / d, p = A / d;
  long long ta = a, tb = b, tc = c;
  B *= P, C *= P;
  b *= p, c *= p;
  B -= b, C -= c;
  if (sgn(C) * sgn(B) > 0 || !B || abs(C) % abs(B)) puts("-1"), exit(0);
  y = -C / B, tc += tb * y;
  if (!ta || tc % ta) puts("-1"), exit(0);
  x = tc / ta;
}
inline void Merge(int x, int y) {
  now.init(x, y), ct = 0;
  int found_res = 0, val_res = 0;
  int found_now = 0, val_now = 0;
  for (int i = 1, j = 1;;) {
    if (i > res.sz && j > now.sz)
      break;
    else if (res.p[i] != now.p[j]) {
      if (res.p[i] < now.p[j]) {
        if (res.b[i] > 0)
          puts("-1"), exit(0);
        else {
          if (found_res) {
            if (val_res) puts("-1"), exit(0);
          } else
            found_res = 1, val_res = 0;
        }
        ++i;
      } else {
        if (now.b[j] > 0)
          puts("-1"), exit(0);
        else {
          if (found_now) {
            if (val_now) puts("-1"), exit(0);
          } else
            found_now = 1, val_now = 0;
        }
        ++j;
      }
    } else {
      if (!res.k[i] && !now.k[j]) {
        if (res.b[i] != now.b[j]) puts("-1"), exit(0);
      } else if (!res.k[i]) {
        if (res.b[i] < now.b[j] || (res.b[i] - now.b[j]) % now.k[j])
          puts("-1"), exit(0);
        else {
          if (found_now) {
            if (val_now != (res.b[i] - now.b[j]) / now.k[j])
              puts("-1"), exit(0);
          } else
            found_now = 1, val_now = (res.b[i] - now.b[j]) / now.k[j];
        }
      } else if (!now.k[j]) {
        if (res.b[i] > now.b[j] || (now.b[j] - res.b[i]) % res.k[i])
          puts("-1"), exit(0);
        else {
          if (found_res) {
            if (val_res != (now.b[j] - res.b[i]) / res.k[i])
              puts("-1"), exit(0);
          } else
            found_res = 1, val_res = (now.b[j] - res.b[i]) / res.k[i];
        }
      } else {
        ++ct;
        vA[ct] = res.k[i];
        vB[ct] = now.k[j];
        vC[ct] = now.b[j] - res.b[i];
      }
      ++i, ++j;
    }
  }
  if (found_res || found_now) {
    if (found_res)
      for (int i = 1; i <= res.sz; i++)
        res.b[i] += val_res * res.k[i], res.k[i] = 0;
    if (found_now)
      for (int i = 1; i <= now.sz; i++)
        now.b[i] += val_now * now.k[i], now.k[i] = 0;
    int flag = 1;
    if (!found_res || !found_now) {
      flag = 0;
      for (int i = 1, j = 1;;) {
        if (i > res.sz && j > now.sz) break;
        if (res.p[i] != now.p[j]) {
          if (res.p[i] < now.p[j] && res.b[i] != 0) puts("-1"), exit(0);
          if (res.p[i] > now.p[j] && now.b[j] != 0) puts("-1"), exit(0);
          if (res.p[i] < now.p[j])
            ++i;
          else
            ++j;
        } else {
          if (!res.k[i] && !now.k[j]) {
            if (res.b[i] != now.b[j]) puts("-1"), exit(0);
          } else if (!res.k[i]) {
            if (res.b[i] < now.b[j] || (res.b[i] - now.b[j]) % now.k[j])
              puts("-1"), exit(0);
            else {
              if (found_now) {
                if (val_now != (res.b[i] - now.b[j]) / now.k[j])
                  puts("-1"), exit(0);
              } else
                found_now = 1, val_now = (res.b[i] - now.b[j]) / now.k[j];
            }
            flag = 1;
            break;
          } else if (!now.k[j]) {
            if (res.b[i] > now.b[j] || (now.b[j] - res.b[i]) % res.k[i])
              puts("-1"), exit(0);
            else {
              if (found_res) {
                if (val_res != (now.b[j] - res.b[i]) / res.k[i])
                  puts("-1"), exit(0);
              } else
                found_res = 1, val_res = (now.b[j] - res.b[i]) / res.k[i];
            }
            flag = 1;
            break;
          }
          ++i, ++j;
        }
      }
      if (found_res)
        for (int i = 1; i <= res.sz; i++)
          res.b[i] += val_res * res.k[i], res.k[i] = 0;
      if (found_now)
        for (int i = 1; i <= now.sz; i++)
          now.b[i] += val_now * now.k[i], now.k[i] = 0;
    }
    if (flag) {
      for (int i = 1, j = 1;;) {
        if (i > res.sz && j > now.sz) break;
        if (res.p[i] != now.p[j]) {
          if (res.p[i] < now.p[j] && res.b[i] != 0) puts("-1"), exit(0);
          if (res.p[i] > now.p[j] && now.b[j] != 0) puts("-1"), exit(0);
          if (res.p[i] < now.p[j])
            ++i;
          else
            ++j;
        } else {
          if (!res.k[i] && !now.k[j]) {
            if (res.b[i] != now.b[j]) puts("-1"), exit(0);
          }
          ++i, ++j;
        }
      }
    }
  } else if (ct) {
    for (int i = 1; i <= ct; i++) {
      long long d = gcd(vA[i], vB[i]);
      if (vC[i] % d)
        puts("-1"), exit(0);
      else
        vA[i] /= d, vB[i] /= d, vC[i] /= d;
    }
    int flag = 1;
    for (int i = 2; i <= ct; i++)
      if (vA[i] == vA[i - 1] && vB[i] == vB[i - 1] && vC[i] == vC[i - 1])
        flag++;
    if (flag == ct) {
      long long x, y;
      exgcd(vA[1], vB[1], x, y);
      y = -y, x *= vC[1], y *= vC[1];
      if (x > 0) {
        long long t = x / vB[1];
        x -= vB[1] * t;
        y -= vA[1] * t;
      }
      if (y > 0) {
        long long t = y / vA[1];
        x -= vB[1] * t;
        y -= vA[1] * t;
      }
      if (x < 0) {
        long long t = -x / vB[1] + (x % vB[1] < 0);
        x += vB[1] * t;
        y += vA[1] * t;
      }
      if (y < 0) {
        long long t = -y / vA[1] + (y % vA[1] < 0);
        x += vB[1] * t;
        y += vA[1] * t;
      }
      if (x < 0) puts("-1"), exit(0);
      ans.sz = 0;
      for (int i = 1, j = 1; i <= res.sz && j <= now.p[j];) {
        if (res.p[i] != now.p[j]) {
          if (res.p[i] < now.p[j])
            ++i;
          else
            ++j;
          continue;
        }
        ++ans.sz;
        long long b = res.b[i], k = res.k[i];
        ans.p[ans.sz] = res.p[i];
        ans.b[ans.sz] = b + k * x;
        ans.k[ans.sz] = lcm(res.k[i], now.k[j]);
        ++i, ++j;
      }
      ans.p[ans.sz + 1] = 1919810, res = ans;
      return;
    } else {
      long long x, y;
      for (int i = 2; i <= ct; i++) {
        if (vA[i] == vA[1] && vB[i] == vB[1] && vC[i] == vC[1]) continue;
        Solve(vA[1], vB[1], vC[1], vA[i], vB[i], vC[i], x, y);
        break;
      }
      for (int i = 1; i <= ct; i++)
        if (vA[i] * x - vB[i] * y != vC[i]) puts("-1"), exit(0);
      for (int i = 1; i <= res.sz; i++) res.b[i] += x * res.k[i], res.k[i] = 0;
      for (int i = 1; i <= now.sz; i++) now.b[i] += y * now.k[i], now.k[i] = 0;
    }
  }
  ans.sz = 0;
  for (int i = 1, j = 1; i <= res.sz && j <= now.p[j];) {
    if (res.p[i] != now.p[j]) {
      if (res.p[i] < now.p[j]) {
        if (res.b[i]) puts("-1"), exit(0);
        ++i;
      } else {
        if (now.b[j]) puts("-1"), exit(0);
        ++j;
      }
      continue;
    }
    if (res.b[i] != now.b[j]) puts("-1"), exit(0);
    ++ans.sz;
    ans.p[ans.sz] = res.p[i];
    ans.b[ans.sz] = res.b[i];
    ans.k[ans.sz] = 0;
    ++i, ++j;
  }
  ans.p[ans.sz + 1] = 1919810, res = ans;
}
int main() {
  Sieve();
  int n = read_int();
  for (int i = 1; i <= n; i++) s[i].a = read_int(), s[i].b = read_int();
  res.init(s[1].a, s[1].b);
  for (int i = 2; i <= n; i++) Merge(s[i].a, s[i].b), cerr << res.b[1] << endl;
  printf("%d\n", res.val());
  return 0;
}
