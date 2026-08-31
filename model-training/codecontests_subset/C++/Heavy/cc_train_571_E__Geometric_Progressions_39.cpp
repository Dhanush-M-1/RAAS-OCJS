#include <bits/stdc++.h>
using namespace std;
const int Mod = 1000000007;
int n;
map<int, int> mp;
int cnt = 0;
int A[105], B[105];
int Ans = 1;
inline int Fast_Pow(int a, long long b) {
  b %= (Mod - 1);
  int res = 1;
  while (b) {
    if (b & 1) res = 1ll * res * a % Mod;
    a = 1ll * a * a % Mod;
    b >>= 1;
  }
  return res;
}
int num[105];
struct Data {
  int p;
  int a[105], b[105];
  bool vis;
  int Judge() {
    bool flag = false;
    int at;
    for (int i = 1; i <= n; ++i)
      if (!b[i]) {
        flag = true;
        at = i;
        break;
      }
    if (!flag) return -1;
    for (int i = 1; i <= n; ++i)
      if (at != i) {
        if (b[i]) {
          if (a[i] > a[at]) {
            num[i] = 0;
            return i;
          } else if ((a[at] - a[i]) % b[i] != 0) {
            num[i] = 0;
            return i;
          } else {
            num[i] = (a[at] - a[i]) / b[i];
            return i;
          }
        } else if (a[i] != a[at]) {
          num[i] = 0;
          return i;
        }
      }
    vis = true;
    return -1;
  }
} data[2005], seq[2005];
int len;
void calc(int x) {
  for (int i = 1; i <= cnt; ++i)
    seq[i].a[x] = seq[i].a[x] + num[x] * seq[i].b[x];
  for (int i = 1; i <= n; ++i)
    if (i != x) {
      int z = -1;
      for (int j = 1; j <= cnt; ++j)
        if (seq[j].b[i] == 0) {
          if (seq[j].a[i] != seq[j].a[x]) {
            puts("-1");
            exit(0);
          }
        } else {
          if (seq[j].a[i] > seq[j].a[x]) {
            puts("-1");
            exit(0);
          }
          if ((seq[j].a[x] - seq[j].a[i]) % seq[j].b[i] != 0) {
            puts("-1");
            exit(0);
          }
          int t = (seq[j].a[x] - seq[j].a[i]) / seq[j].b[i];
          if (z != -1 && z != t) {
            puts("-1");
            exit(0);
          }
          z = t;
        }
    }
  Ans = 1ll * A[x] * Fast_Pow(B[x], num[x]) % Mod;
  printf("%d\n", Ans);
  exit(0);
}
int P() {
  for (int i = 2; i <= n; ++i)
    for (int j = 2; j <= cnt; ++j) {
      if (seq[j].b[i] * seq[1].b[i - 1] != seq[1].b[i] * seq[j].b[i - 1]) {
        for (int Y = 0; Y <= 1000; ++Y) {
          int t1 = seq[1].a[i] - seq[1].a[i - 1] + Y * seq[1].b[i],
              t2 = seq[j].a[i] - seq[j].a[i - 1] + Y * seq[j].b[i];
          if (t1 % seq[1].b[i - 1] != 0 || t2 % seq[j].b[i - 1] != 0 ||
              t1 < 0 || t2 < 0)
            continue;
          t1 /= seq[1].b[i - 1];
          t2 /= seq[j].b[i - 1];
          if (t1 != t2) continue;
          num[i - 1] = t1;
          return i - 1;
        }
        puts("-1");
        exit(0);
      } else if ((seq[1].a[i] - seq[1].a[i - 1]) * seq[j].b[i - 1] !=
                 (seq[j].a[i] - seq[j].a[i - 1]) * seq[1].b[i - 1]) {
        puts("-1");
        exit(0);
      }
    }
  return -1;
}
long long gcd(long long x, long long y) {
  if (!y) return x;
  return gcd(y, x % y);
}
void exgcd(long long a, long long b, long long &x, long long &y) {
  if (!b) {
    x = 1;
    y = 0;
    return;
  }
  exgcd(b, a % b, y, x);
  y -= (a / b) * x;
}
long long inv(long long a, long long b) {
  long long x, y;
  exgcd(a, b, x, y);
  return (x % b + b) % b;
}
void solve() {
  long long s = seq[1].a[1] % seq[1].b[1], w = seq[1].b[1];
  for (int i = 2; i <= n; ++i) {
    long long u = seq[1].a[i] % seq[1].b[i], v = seq[1].b[i];
    long long d = gcd(w, v);
    if ((u - s) % d != 0) {
      puts("-1");
      exit(0);
    }
    long long ww = w / d, vv = v / d, cc = (u - s) / d;
    long long z = inv(ww, vv);
    long long x = (z * cc % vv + vv) % vv;
    s = w * x + s;
    w = ww * vv * d;
  }
  for (int i = 1; i <= n; ++i)
    while (s < seq[1].a[i]) s += w;
  Ans = 1ll * A[1] * Fast_Pow(B[1], (s - seq[1].a[1]) / seq[1].b[1]) % Mod;
  printf("%d\n", Ans);
}
void getphi(int x, int id, int ty) {
  int tmp = x;
  for (int i = 2; i * i <= x; ++i)
    if (x % i == 0) {
      int ad = 0;
      while (tmp % i == 0) {
        ad++;
        tmp /= i;
      }
      if (!mp[i]) {
        mp[i] = ++cnt;
        data[cnt].p = i;
      }
      if (ty == 1)
        data[mp[i]].a[id] = ad;
      else
        data[mp[i]].b[id] = ad;
    }
  if (tmp > 1) {
    if (!mp[tmp]) {
      mp[tmp] = ++cnt;
      data[cnt].p = tmp;
    }
    if (ty == 1)
      data[mp[tmp]].a[id] = 1;
    else
      data[mp[tmp]].b[id] = 1;
  }
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; ++i) {
    scanf("%d%d", &A[i], &B[i]);
    getphi(A[i], i, 1);
    getphi(B[i], i, 2);
  }
  int t = -1;
  for (int i = 1; i <= cnt; ++i) {
    int z = data[i].Judge();
    if (!data[i].vis) {
      len++;
      for (int j = 1; j <= n; ++j) {
        seq[len].a[j] = data[i].a[j];
        seq[len].b[j] = data[i].b[j];
      }
    }
    if (z != -1) t = z;
  }
  cnt = len;
  if (t != -1) {
    calc(t);
    return 0;
  }
  int p = P();
  if (p != -1) {
    calc(p);
    return 0;
  }
  if (cnt == 0) {
    printf("%d\n", A[1]);
    return 0;
  }
  solve();
  return 0;
}
