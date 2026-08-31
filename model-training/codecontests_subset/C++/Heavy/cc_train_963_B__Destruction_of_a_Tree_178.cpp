#include <bits/stdc++.h>
using namespace std;
long long mod = 1000000009;
long long fastpow(int a, int b, int MOD) {
  long long x = 1, y = a;
  while (b > 0) {
    if (b % 2 == 1) {
      x = (x * y) % MOD;
    }
    y = (y * y) % MOD;
    b /= 2;
  }
  return x;
}
long long InverseEuler(int n, int MOD) { return fastpow(n, MOD - 2, MOD); }
vector<int> path[222000];
queue<int> one;
vector<int> ansdul, ansak;
int deg[222000], tmpdeg[222000], simdeg[222000];
bool removed[222000];
int N;
int main() {
  std::ios::sync_with_stdio(false);
  cin >> N;
  for (int i = 0; i < N; i++) {
    int x;
    cin >> x;
    if (x == 0) continue;
    x--;
    path[x].push_back(i);
    path[i].push_back(x);
    deg[x]++;
    deg[i]++;
  }
  if (N == 1) {
    cout << "YES" << endl;
    cout << 1 << endl;
    return 0;
  }
  for (int i = 0; i < N; i++) {
    tmpdeg[i] = deg[i];
    simdeg[i] = deg[i];
    if (deg[i] == 1) one.push(i);
  }
  while (one.size()) {
    int idx = one.front();
    one.pop();
    if (removed[idx]) continue;
    removed[idx] = true;
    if (tmpdeg[idx] % 2)
      ansak.push_back(idx);
    else {
      ansdul.push_back(idx);
      for (int x : path[idx]) {
        tmpdeg[x]--;
      }
    }
    deg[idx] = 0;
    for (int x : path[idx]) {
      deg[x]--;
      if (deg[x] == 1) one.push(x);
    }
  }
  reverse(ansak.begin(), ansak.end());
  for (int i : ansak) {
    ansdul.push_back(i);
  }
  for (int a : ansdul) {
    if (simdeg[a] % 2) {
      cout << "NO" << endl;
      return 0;
    }
    for (int x : path[a]) {
      simdeg[x]--;
    }
  }
  cout << "YES" << endl;
  for (int a : ansdul) cout << a + 1 << endl;
}
