#include <bits/stdc++.h>
using namespace std;
const int N = 400;
bitset<N> shift(const bitset<N>& set, int n, int x) {
  return (set >> x) | (set << (n - x));
}
struct Solution {
  vector<string> T, P;
  bitset<N> R[N];
  int n, m, r, c;
  Solution(int n, int m, int r, int c, const vector<string>& T,
           const vector<string>& P)
      : n(n), m(m), r(r), c(c), T(T), P(P) {}
  vector<bitset<N>> solve() {
    vector<vector<bitset<N>>> G(26, vector<bitset<N>>(N));
    vector<bitset<N>> R(N);
    int nn = n;
    int mm = m;
    n = max(n, r);
    m = max(m, c);
    T.resize(n);
    for (int(i) = (0); (i) < (n); (i)++) {
      T[i].resize(m);
      for (int(j) = (0); (j) < (m); (j)++) {
        T[i][j] = T[(((i) % (nn) + (nn)) % (nn))][(((j) % (mm) + (mm)) % (mm))];
      }
    }
    for (int(i) = (0); (i) < (n); (i)++) {
      for (int(j) = (0); (j) < (m); (j)++) {
        G[T[i][j] - 'a'][i][j] = 1;
      }
    }
    for (int(i) = (0); (i) < (n); (i)++) {
      R[i] = ~R[i];
    }
    for (int(x) = (0); (x) < (r); (x)++) {
      for (int(y) = (0); (y) < (c); (y)++) {
        if (P[x][y] != '?') {
          for (int(i) = (0); (i) < (n); (i)++) {
            auto s =
                shift(G[P[x][y] - 'a'][(((i + x) % (n) + (n)) % (n))], m, y);
            R[i] &= s;
          }
        }
      }
    }
    return R;
  }
};
vector<string> T, P;
int n, m, r, c;
mt19937 twister(5452222);
int Rand(int a, int b) { return uniform_int_distribution<int>(a, b)(twister); }
void RandomTest() {
  n = Rand(1, 200);
  m = Rand(1, 200);
  r = Rand(1, 200);
  c = Rand(1, 200);
  T.resize(n);
  for (int(i) = (0); (i) < (n); (i)++) {
    T[i].resize(m);
    for (int(j) = (0); (j) < (m); (j)++) {
      T[i][j] = Rand('a', 'z');
    }
  }
  P.resize(r);
  for (int(i) = (0); (i) < (r); (i)++) {
    P[i].resize(c);
    for (int(j) = (0); (j) < (c); (j)++) {
      P[i][j] = Rand('a', 'z');
    }
  }
}
int main(int argc, char* argv[]) {
  ios::sync_with_stdio(0);
  cin >> n >> m;
  for (int(i) = (0); (i) < (n); (i)++) {
    string s;
    cin >> s;
    T.push_back(move(s));
  }
  cin >> r >> c;
  for (int(i) = (0); (i) < (r); (i)++) {
    string s;
    cin >> s;
    P.push_back(move(s));
  }
  Solution s(n, m, r, c, T, P);
  auto R = s.solve();
  for (int(i) = (0); (i) < (n); (i)++) {
    for (int(j) = (0); (j) < (m); (j)++) {
      cout << (R[i][j] ? 1 : 0);
    }
    cout << endl;
  }
  return 0;
}
