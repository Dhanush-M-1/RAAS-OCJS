#include <bits/stdc++.h>
using namespace std;
template <class T>
bool uin(T &a, T b) {
  return a > b ? (a = b, true) : false;
}
template <class T>
bool uax(T &a, T b) {
  return a < b ? (a = b, true) : false;
}
const long long maxn = 2 * (long long)1e5 + 1000;
long long t, n, m, a, b, o1, o2;
void bfs1(const vector<vector<long long> > &e1, vector<long long> &vis1) {
  queue<long long> q;
  q.push(b);
  vis1[b] = 1;
  while (!q.empty()) {
    long long now = q.front();
    q.pop();
    for (auto it : e1[now]) {
      if (vis1[it]) continue;
      vis1[it] = 1;
      q.push(it);
    }
  }
}
void bfs2(const vector<vector<long long> > &e2, vector<long long> &vis2) {
  queue<long long> q;
  q.push(a);
  vis2[a] = 1;
  while (!q.empty()) {
    long long now = q.front();
    q.pop();
    for (auto it : e2[now]) {
      if (vis2[it]) continue;
      vis2[it] = 1;
      q.push(it);
    }
  }
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.precision(10);
  cout << fixed;
  cin >> t;
  while (t--) {
    bool flag = true;
    cin >> n >> m >> a >> b;
    vector<vector<long long> > e1(n);
    vector<vector<long long> > e2(n);
    --a;
    --b;
    vector<long long> vis1(n, 0);
    vector<long long> vis2(n, 0);
    set<long long> res1;
    set<long long> res2;
    for (int i = 0; i < (int)(m); ++i) {
      cin >> o1 >> o2;
      --o1;
      --o2;
      if (o1 != a && o2 != a) {
        e1[o1].push_back(o2);
        e1[o2].push_back(o1);
      }
      if (o1 != b && o2 != b) {
        e2[o1].push_back(o2);
        e2[o2].push_back(o1);
      }
    }
    bfs1(e1, vis1);
    for (int i = 0; i < (int)(n); ++i) {
      if (!vis1[i]) res1.insert(i);
    }
    for (int i = 0; i < (int)(n); ++i) cerr << vis1[i] << " ";
    cerr << endl;
    bfs2(e2, vis2);
    for (int i = 0; i < (int)(n); ++i) {
      if (!vis2[i]) res2.insert(i);
    }
    for (int i = 0; i < (int)(n); ++i) cerr << vis2[i] << " ";
    cerr << endl;
    long long num1 = res1.size();
    long long num2 = res2.size();
    long long temp = (num1 - 1) * (num2 - 1);
    cout << temp << '\n';
  }
  return 0;
}
