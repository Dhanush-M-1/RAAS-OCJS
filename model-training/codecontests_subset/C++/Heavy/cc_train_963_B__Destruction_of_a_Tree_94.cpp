#include <bits/stdc++.h>
using namespace std;
bool vowel(char che) {
  if (che == 'A' || che == 'E' || che == 'I' || che == 'O' || che == 'U' ||
      che == 'Y')
    return true;
  else
    return false;
}
const int N = 2e5 + 5;
const int mod = 1e9 + 7;
long long a[N], b[N], c[N], d, dis, dp[N], dg[N], pd[N];
pair<long long, long long> p;
vector<long long> vt[N], vm[N], vs;
stack<long long> st;
string s, s1;
char o;
bool mark[N], mark1[N], h;
long long n1 = 0;
void dfs(long long v, long long k, long long f) {
  pd[v] = k;
  vm[f].push_back(v);
  n1 = max(n1, f);
  f += 1;
  for (int i = 0; i < vt[v].size(); i++) {
    if (vt[v][i] != k) dfs(vt[v][i], v, f);
  }
}
void dst(long long v, long long k) {
  mark1[v] = true;
  dg[k]--;
  vs.push_back(v);
  for (int i = 0; i < vt[v].size(); i++) {
    if (vt[v][i] != k && !mark1[vt[v][i]]) dst(vt[v][i], v);
  }
}
int main() {
  long long t = 0, n, m = 0, k = 0, f = 0, sum = 0, ans = 0;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> m;
    if (m) {
      vt[i].push_back(m);
      vt[m].push_back(i);
    }
  }
  for (int i = 1; i <= n; i++) {
    dg[i] = vt[i].size();
  }
  if (n % 2 == 0)
    cout << "NO\n";
  else {
    cout << "YES\n";
    dfs(1, 0, 0);
    for (int i = n1; i >= 0; i--) {
      for (int j = 0; j < vm[i].size(); j++) {
        m = vm[i][j];
        if (dg[m] % 2 == 0) dst(m, pd[m]);
      }
    }
    for (auto x : vs) {
      cout << x << endl;
    }
  }
}
