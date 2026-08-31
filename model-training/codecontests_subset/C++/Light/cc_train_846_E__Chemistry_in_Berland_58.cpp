#include <bits/stdc++.h>
using namespace std;
const long long MAXN = 100 * 1000 + 10;
const long long MIN = 1000ll * 1000 * 1000 * 1000 + 100;
struct arc {
  long long fin, poids;
};
vector<arc> adj[MAXN];
long long val[MAXN];
bool vu[MAXN];
void faire(long long noeud) {
  vu[noeud] = true;
  for (auto arrete : adj[noeud]) {
    faire(arrete.fin);
    if (val[arrete.fin] > 0) {
      val[noeud] += val[arrete.fin];
    } else {
      val[noeud] += val[arrete.fin] * arrete.poids;
      if (val[noeud] <= -MIN) {
        cout << "NO" << endl;
        exit(0);
      }
    }
  }
}
int32_t main() {
  long long N;
  cin >> N;
  long long debut[N];
  long long fin[N];
  for (long long i = 0; i < N; i++) {
    cin >> debut[i];
  }
  for (long long i = 0; i < N; i++) {
    cin >> fin[i];
    val[i] = debut[i] - fin[i];
  }
  for (long long i = 1; i < N; i++) {
    long long a, b;
    cin >> a >> b;
    a--;
    adj[a].push_back({i, b});
  }
  for (long long i = 0; i < N; i++) {
    if (!vu[i]) {
      faire(i);
      if (val[i] < 0) {
        cout << "NO" << endl;
        return 0;
      }
    }
  }
  cout << "YES" << endl;
}
