#include <bits/stdc++.h>
using namespace std;
long long al[100][40] = {}, be[100][40] = {};
map<int, long long> ex;
map<int, long long> X;
vector<long long> p;
int primos[10000];
bool criba[40000];
unsigned long long m = 1000000007;
long long sq(long long a) { return a * a; }
long long potMod(long long a, unsigned long long b) {
  return b ? ((sq(potMod(a, b >> 1)) % m) * (b & 1 ? a : 1)) % m : 1;
}
long long pot(long long a, unsigned long long b) {
  return b ? sq(pot(a, b >> 1)) * (b & 1 ? a : 1) : 1;
}
int factorizar2(int N, int M) {
  int F = 0;
  for (int i = 0; primos[i] * primos[i] <= N || primos[i] * primos[i] <= M;
       i++) {
    if (N % primos[i] == 0 || M % primos[i] == 0) {
      ++F;
      p.push_back(primos[i]);
    }
    while (N % primos[i] == 0) {
      al[0][F - 1]++;
      N /= primos[i];
    }
    while (M % primos[i] == 0) {
      be[0][F - 1]++;
      M /= primos[i];
    }
  }
  if (N > 1 && M > 1) {
    if (N == M) {
      p.push_back(N);
      al[0][F] = be[0][F] = 1;
      F++;
    } else {
      p.push_back(N);
      p.push_back(M);
      al[0][F++] = 1;
      be[0][F++] = 1;
    }
  } else if (N > 1) {
    p.push_back(N);
    al[0][F++] = 1;
  } else if (M > 1) {
    p.push_back(M);
    be[0][F++] = 1;
  }
  return F;
}
map<int, long long> factorizar(int N) {
  map<int, long long> e;
  for (int i = 0; primos[i] * primos[i] <= N; i++) {
    if (!(N % primos[i]))
      while (!(N % primos[i])) {
        e[primos[i]]++;
        N /= primos[i];
      }
  }
  if (N > 1) e[N]++;
  return e;
}
pair<long long, long long> egcd(long long a, long long b) {
  if (b == 0) return make_pair(1, 0);
  pair<long long, long long> RES = egcd(b, a % b);
  return make_pair(RES.second, RES.first - RES.second * (a / b));
}
long long inv(long long n, long long m) {
  pair<long long, long long> EDGC = egcd(n, m);
  return ((EDGC.first % m) + m) % m;
}
long long tcr(int k, long long n[], long long a[]) {
  int i;
  long long temp, MOD, RES;
  MOD = 1;
  for (i = 0; i < k; i++) MOD *= n[i];
  RES = 0;
  for (i = 0; i < k; i++) {
    temp = MOD / n[i];
    temp *= inv(temp, n[i]);
    RES += (temp * a[i]) % MOD;
  }
  return RES % MOD;
}
int k;
long long x, y, A, B, C;
int intersectar(int j) {
  for (int i = 1; i < k; i++) {
    int D = be[j][0] * be[0][i] - be[0][0] * be[j][i];
    if (D == 0) {
      if (be[0][0] * (al[j][i] - al[0][i]) !=
          be[0][i] * (al[j][0] - al[0][0])) {
        return 0;
      }
    } else {
      int d1 =
          (al[j][i] - al[0][i]) * be[j][0] - (al[j][0] - al[0][0]) * be[j][i];
      int d2 =
          (al[j][i] - al[j][i]) * be[j][0] - (al[j][0] - al[0][0]) * be[0][i];
      if (d1 % D || d2 % D)
        return 0;
      else {
        x = d1 / D;
        y = d2 / D;
        if (x < 0 || y < 0) return 0;
        for (int h = 0; h < k; h++) al[0][h] += (be[0][h] * x);
        return 1;
      }
    }
  }
  int h = 0;
  for (; h < k - 1 && !(be[0][h] || be[j][h]); h++)
    ;
  A = be[0][h], B = be[j][h], C = al[j][h] - al[0][h];
  pair<long long, long long> r = egcd(A, -B);
  x = r.first;
  y = r.second;
  int d = A * x - B * y;
  if (d < 0) {
    d = -d;
    x = -x;
    y = -y;
  }
  if (C < 0) {
    C = -C;
    x = -x;
    y = -y;
  }
  if (d == 0) {
    x = y = 0;
    return 1;
  }
  if (C % d) return 0;
  A /= d;
  B /= d;
  C /= d;
  while (x < 0 || y < 0) {
    x += B;
    y += A;
  }
  while (x - B > 0 && y - A > 0) {
    x -= B;
    y -= A;
  }
  x *= C;
  y *= C;
  return 2;
}
bool validar(int i) {
  int j = 0;
  for (; j < k - 1 && !be[i][j]; j++)
    ;
  if (be[i][j] && (al[0][j] < al[i][j] || (al[0][j] - al[i][j]) % be[i][j]))
    return false;
  if (!be[i][j])
    y = 0;
  else
    y = (al[0][j] - al[i][j]) / be[i][j];
  for (int h = 1; h < k; h++)
    if (al[0][h] != al[i][h] + be[i][h] * y) return false;
  return true;
}
int main() {
  int n, a0, b0, a, b, tipo;
  k = 0;
  primos[k++] = 2;
  memset(criba, true, sizeof(criba));
  for (int i = 4; i < 40000; i += 2) criba[i] = false;
  for (int i = 3; i < 40000; i += 2)
    if (criba[i]) {
      primos[k++] = i;
      for (int j = i * i; j < 40000; j += i) criba[j] = false;
    }
  scanf("%d", &n);
  scanf("%d%d", &a0, &b0);
  k = factorizar2(a0, b0);
  for (int i = 1; i < n; i++) {
    scanf("%d%d", &a, &b);
    for (int j = 0; j < k; j++) {
      while (a % p[j] == 0) {
        al[i][j]++;
        a /= p[j];
      }
      while (b % p[j] == 0) {
        be[i][j]++;
        b /= p[j];
      }
    }
    if (a != 1) {
      printf("-1\n");
      return 0;
    }
    if (b != 1)
      for (int j = 0; j < k; j++) be[i][j] = 0;
  }
  long long maxX = 0;
  for (int i = 1; i < n; i++) {
    tipo = intersectar(i);
    if (!tipo) {
      printf("-1\n");
      return 0;
    }
    if (tipo == 1) {
      for (int j = 0; j < n; j++)
        if (!validar(j)) {
          printf("-1\n");
          return 0;
        }
      long long res = (a0 * potMod(b0, x)) % m;
      ;
      printf("%d\n", (int)res);
      return 0;
    }
    map<int, long long> e = factorizar(B);
    map<int, long long>::iterator it;
    for (it = e.begin(); it != e.end(); it++) {
      int p = it->first;
      int z1 = ex[p], z = it->second;
      if (!z1) {
        ex[p] = z;
        X[p] = x % pot(p, z);
      } else {
        long long x1 = X[p];
        if (z1 <= z) {
          long long po = pot(p, z1);
          if (x1 % po != x % po) {
            printf("-1\n");
            return 0;
          }
          ex[p] = z;
          X[p] = x % pot(p, z);
        } else {
          long long po = pot(p, z);
          if (x1 % po != x % po) {
            printf("-1\n");
            return 0;
          }
        }
      }
    }
    maxX = max(maxX, x);
  }
  long long mo[100];
  long long resi[100];
  int s = 0;
  map<int, long long>::iterator it;
  for (it = ex.begin(); it != ex.end(); it++)
    mo[s++] = pot(it->first, it->second);
  s = 0;
  for (it = X.begin(); it != X.end(); it++) resi[s++] = it->second;
  long long MOD = 1;
  for (int i = 0; i < s; i++) MOD *= mo[i];
  long long EXP = tcr(s, mo, resi);
  while (EXP < maxX) EXP += MOD;
  long long res = (a0 * potMod(b0, EXP)) % m;
  printf("%d\n", (int)res);
  return 0;
}
