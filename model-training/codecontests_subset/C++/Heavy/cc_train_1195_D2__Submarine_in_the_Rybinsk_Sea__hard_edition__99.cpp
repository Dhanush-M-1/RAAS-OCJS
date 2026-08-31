#include <bits/stdc++.h>
using namespace std;
int N;
vector<signed long long> V[12];
signed long long p10[12];
signed long long mo = 998244353;
pair<vector<signed long long>, vector<signed long long>> hoge(int a, int b) {
  vector<signed long long> A, B;
  signed long long p = 1;
  while (a && b) {
    B.push_back(p);
    p = p * 10 % mo;
    A.push_back(p);
    p = p * 10 % mo;
    a--, b--;
  }
  while (a--) {
    A.push_back(p);
    p = p * 10 % mo;
  }
  while (b--) {
    B.push_back(p);
    p = p * 10 % mo;
  }
  return {A, B};
}
void solve() {
  int i, j, k, l, r, x, y;
  string s;
  p10[0] = 1;
  for (i = 0; i < (11); i++) p10[i + 1] = p10[i] * 10;
  cin >> N;
  for (i = 0; i < (N); i++) {
    cin >> x;
    for (j = 0; j < (11); j++)
      if (x < p10[j]) break;
    V[j].push_back(x);
  }
  signed long long ret = 0;
  for (i = 1; i <= 10; i++) {
    for (j = 1; j <= 10; j++) {
      auto P = hoge(i, j);
      for (auto& v : V[i]) {
        signed long long a = v;
        for (auto& p : P.first) {
          ret += a % 10 * p % mo * V[j].size() % mo;
          a /= 10;
        }
      }
      for (auto& v : V[j]) {
        signed long long a = v;
        for (auto& p : P.second) {
          ret += a % 10 * p % mo * V[i].size() % mo;
          a /= 10;
        }
      }
    }
  }
  cout << ret % mo << endl;
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
