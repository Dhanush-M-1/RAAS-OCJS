#include <bits/stdc++.h>
using namespace std;
long long n, m, q, k;
string s;
int MOD = 1e9 + 7;
const int INF = 1e9;
const long long INF64 = 2e18;
const double PI = 3.141592653589793238463;
long long ar[500004], br[500004], vis[500004];
map<int, int> cmap[5004];
vector<long long> gr[500004], vec;
set<long long> myset;
map<string, long long> mymap;
string st1[3004];
vector<long long> arr[500004];
int comp(pair<long long, long long> a, pair<long long, long long> b) {
  return a.second < b.second;
}
int mycomp1(long long a, long long b) { return a > b; }
int gcd(int a, int b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
long long A[1000][1000], B[1000][1000];
int main() {
  std::ios_base::sync_with_stdio(false);
  cin >> n >> m;
  for (int i = 0; i < int(n); i++) cin >> ar[i];
  for (int i = 0; i < int(m); i++) {
    long long u, v;
    cin >> u >> v;
    gr[u].push_back(v);
  }
  reverse(ar, ar + n);
  long long c = 0;
  for (int i = 1; i < n; i++) {
    long long r = ar[i], cc = 0;
    for (int j = 0; j < gr[r].size(); j++) {
      if (gr[r][j] == ar[0] || br[gr[r][j]]) cc++;
    }
    if (cc != c + 1) {
      br[r] = 1;
      c++;
    }
  }
  return cout << n - 1 - c, 0;
}
