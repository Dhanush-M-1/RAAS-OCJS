#include <bits/stdc++.h>
using namespace std;
const int primero = 1 << 18;
const int tope = 1 << 19;
pair<int, int> minimo[tope];
void insertar(int pos, pair<int, int> val) {
  pos += primero;
  minimo[pos] = val;
  while (pos > 1) {
    pos /= 2;
    minimo[pos] = min(minimo[2 * pos], minimo[2 * pos + 1]);
  }
}
pair<int, int> minimoentre(int pos0, int pos1) {
  pos0 += primero;
  pos1 += primero;
  if (pos0 > pos1) swap(pos0, pos1);
  if (pos0 == pos1) return minimo[pos0];
  pair<int, int> mini = min(minimo[pos0], minimo[pos1]);
  while (pos0 + 1 < pos1) {
    if (pos0 % 2 == 0) mini = min(mini, minimo[pos0 + 1]);
    pos0 /= 2;
    if (pos1 % 2 == 1) mini = min(mini, minimo[pos1 - 1]);
    pos1 /= 2;
  }
  return mini;
}
long long int modulo = 1e9 + 7;
long long int suma[1000000];
void inserta(int pos, long long int val) {
  while (pos < 1000000) {
    suma[pos] = (suma[pos] + val) % modulo;
    pos += pos & -pos;
  }
}
long long int sumaantes(int pos) {
  long long int s = 0;
  while (pos) {
    s = (s + suma[pos]) % modulo;
    pos -= pos & -pos;
  }
  return s;
}
int n;
vector<pair<int, int> > g[1000000];
int padre[1000000];
int posle[1000000];
int posri[1000000];
long long int cuantos[1000000];
long long int sumad[1000000];
long long int sumad2[1000000];
int posact = 1;
long long int sumadtodos[1000000];
long long int sumad2todos[1000000];
int posleminimo[1000000];
int posminimo = 1;
void computa(int u, long long int sumadp, long long int sumad2p, int prof) {
  sumadtodos[u] = (sumad[u] + sumadp) % modulo;
  sumad2todos[u] = (sumad2[u] + sumad2p) % modulo;
  vector<pair<int, int> > &ar = g[u];
  posleminimo[u] = posminimo;
  insertar(posminimo++, pair<int, int>(prof, u));
  for (int i = 0; i < int(ar.size()); i++) {
    int v = ar[i].first;
    long long int d = ar[i].second;
    long long int cuantosaux = n - cuantos[v];
    long long int sumadaux =
        (sumadtodos[u] - (sumad[v] + cuantos[v] * d)) % modulo;
    long long int sumad2aux =
        (sumad2todos[u] -
         (sumad2[v] + cuantos[v] * d % modulo * d + 2 * d * sumad[v])) %
        modulo;
    computa(
        v, (sumadaux + cuantosaux * d) % modulo,
        (sumad2aux + cuantosaux * d % modulo * d + 2 * d * sumadaux) % modulo,
        prof + 1);
    insertar(posminimo++, pair<int, int>(prof, u));
  }
}
void eliminapadre(int u, int p) {
  cuantos[u] = 1;
  posle[u] = posact++;
  padre[u] = p;
  vector<pair<int, int> > &ar = g[u];
  vector<pair<int, int> > nextar;
  int dpadre = 0;
  for (int i = 0; i < int(ar.size()); i++) {
    int v = ar[i].first;
    long long int d = ar[i].second;
    if (v != p) {
      nextar.push_back(ar[i]);
      eliminapadre(v, u);
      cuantos[u] += cuantos[v];
      sumad[u] = (sumad[u] + sumad[v] + cuantos[v] * d) % modulo;
      sumad2[u] = (sumad2[u] + sumad2[v] + cuantos[v] * d % modulo * d +
                   2 * d * sumad[v]) %
                  modulo;
    } else
      dpadre = d;
  }
  ar = nextar;
  posri[u] = posact++;
  inserta(posle[u], dpadre);
  inserta(posri[u], -dpadre);
}
int main() {
  ios::sync_with_stdio(false);
  cin >> n;
  for (int i = 0; i < n - 1; i++) {
    int u, v, c;
    cin >> u >> v >> c;
    g[u].push_back(pair<int, int>(v, c));
    g[v].push_back(pair<int, int>(u, c));
  }
  eliminapadre(1, 0);
  computa(1, 0, 0, 0);
  int q;
  cin >> q;
  for (int i = 0; i < q; i++) {
    int u, v;
    cin >> u >> v;
    int w = minimoentre(posleminimo[u], posleminimo[v]).second;
    long long int d = (sumaantes(posle[u]) - sumaantes(posle[w]) +
                       sumaantes(posle[v]) - sumaantes(posle[w])) %
                      modulo;
    long long int sol;
    if (posle[v] < posle[u] and posle[u] < posri[v]) {
      long long int cuantosaux = n - cuantos[v];
      long long int sumadaux = (sumadtodos[v] - sumad[v]) % modulo;
      long long int sumad2aux = (sumad2todos[v] - sumad2[v]) % modulo;
      sol = (sumad2todos[u] - 2 * (sumad2aux + cuantosaux * d % modulo * d +
                                   2 * d * sumadaux % modulo)) %
            modulo;
    } else {
      sol = (-sumad2todos[u] + 2 * (sumad2[v] + cuantos[v] * d % modulo * d +
                                    2 * d * sumad[v] % modulo)) %
            modulo;
    }
    cout << (sol % modulo + modulo) % modulo << endl;
  }
}
