#include <bits/stdc++.h>
using namespace std;
const signed long long INF = 10000001000LL;
const long double EPS = 4e-10;
struct trzy {
  int first, b, second, d;
  trzy() {}
  trzy(int first, int b, int second, int d)
      : first(first), b(b), second(second), d(d){};
  bool operator<(const trzy& inny) const { return second < inny.second; }
};
int n, m, q;
vector<trzy> V;
void read_data() {
  scanf("%d%d%d", &n, &m, &q);
  for (int i = 0; i < m; i++) {
    int first, b, second;
    scanf("%d%d%d", &first, &b, &second);
    V.push_back(trzy(first, b, second, i + 1));
  }
}
inline pair<int, int>& FIND(int v, vector<pair<int, int> >& V) {
  if (v == V[v].first) return V[v];
  pair<int, int>& korzen = FIND(V[v].first, V);
  V[v].second ^= V[V[v].first].second;
  V[v].first = korzen.first;
  return V[korzen.first];
}
int UNION(int v, int w, vector<pair<int, int> >& V) {
  pair<int, int>&korzenv = FIND(v, V), &korzenw = FIND(w, V), &aktv = V[v],
            &aktw = V[w];
  if (korzenv.first == korzenw.first) {
    if ((aktw.second ^ aktv.second) == 0) return -1;
    return 0;
  }
  int odl = 1 ^ (aktw.second ^ aktv.second);
  korzenv.first = korzenw.first;
  korzenv.second = odl;
  return 0;
}
void test(vector<trzy>& Akt) {
  vector<pair<int, int> > V(n + 1);
  for (int i = 0; i <= n; i++) V[i].first = i, V[i].second = 0;
  for (auto& el : Akt) {
    int pom = UNION(el.first, el.b, V);
    if (pom == -1) {
      printf("%d\n", el.second);
      return;
    }
  }
  printf("-1\n");
  return;
}
vector<trzy> Akt;
void solve() {
  Akt.reserve(1000005);
  sort(V.begin(), V.end());
  for (int i = 0; i < q; i++) {
    Akt.clear();
    int first, b;
    scanf("%d%d", &first, &b);
    Akt.resize(b - first + 1);
    int nr = 0;
    for (int i = m - 1; i >= 0; i--) {
      if (V[i].d >= first and V[i].d <= b) {
        Akt[nr] = V[i];
        nr++;
      }
    }
    test(Akt);
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  read_data();
  solve();
}
