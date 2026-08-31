#include <bits/stdc++.h>
using namespace std;
const long long INF = 1e16 + 5;
const int N = 1e6 + 5;
long long first[N];
long long lazy[N] = {0};
long long s[N];
int ans[N];
void pull(int v) { first[v] = min(first[2 * v + 1], first[2 * v + 2]); }
void apply(int v, long long val) {
  first[v] += val;
  lazy[v] += val;
}
void laziness(int v, int a, int b) {
  if (lazy[v] != 0) {
    apply(2 * v + 1, lazy[v]);
    apply(2 * v + 2, lazy[v]);
    lazy[v] = 0;
  }
}
void zbuduj(int v, int a, int b) {
  if (a > b) return;
  if (a == b) {
    first[v] = s[a];
    return;
  }
  zbuduj(2 * v + 1, a, (a + b) / 2);
  zbuduj(2 * v + 2, (a + b) / 2 + 1, b);
  first[v] = min(first[2 * v + 1], first[2 * v + 2]);
}
void dodaj(int v, int a, int b, int i, int j, long long val) {
  if (b < i || a > j) {
    return;
  } else if (a >= i && b <= j) {
    apply(v, val);
  } else {
    laziness(v, a, b);
    dodaj(2 * v + 1, a, (a + b) / 2, i, j, val);
    dodaj(2 * v + 2, (a + b) / 2 + 1, b, i, j, val);
    pull(v);
  }
}
int get_min(int v, int a, int b) {
  if (a == b)
    return a;
  else {
    laziness(v, a, b);
    int x = -1;
    if (first[2 * v + 2] == 0) {
      x = get_min(2 * v + 2, (a + b) / 2 + 1, b);
    } else {
      x = get_min(2 * v + 1, a, (a + b) / 2);
    }
    pull(v);
    return x;
  }
}
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 0; i < (n); ++i) scanf("%I64d", &s[i]);
  zbuduj(0, 0, n - 1);
  for (int i = (1); i <= (n); ++i) {
    int indeks = get_min(0, 0, n - 1);
    ans[indeks] = i;
    dodaj(0, 0, n - 1, indeks, indeks, INF);
    dodaj(0, 0, n - 1, indeks + 1, n - 1, -i);
  }
  for (int i = 0; i < (n); ++i) printf("%d ", ans[i]);
}
