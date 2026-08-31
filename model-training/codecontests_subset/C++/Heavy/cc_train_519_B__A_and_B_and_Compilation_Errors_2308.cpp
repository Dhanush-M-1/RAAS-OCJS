#include <bits/stdc++.h>
using namespace std;
long long n, m, x, y, z, k, sol, sum, ans, l, r, xx, yy, a[1000000], b[1000000],
    d[1000000], c[1000000];
vector<long long> v[2000];
vector<pair<long long, long long>> v1;
vector<pair<long long, long long>> v2;
pair<long long, pair<long long, long long>> pp[1000000];
pair<long long, long long> p[1000000];
map<long long, vector<long long>> ma;
map<long long, long long> m1;
map<long long, long long> m2;
string s1, s2, s;
int main() {
  cin >> n;
  for (int i = 0; i < n; i++) cin >> a[i], m1[a[i]]++;
  for (int i = 0; i < n - 1; i++) cin >> b[i], m2[b[i]]++;
  for (int i = 0; i < n - 2; i++) cin >> c[i];
  for (int i = 0; i < n - 1; i++) m1[b[i]]--;
  for (int i = 0; i < n - 2; i++) m2[c[i]]--;
  for (int i = 0; i < n; i++) {
    if (m1[a[i]]) {
      x = a[i];
      break;
    }
  }
  for (int i = 0; i < n - 1; i++) {
    if (m2[b[i]]) {
      y = b[i];
      break;
    }
  }
  cout << x << " " << y << endl;
  return 0;
}
