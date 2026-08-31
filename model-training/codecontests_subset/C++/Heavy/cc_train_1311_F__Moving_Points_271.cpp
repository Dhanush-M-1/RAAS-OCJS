#include <bits/stdc++.h>
using namespace std;
int N;
pair<signed long long, signed long long> P[202020];
pair<signed long long, signed long long> Q[202020];
template <class V, int ME>
class BIT {
 public:
  V bit[1 << ME];
  V operator()(int e) {
    if (e < 0) return 0;
    V s = 0;
    e++;
    while (e) s += bit[e - 1], e -= e & -e;
    return s;
  }
  void add(int e, V v) {
    e++;
    while (e <= 1 << ME) bit[e - 1] += v, e += e & -e;
  }
};
BIT<signed long long, 20> bt, bt2;
void solve() {
  int i, j, k, l, r, x, y;
  string s;
  cin >> N;
  for (i = 0; i < (N); i++) cin >> P[i].first;
  for (i = 0; i < (N); i++) cin >> P[i].second;
  sort(P, P + N);
  signed long long ret = 0;
  for (i = 0; i < (N); i++) Q[i] = {P[i].second, i};
  sort(Q, Q + N);
  for (i = 0; i < (N); i++) {
    ret += bt(Q[i].second) * P[Q[i].second].first;
    bt.add(Q[i].second, 1);
  }
  reverse(Q, Q + N);
  for (i = 0; i < (N); i++) {
    ret -= (bt2(N) - bt2(Q[i].second)) * P[Q[i].second].first;
    bt2.add(Q[i].second, 1);
  }
  cout << ret << endl;
}
int main(int argc, char** argv) {
  string s;
  int i;
  if (argc == 1) ios::sync_with_stdio(false), cin.tie(0);
  for (i = 0; i < (argc - 1); i++) s += argv[i + 1], s += '\n';
  for (i = 0; i < (s.size()); i++) ungetc(s[s.size() - 1 - i], stdin);
  cout.tie(0);
  solve();
  return 0;
}
