#include <bits/stdc++.h>
using namespace std;
long long INF = 1e18;
vector<vector<long long> > data;
vector<vector<long long> > money;
long long n, ai, bi;
vector<long long> a, b;
bool res = true;
long long dfs(long long vertex, long long ed) {
  long long balance = b[vertex] - a[vertex];
  for (long long i = 0; i < data[vertex].size(); i++) {
    long long to = data[vertex][i];
    balance -= dfs(to, money[vertex][i]);
    if (balance <= -INF) {
      res = false;
    }
    if (!res) {
      return 0;
    }
  }
  if (balance >= 0) {
    return -balance;
  }
  if (vertex == 0) {
    res = false;
    return 0;
  }
  long long max_wanted = INF / ed + 2;
  long long wanted = -balance;
  if (wanted > max_wanted) {
    res = false;
    return 0;
  }
  return (-balance * ed);
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cin >> n;
  for (long long i = 0; i < n; i++) {
    cin >> bi;
    b.push_back(bi);
  }
  for (long long i = 0; i < n; i++) {
    cin >> ai;
    a.push_back(ai);
  }
  for (long long i = 0; i < n; i++) {
    vector<long long> h1, h2;
    data.push_back(h1);
    money.push_back(h2);
  }
  for (long long i = 0; i < n - 1; i++) {
    cin >> ai >> bi;
    data[ai - 1].push_back(i + 1);
    money[ai - 1].push_back(bi);
  }
  dfs(0, -1);
  if (res)
    cout << "YES" << endl;
  else
    cout << "NO" << endl;
  return 0;
}
