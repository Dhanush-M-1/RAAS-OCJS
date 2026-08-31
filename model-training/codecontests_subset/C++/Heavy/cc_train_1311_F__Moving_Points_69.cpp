#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 10, inf = 1e9;
const long long mod = (long long)1e9 + 7;
set<int> setV;
map<int, int> idV;
pair<int, int> p[N];
int n;
int treenum[N], num;
long long treesum[N], sum;
long long qry(long long tree[], int id) {
  long long ans = 0LL;
  for (; id; id -= (id & (-id))) ans += tree[id];
  return ans;
}
int qry(int tree[], int id) {
  int ans = 0LL;
  for (; id; id -= (id & (-id))) ans += tree[id];
  return ans;
}
int GetNum(int v) { return num - qry(treenum, idV[v] - 1); }
long long GetSum(int v) { return sum - qry(treesum, idV[v] - 1); }
void upd(int tree[], int id, int val) {
  for (; id < N; id += (id & -id)) tree[id] += val;
}
void upd(long long tree[], int id, int val) {
  for (; id < N; id += (id & -id)) tree[id] += val;
}
void Update(int v, int x) {
  upd(treenum, idV[v], +1);
  upd(treesum, idV[v], +x);
  num++;
  sum += x;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cin >> n;
  for (int i = 1; i <= n; ++i) {
    cin >> p[i].first;
  }
  for (int i = 1; i <= n; ++i) {
    cin >> p[i].second;
    setV.insert(p[i].second);
  }
  sort(p + 1, p + n + 1);
  int k = 0;
  for (int x : setV) idV[x] = ++k;
  num = 0;
  sum = 0LL;
  long long ans = 0LL;
  for (int i = n; i >= 1; --i) {
    int m = GetNum(p[i].second);
    long long y = GetSum(p[i].second);
    ans += y - 1LL * m * p[i].first;
    Update(p[i].second, p[i].first);
  }
  cout << ans << endl;
}
