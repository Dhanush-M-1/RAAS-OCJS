#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using pii = pair<int, int>;

int N, a[512];
using P = tuple<int, int, ll>;
map<P, int> done;

bool contain(int x, int s) {
  return (x & s) == x;
}

bool dfs(int cur, int lev, ll cnt) {
  if (lev < N && (cur & a[lev])) return 0;
  P p = P(cur, lev, cnt);
  if (done.count(p)) return 0;
  done[p]++;
  for (int i = 0; i < 16; i++) {
    ll c = (cnt >> (i*3)) & 7;
    cnt ^= c << (i*3);
    if (cur >> i & 1) c = 0;
    else c++;
    if (c == 7) return 0;
    cnt ^= c << (i*3);
  }
  if (lev == N) return 1;
  if (dfs(cur, lev+1, cnt)) return 1;
  if (contain(cur, 61166) && dfs(cur >> 1, lev+1, cnt)) return 1;
  if (contain(cur, 52428) && dfs(cur >> 2, lev+1, cnt)) return 1;
  if (contain(cur, 30583) && dfs(cur << 1, lev+1, cnt)) return 1;
  if (contain(cur, 13107) && dfs(cur << 2, lev+1, cnt)) return 1;
  if (contain(cur, 65520) && dfs(cur >> 4, lev+1, cnt)) return 1;
  if (contain(cur, 65280) && dfs(cur >> 8, lev+1, cnt)) return 1;
  if (contain(cur,  4095) && dfs(cur << 4, lev+1, cnt)) return 1;
  if (contain(cur,   255) && dfs(cur << 8, lev+1, cnt)) return 1;
  return 0;
}

void solve() {
  done.clear();
  cout << dfs(1632, 0, 0) << endl;
}

bool input() {
  cin >> N;
  if (N == 0) return 0;
  for (int i = 0; i < N; i++) {
    a[i] = 0;
    for (int j = 0; j < 16; j++) {
      int tmp;
      cin >> tmp;
      a[i] |= tmp << j;
    }
  }
  return 1;
}

int main() {
  cin.tie(0);
  ios_base::sync_with_stdio(false);
  cout << fixed << setprecision(10);

  while (input()) {
    solve();
  }

  return 0;
}
