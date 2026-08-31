#include <bits/stdc++.h>
using namespace std;
map<long long, int> cache;
vector<long long> catalog[1000000];
int len = 0;
vector<long long> way[50];
int t;
void precomp() {
  int pos = 3 * 3 * 3 * 3 * 3 * 3;
  for (int i = 0; i < pos; i++) {
    int c = i;
    vector<int> moo;
    int s = 0;
    for (int j = 0; j < 6; j++) {
      moo.push_back(3 * (c % 3) + (c % 3 != 0));
      c /= 3;
      s += moo[j];
    }
    if (way[s].empty()) {
      for (int j = 0; j < 6; j++) {
        way[s].push_back(moo[j]);
      }
    }
  }
  len++;
  for (int i = 0; i < 6; i++) {
    catalog[len].push_back(0);
  }
  cache[0] = len;
}
bool solve(long long n) {
  if (cache.count(n) == 1) {
    if (cache[n] == -1) return false;
    return true;
  }
  for (int d = n % 10; d <= 42; d += 10) {
    if (way[d].empty()) continue;
    if (d > n) continue;
    if (solve((n - d) / 10)) {
      int moo = cache[(n - d) / 10];
      len++;
      for (int j = 0; j < 6; j++) {
        catalog[len].push_back(catalog[moo][j] * 10 + way[d][j]);
      }
      cache[n] = len;
      return true;
    }
  }
  cache[n] = -1;
  return false;
}
int main() {
  precomp();
  cin >> t;
  for (int i = 0; i < t; i++) {
    long long n;
    cin >> n;
    if (!solve(n)) {
      printf("%d\n", -1);
    } else {
      int sol = cache[n];
      cout << catalog[sol][0] << " " << catalog[sol][1] << " "
           << catalog[sol][2] << " " << catalog[sol][3] << " "
           << catalog[sol][4] << " " << catalog[sol][5] << "\n";
    }
  }
}
