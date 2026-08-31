#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 1000, mod = 1e9 + 7;
vector<int> vec[N];
long long bin_pow(int x, int y) {
  if (y == 0) return 1;
  if (y == 1) return x;
  if (y % 2 == 0) {
    long long z = bin_pow(x, y / 2);
    return (z * z) % mod;
  }
  return (bin_pow(x, y - 1) * x) % mod;
}
bool check(int x) {}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n;
  cin >> n;
  for (int i = 1; i < n; i++) {
    int x, y;
    cin >> x >> y;
    vec[x].push_back(y);
    vec[y].push_back(x);
  }
  int k = 0;
  for (int i = 1; i <= n; i++) {
    if (vec[i].size() == 2) {
      cout << "NO";
      return 0;
    }
  }
  cout << "YES";
  return 0;
}
