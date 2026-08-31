#include <bits/stdc++.h>
const int M = 1e9 + 7;
void MultL(long long int &a, long long int b) { a = (a * b) % M; }
void AddL(long long int &a, long long int b) { a = (a + (b + M)) % M; }
long long int Mult(long long int a, long long int b) { return (a * b) % M; }
long long int Add(long long int a, long long int b) {
  return (a + (b + M)) % M;
}
using namespace std;
int SIZE = 50;
vector<int> gaps;
vector<int> cost;
int n, m, k;
vector<bool> field;
vector<int> pre;
int good(int p) {
  int cover = 0;
  int res = 0;
  while (cover < field.size()) {
    if (!field[cover]) {
      if (pre[cover] == -1) {
        return -1;
      }
      int new_cover = pre[cover] + p + 1;
      if (new_cover <= cover) {
        return -1;
      }
      cover = new_cover;
      ++res;
      continue;
    }
    cover += p + 1;
    ++res;
  }
  return res;
}
int main() {
  std::ios::sync_with_stdio(false);
  cin >> n >> m >> k;
  gaps = vector<int>(m);
  cost = vector<int>(k);
  for (int i = 0; i < m; ++i) cin >> gaps[i];
  for (int i = 0; i < k; ++i) cin >> cost[i];
  field = vector<bool>(n, true);
  pre = vector<int>(n, -1);
  for (int i = 0; i < m; ++i) {
    field[gaps[i]] = false;
  }
  int last_av = -1;
  for (int i = 0; i < field.size(); ++i) {
    if (field[i]) {
      last_av = i;
    } else {
      pre[i] = last_av;
    }
  }
  long long int res = -1;
  for (int i = 0; i < k; ++i) {
    long long int curr = good(i);
    if (curr == -1) {
      continue;
    }
    if (res == -1) {
      res = cost[i] * curr;
      continue;
    }
    res = min(res, cost[i] * curr);
  }
  cout << res << endl;
  return 0;
}
