#include <bits/stdc++.h>
using namespace std;
const int maxN = 1e6 + 10;
priority_queue<int> P;
priority_queue<int, vector<int>, greater<int> > mP;
long long gcd(long long a, long long b) {
  if (b == 0)
    return a;
  else
    return gcd(b, a % b);
}
int mod = 1000 * 1000 * 1000 + 7;
long long ksm(int a, int b) {
  if (b == 0) return 1LL;
  long long ret = 1, pp = a;
  while (b) {
    if (b % 2 == 1) {
      ret *= pp;
      ret %= mod;
    }
    b /= 2;
    pp = pp * pp % mod;
  }
  return ret;
}
int bit[maxN];
int lowbit(int x) { return x & (-x); }
void update(int i, int v) {
  while (i < maxN) {
    bit[i] += v;
    i += lowbit(i);
  }
}
int getsum(int i) {
  int x = 0;
  while (i > 0) {
    x += bit[i];
    i -= lowbit(i);
  }
  return x;
}
void change(int a, int b, int k) {
  update(a, k);
  update(b + 1, -k);
}
int father[maxN];
void init(int n) {
  for (int i = 1; i <= n; i++) father[i] = i;
  return;
}
int find(int v) {
  if (father[v] == v)
    return v;
  else
    return father[v] = find(father[v]);
}
void merge(int v, int u) {
  int t1 = find(v);
  int t2 = find(u);
  father[t2] = t1;
  return;
}
long long hashing(string s) {
  long long ans[2] = {1, 1};
  int p[2] = {402653189, 1610612741};
  for (int j = 0; j < 2; j++) {
    for (int i = 0; i < s.size(); i++) {
      ans[j] = ((ans[j] * 257) + s[i] - 'a') % p[j];
    }
  }
  return ans[0] * 2e10 + ans[1];
}
int e[maxN][2];
set<int> edge[maxN];
int cnt;
int n, m, k;
void del(queue<int>& q) {
  while (!q.empty()) {
    int i = q.front();
    q.pop();
    for (auto v : edge[i]) {
      if (edge[v].size() == k) {
        q.push(v);
        cnt--;
      }
      edge[v].erase(i);
    }
    edge[i].clear();
  }
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> n;
  cin >> m >> k;
  for (int i = 1; i <= m; i++) {
    int x, y;
    cin >> x >> y;
    e[i][0] = x;
    e[i][1] = y;
    edge[x].insert(y);
    edge[y].insert(x);
  }
  cnt = n;
  queue<int> q;
  for (int i = 1; i <= n; i++) {
    if (edge[i].size() < k) {
      q.push(i);
      cnt--;
    }
  }
  del(q);
  vector<int> ans;
  for (int i = m; i >= 1; i--) {
    ans.push_back(cnt);
    int x = e[i][0], y = e[i][1];
    queue<int> q;
    if (edge[x].find(y) != edge[x].end() && edge[x].size() == k) {
      q.push(x);
      edge[x].erase(y);
      cnt--;
    }
    edge[x].erase(y);
    if (edge[y].find(x) != edge[y].end() && edge[y].size() == k) {
      q.push(y);
      edge[y].erase(x);
      cnt--;
    }
    edge[y].erase(x);
    del(q);
  }
  reverse(ans.begin(), ans.end());
  for (auto c : ans) cout << c << endl;
  return 0;
}
