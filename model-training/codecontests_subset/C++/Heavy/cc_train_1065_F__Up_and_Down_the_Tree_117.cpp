#include <bits/stdc++.h>
using namespace std;
long long int cons;
long long int check(long long int a) {
  if (a >= cons) a %= cons;
  return a;
}
long long int check2(long long int a) {
  a %= cons;
  if (a < 0) a += cons;
  return a;
}
long long int fast_check(long long int a) {
  if (a >= cons) a -= cons;
  return a;
}
long long int GCD(long long int a, long long int b) {
  while (a && b) {
    a = a % b;
    if (a != 0) b = b % a;
  }
  return a + b;
}
long long int exp(long long int a, long long int n) {
  long long int ans = 1;
  a = check(a);
  while (n) {
    if (n & 1) ans = check(ans * a);
    a = check(a * a);
    n = (n >> 1);
  }
  return ans;
}
void print_pair(pair<int, int> p) {
  cout << p.first << " " << p.second << endl;
}
long long int nc2(long long int a) { return (a * (a - 1)) / 2; }
const int N = 1e6 + 10;
int pa[21][N];
int direct[N];
int accu[N];
int sink[N];
int k, n;
bool isparent[N];
vector<int> graph[N];
int leaf[N];
int lift(int i, int k) {
  for (int j = 20; j >= 0; j--) {
    if ((1 << j) <= k && pa[j][i]) {
      i = pa[j][i];
      k -= (1 << j);
    }
  }
  assert(i > 0);
  return i;
}
void leafy(int i) {
  leaf[i] = 1e9;
  for (auto itr : graph[i]) {
    leafy(itr);
    leaf[i] = min(leaf[i], leaf[itr] + 1);
  }
  if (leaf[i] == 1e9) leaf[i] = 0;
}
void dfs(int i) {
  for (auto itr : graph[i]) {
    dfs(itr);
    if (leaf[itr] < k) {
      accu[i] += accu[itr];
      sink[i] = max(sink[i], sink[itr] - accu[itr]);
    } else
      sink[i] = max(sink[i], sink[itr]);
  }
  accu[i] += direct[i];
  sink[i] += accu[i];
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cons = 1e9 + 7;
  srand(time(NULL));
  cin >> n >> k;
  for (int i = 2; i <= n; i++) {
    cin >> pa[0][i];
    isparent[pa[0][i]] = true;
    graph[pa[0][i]].push_back(i);
  }
  for (int i = 1; i <= 20; i++)
    for (int j = 1; j <= n; j++) pa[i][j] = pa[i - 1][pa[i - 1][j]];
  for (int i = n; i >= 1; i--)
    if (!isparent[i]) direct[lift(i, k)]++;
  leafy(1);
  dfs(1);
  cout << max(accu[1], sink[1]);
  return 0;
}
