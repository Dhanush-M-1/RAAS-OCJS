#include <bits/stdc++.h>
using namespace std;
bool b2(const pair<pair<int, int>, int> &p1,
        const pair<pair<int, int>, int> &p2) {
  return p1.first.first > p2.first.first;
}
bool b1(const pair<pair<int, int>, int> &p1,
        const pair<pair<int, int>, int> &p2) {
  return p1.first.second < p2.first.second;
}
bool bbk(vector<pair<int, int>> &v1, vector<pair<int, int>> &v2) {
  return v1.size() < v2.size();
}
int n;
vector<int> v[100005];
bool check = true;
void solve() {
  for (long long int i = 1; i <= n; i++) {
    if (v[i].size() == 2) {
      check = false;
      break;
    }
  }
}
int main() {
  cin >> n;
  int a, b;
  for (long long int i = 1; i <= n - 1; i++) {
    cin >> a >> b;
    v[a].push_back(b);
    v[b].push_back(a);
  }
  solve();
  if (check)
    cout << "YES" << endl;
  else
    cout << "NO" << endl;
  return 0;
}
