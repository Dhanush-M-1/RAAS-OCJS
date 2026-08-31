#include<bits/stdc++.h>
using namespace std;

enum Order {DEC, EQL, INC};
int memo[501][10][500][3][2];

const vector<int> vec(const string& s) {
  vector<int> res;
  for(const auto& c: s) res.insert(begin(res), c - '0');
  return res;
}

bool zigzag(const string& s, int M) {
  auto n = vec(s);
  for(int i = 1; i < n.size(); ++i) if(n[i - 1] == n[i]) return false;
  for(int i = 2; i < n.size(); ++i) {
    if(n[i - 2] < n[i - 1] && n[i - 1] < n[i]) return false;
    if(n[i - 2] > n[i - 1] && n[i - 1] > n[i]) return false;
  }
  int r = 0;
  int m = 1 % M;
  for(const auto& i: n) {
    r = (r + i * m) % M;
    m = (10 * m) % M;
  }
  return !r;
}

// Return n * 10^d mod M.
int remain(int n, int d, int M) {
  static vector<int> base = {1};
  while(base.size() <= d) base.push_back((base.back() * 10) % M);
  return (n * base[d]) % M;
}

int rec(const vector<int>& n, int M, int d, int i, int r, int ord, int eql) {
  if(memo[d][i][r][ord][eql]) return memo[d][i][r][ord][eql];
  if(!d) return !r;
  int res = 0;
  if(eql) {
    if(ord == INC && i > n[d-1]) res += rec(n, M, d-1, n[d-1], (r + remain(n[d-1], d-1, M)) % M, DEC, 1);
    if(ord == DEC && i < n[d-1]) res += rec(n, M, d-1, n[d-1], (r + remain(n[d-1], d-1, M)) % M, INC, 1);
    for(int j = 0; j < n[d-1]; ++j) {
      if(ord == INC && i > j) res += rec(n, M, d-1, j, (r + remain(j, d-1, M)) % M, DEC, 0);
      if(ord == DEC && i < j) res += rec(n, M, d-1, j, (r + remain(j, d-1, M)) % M, INC, 0);
    }
  } else {
    if(ord == EQL) {
      if(d == 1) {
        for(int j = 0; j < 10; ++j) if(!(j % M)) ++res;
      } else {
        res += rec(n, M, d-1, 0, 0, EQL, 0);
        for(int j = 1; j < 10; ++j) {
          res += rec(n, M, d-1, j, remain(j, d-1, M), DEC, 0);
          res += rec(n, M, d-1, j, remain(j, d-1, M), INC, 0);
        }
      }
    } else {
      for(int j = 0; j < 10; ++j) {
        if(ord == INC && i > j) res += rec(n, M, d-1, j, (r + remain(j, d-1, M)) % M, DEC, 0);
        if(ord == DEC && i < j) res += rec(n, M, d-1, j, (r + remain(j, d-1, M)) % M, INC, 0);
      }
    }
  }
  return memo[d][i][r][ord][eql] = (res % 10000);
}

int count(const string& s, int M) {
  auto n = vec(s);
  int res = 0;
  for(int d = 0; d < n.size(); ++d) for(int i = 0; i < 10; ++i) for(int r = 0; r < M; ++r) for(int ord: {DEC, INC, EQL}) for(int eql: {0, 1}) memo[d][i][r][ord][eql] = 0;
  if(n.size() == 1) {
    for(int i = 0; i <= n.front(); ++i) res += !(i % M);
  } else {
    int d = n.size() - 1;
    res += rec(n, M, d, n[d], remain(n[d], d, M), INC, 1);
    res += rec(n, M, d, n[d], remain(n[d], d, M), DEC, 1);
    res += rec(n, M, d, 0, 0, EQL, 0);
    for(int i = 1; i < n[d]; ++i) {
      res += rec(n, M, d, i, remain(i, d, M), INC, 0);
      res += rec(n, M, d, i, remain(i, d, M), DEC, 0);
    }
  }
  return res % 10000;
}

int main() {
  string A, B;
  int M;
  cin >> A >> B >> M;
  cout << (count(B, M) - count(A, M) + (zigzag(A, M) ? 1 : 0) + 10000) % 10000 << endl;
}