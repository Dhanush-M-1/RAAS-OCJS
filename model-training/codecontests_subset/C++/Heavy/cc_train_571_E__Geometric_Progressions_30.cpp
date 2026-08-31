#include <bits/stdc++.h>
using namespace std;
const long long int modulo = 1000000007;
int esprimo[100000];
vector<int> primo;
vector<pair<int, int> > factorizacion(int x) {
  vector<pair<int, int> > f;
  for (int i = 0; i < int(primo.size()) and primo[i] <= x; i++) {
    int p = primo[i];
    int e = 0;
    while (x % p == 0) {
      x /= p;
      e++;
    }
    if (e) f.push_back(pair<int, int>(p, e));
  }
  if (x > 1) f.push_back(pair<int, int>(x, 1));
  return f;
}
int exponente(int p, vector<pair<int, int> > &f) {
  for (int i = 0; i < int(f.size()); i++)
    if (f[i].first == p) return f[i].second;
  return 0;
}
long long int eleva(long long int b, long long int e) {
  if (e == 0) return 1;
  if (e % 2 == 0) return eleva(b * b % modulo, e / 2);
  return b * eleva(b * b % modulo, e / 2) % modulo;
}
long long int mcd(long long int a, long long int b) {
  if (a < b) swap(a, b);
  if (b == 0) return a;
  return mcd(a % b, b);
}
long long int mcm(long long int a, long long int b) {
  return a / mcd(a, b) * b;
}
long long int absolut(long long int x) {
  if (x < 0) return -x;
  return x;
}
void chino(long long int a, long long int b, long long int &fa,
           long long int &fb, long long int c) {
  if (absolut(a) < absolut(b)) {
    chino(b, a, fb, fa, c);
    return;
  }
  if (b == 0) {
    if (c % a != 0) {
      cout << -1 << endl;
      exit(0);
    }
    fa = c / a;
    fb = 0;
    return;
  }
  chino(a % b, b, fa, fb, c);
  fb -= fa * (a / b);
}
void chino(long long int ini1, long long int salto1, long long int ini2,
           long long int salto2, long long int &con1, long long int &fac1,
           long long int &con2, long long int &fac2) {
  chino(salto1, -salto2, con1, con2, ini2 - ini1);
  fac1 = mcm(salto1, salto2) / salto1;
  fac2 = mcm(salto1, salto2) / salto2;
  long long int desp1 = 0;
  if (con1 < 0) {
    desp1 += -con1 / fac1;
    con1 %= fac1;
    if (con1 < 0) {
      con1 += fac1;
      desp1++;
    }
  }
  desp1 -= con1 / fac1;
  con1 %= fac1;
  con2 += desp1 * fac2;
  long long int desp2 = 0;
  if (con2 < 0) {
    desp2 += -con2 / fac2;
    con2 %= fac2;
    if (con2 < 0) {
      con2 += fac2;
      desp2++;
    }
  }
  con1 += desp2 * fac1;
}
void chino(long long int &ini, long long int &salto, long long int ininew,
           long long int saltonew) {
  long long int con, fac, connew, facnew;
  chino(ini, salto, ininew, saltonew, con, fac, connew, facnew);
  ini = ini + con * salto;
  salto = fac * salto;
}
void comprueba(vector<pair<int, int> > &fa1, vector<pair<int, int> > &fb1,
               vector<pair<int, int> > &fa2, vector<pair<int, int> > &fb2,
               int p, long long int &fac1, long long int fac2) {
  if (not(exponente(p, fb1) == 0 or fac1 != -1)) {
    fac1 = (exponente(p, fa2) + fac2 * exponente(p, fb2) - exponente(p, fa1)) /
           exponente(p, fb1);
    if (fac1 < 0) {
      cout << -1 << endl;
      exit(0);
    }
  }
  if (exponente(p, fa1) + fac1 * exponente(p, fb1) !=
      exponente(p, fa2) + fac2 * exponente(p, fb2)) {
    cout << -1 << endl;
    exit(0);
  }
}
void comprueba(vector<pair<int, int> > &fa1, vector<pair<int, int> > &fb1,
               vector<pair<int, int> > &fa2, vector<pair<int, int> > &fb2,
               vector<pair<int, int> > &f, long long int &fac1,
               long long int fac2) {
  for (int i = 0; i < int(f.size()); i++)
    comprueba(fa1, fb1, fa2, fb2, f[i].first, fac1, fac2);
}
void comprueba(vector<pair<int, int> > &fa1, vector<pair<int, int> > &fb1,
               vector<pair<int, int> > &fa2, vector<pair<int, int> > &fb2,
               long long int fac2) {
  long long int fac1 = -1;
  comprueba(fa1, fb1, fa2, fb2, fa1, fac1, fac2);
  comprueba(fa1, fb1, fa2, fb2, fb1, fac1, fac2);
  comprueba(fa1, fb1, fa2, fb2, fa2, fac1, fac2);
  comprueba(fa1, fb1, fa2, fb2, fb2, fac1, fac2);
}
void escribe(long long int a, vector<pair<int, int> > &fb, long long int fac) {
  long long int sol = a;
  for (int i = 0; i < int(fb.size()); i++) {
    long long int p = fb[i].first;
    long long int e = fb[i].second;
    e = fac * e;
    sol = sol * eleva(p, e) % modulo;
  }
  cout << sol << endl;
  exit(0);
}
void arregla(vector<pair<int, int> > &fa, vector<pair<int, int> > &fb) {
  int ib = 0;
  vector<pair<int, int> > nextfa;
  for (int ia = 0; ia < int(fa.size()); ia++, ib++) {
    for (; fb[ib].first != fa[ia].first; ib++)
      nextfa.push_back(pair<int, int>(fb[ib].first, 0));
    nextfa.push_back(fa[ia]);
  }
  for (; ib < int(fb.size()); ib++)
    nextfa.push_back(pair<int, int>(fb[ib].first, 0));
  fa = nextfa;
}
int n;
long long int a[100], b[100];
vector<pair<int, int> > fa[100], fb[100];
void intenta(int ind, long long int fac) {
  for (int i = 0; i < n; i++)
    if (i != ind) comprueba(fa[i], fb[i], fa[ind], fb[ind], fac);
  escribe(a[ind], fb[ind], fac);
}
void elimina(set<int> &s, vector<pair<int, int> > &f) {
  vector<pair<int, int> > nextf;
  for (int i = 0; i < int(f.size()); i++)
    if (s.count(f[i].first) == 0) nextf.push_back(f[i]);
  f = nextf;
}
int main() {
  for (int i = 2; i < 100000; i++) esprimo[i] = 1;
  for (int i = 2; i < 100000; i++) {
    if (esprimo[i]) {
      primo.push_back(i);
      for (int j = i + i; j < 100000; j += i) esprimo[j] = 0;
    }
  }
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> a[i] >> b[i];
    fa[i] = factorizacion(a[i]);
    fb[i] = factorizacion(b[i]);
  }
  for (int i = 1; i < n; i++) {
    for (int j = 0; j < int(fb[0].size()); j++) {
      int p = fb[0][j].first;
      int e = fb[0][j].second;
      if (exponente(p, fb[i]) == 0) {
        long long int x = exponente(p, fa[i]) - exponente(p, fa[0]);
        if (x < 0 or x % e != 0) {
          cout << -1 << endl;
          exit(0);
        }
        intenta(0, x / e);
      }
    }
    for (int j = 0; j < int(fb[i].size()); j++) {
      int p = fb[i][j].first;
      int e = fb[i][j].second;
      if (exponente(p, fb[0]) == 0) {
        long long int x = exponente(p, fa[0]) - exponente(p, fa[i]);
        if (x < 0 or x % e != 0) {
          cout << -1 << endl;
          exit(0);
        }
        intenta(i, x / e);
      }
    }
  }
  set<int> s;
  for (int i = 0; i < n; i++)
    for (int j = 0; j < int(fa[i].size()); j++)
      if (exponente(fa[i][j].first, fb[i]) == 0) s.insert(fa[i][j].first);
  for (set<int>::iterator it = s.begin(); it != s.end(); it++) {
    int p = *it;
    int e = exponente(p, fa[0]);
    for (int i = 1; i < n; i++) {
      if (exponente(p, fa[i]) != e) {
        cout << -1 << endl;
        exit(0);
      }
    }
  }
  for (int i = 0; i < n; i++) elimina(s, fa[i]);
  for (int i = 0; i < n; i++) arregla(fa[i], fb[i]);
  if (int(fb[0].size()) == 0) {
    intenta(0, 0);
  }
  long long int con = 0, salto = 1;
  for (int i = 1; i < n; i++) {
    long long int l1, ll1, l2, ll2;
    chino(fa[0][0].second, fb[0][0].second, fa[i][0].second, fb[i][0].second,
          l1, ll1, l2, ll2);
    for (int j = 0; j < int(fb[0].size()); j++) {
      long long int t1, tt1, t2, tt2;
      chino(fa[0][j].second, fb[0][j].second, fa[i][j].second, fb[i][j].second,
            t1, tt1, t2, tt2);
      if (ll1 == tt1 and ll2 == tt2) {
        if ((t1 - l1) % ll1 != 0 or (t2 - l2) % ll2 != 0 or
            (t1 - l1) / ll1 != (t2 - l2) / ll2) {
          cout << -1 << endl;
          exit(0);
        }
        long long int nextl1 = max(l1, t1);
        chino(con, salto, nextl1, ll1);
      } else {
        long long int x = t1 * tt2 - t2 * tt1;
        long long int y = l1 * tt2 - l2 * tt1;
        long long int z = ll1 * tt2 - ll2 * tt1;
        long long int xy = x - y;
        if (xy % z != 0) {
          cout << -1 << endl;
          exit(0);
        }
        intenta(0, l1 + xy / z * ll1);
      }
    }
  }
  intenta(0, con);
}
