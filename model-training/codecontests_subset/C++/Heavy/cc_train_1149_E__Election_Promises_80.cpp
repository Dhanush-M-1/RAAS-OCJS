#include <bits/stdc++.h>
using namespace std;
template <class n, class second>
ostream &operator<<(ostream &p, pair<n, second> x) {
  return p << "<" << x.first << ", " << x.second << ">";
}
template <class n>
auto operator<<(ostream &p, n y) ->
    typename enable_if<!is_same<n, string>::value,
                       decltype(y.begin(), p)>::type {
  int o = 0;
  p << "{";
  for (auto c : y) {
    if (o++) p << ", ";
    p << c;
  }
  return p << "}";
}
void dor() { cerr << endl; }
template <class n, class... second>
void dor(n p, second... y) {
  cerr << p << " ";
  dor(y...);
}
template <class n, class second>
void mini(n &p, second y) {
  if (p > y) p = y;
}
template <class n, class second>
void maxi(n &p, second y) {
  if (p < y) p = y;
}
const int M = 1024 * 256;
int H[M], mex[M];
int n, m, out[M], xo[M], xo2[M];
vector<int> V[M], T[M];
int main() {
  scanf("%d%d", &n, &m);
  for (int i = (1); i <= (int)(n); ++i) {
    scanf("%d", H + i);
  }
  for (int i = (1); i <= (int)(m); ++i) {
    int a, b;
    scanf("%d%d", &a, &b);
    V[a].push_back(b);
    T[b].push_back(a);
    out[a]++;
  }
  queue<int> Q;
  for (int i = (1); i <= (int)(n); ++i) {
    if (out[i] == 0) {
      Q.push(i);
    }
  }
  while (!Q.empty()) {
    int v = Q.front();
    Q.pop();
    vector<int> X;
    for (auto x : V[v]) {
      X.push_back(mex[x]);
    }
    sort((X).begin(), (X).end());
    X.resize(unique((X).begin(), (X).end()) - X.begin());
    X.push_back(1e9);
    for (int i = (0); i <= (int)((int)(X).size() - 1); ++i) {
      if (X[i] != i) {
        mex[v] = i;
        break;
      }
    }
    for (auto x : T[v]) {
      out[x]--;
      if (out[x] == 0) {
        Q.push(x);
      }
    }
    xo[mex[v]] ^= H[v];
  }
  int t = -1;
  for (int i = (0); i <= (int)(n); ++i) {
    if (xo[i] != 0) {
      t = i;
    }
  }
  if (t == -1) {
    printf("LOSE\n");
    return 0;
  }
  printf("WIN\n");
  bool boo = false;
  for (int i = (1); i <= (int)(n); ++i) {
    if (mex[i] != t || (xo[t] ^ H[i]) >= H[i]) {
      continue;
    }
    boo = true;
    H[i] = xo[t] ^ H[i];
    for (auto x : V[i]) {
      if (xo[mex[x]] != 0) {
        H[x] = xo[mex[x]] ^ H[x];
        xo[mex[x]] = 0;
      }
    }
    break;
  }
  assert(boo);
  for (int i = (1); i <= (int)(n); ++i) {
    printf("%d ", H[i]);
    xo2[mex[i]] ^= H[i];
  }
  for (int i = (0); i <= (int)(n); ++i) {
    assert(xo2[i] == 0);
  }
  printf("\n");
  return 0;
}
