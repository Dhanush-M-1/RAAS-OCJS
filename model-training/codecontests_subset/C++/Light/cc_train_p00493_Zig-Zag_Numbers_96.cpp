#include <bits/stdc++.h>
using namespace std;

const int MOD = 1e4;
int memo[501][10][2][2][500];
string S;
int N, M;

int dfs(int i, int p, bool up, bool tight, int tot) {
  if (i == N) return tot == 0;
  int& r = memo[i][p][up][tight][tot];
  if (r != -1) return r;
  int x = S[i] - '0';
  int L = 0, R = 10;
  if (up) {
    L = p + 1;
  } else {
    R = p;
  }
  if (tight) R = min(R, x + 1);
  r = 0;
  for (int j = L; j < R; j++) {
    r += dfs(i + 1, j, !up, tight && j == x, (10 * tot + j) % M);
  }
  return r %= MOD;
}

int solve(string s) {
  S = s;
  N = s.size();
  memset(memo, -1, sizeof(memo));
  int r = 0;
  for (int k = 0; k < N; k++) {
    int x = S[k] - '0';
    int L = 1, R = 10;
    if (k == 0) R = min(R, x + 1);
    for (int i = L; i < R; i++) {
      bool tight = k == 0 && i == x;
      r += dfs(k + 1, i, 1, tight, i % M);
      if (k < N - 1) { r += dfs(k + 1, i, 0, tight, i % M); }
    }
    r %= MOD;
  }
  return r;
}

string decr(string s) {
  for (int i = s.size() - 1; i >= 0 && s[i]-- == '0'; s[i++] = '9');
  return s.substr(s.size() > 1 && s[0] == '0');
}

int main() {
  string A, B;
  cin >> A >> B >> M;
  cout << (solve(B) + MOD - solve(decr(A))) % MOD << endl;
}