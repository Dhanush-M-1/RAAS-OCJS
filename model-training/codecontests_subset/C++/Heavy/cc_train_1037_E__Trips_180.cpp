#include <bits/stdc++.h>
using namespace std;
const int INFTY = 20000000;
const int MAX = 500100;
const int MOD = 10000000;
void coutTab(int* tab, int n) {
  for (int i = 0; i < n; i++) {
    cout << tab[i] << " ";
  }
  cout << "\n";
}
int n, m, k;
vector<set<int> > G(MAX);
int s[MAX];
bool was[MAX];
pair<int, int> E[MAX];
int res[MAX];
void addToQueue(queue<int>& Q, int i) {
  if (s[i] < k && !was[i]) {
    was[i] = 1;
    Q.push(i);
  }
}
int main() {
  ios_base::sync_with_stdio(0);
  cin >> n >> m >> k;
  for (int i = 0; i < m; i++) {
    cin >> E[i].first >> E[i].second;
    E[i].first--;
    E[i].second--;
    G[E[i].first].insert(E[i].second);
    G[E[i].second].insert(E[i].first);
  }
  for (int i = 0; i < n; i++) s[i] = (G[i]).size();
  queue<int> Q;
  int cur = n;
  for (int i = 0; i < n; i++) addToQueue(Q, i);
  for (int i = 0; i < m; i++) {
    while (!Q.empty()) {
      int j = Q.front();
      Q.pop();
      for (auto l : G[j]) {
        s[l]--;
        addToQueue(Q, l);
      }
      cur--;
    }
    res[i] = cur;
    pair<int, int> lst = E[m - i - 1];
    G[lst.first].erase(lst.second);
    G[lst.second].erase(lst.first);
    if (!was[lst.second]) s[lst.first]--;
    if (!was[lst.first]) s[lst.second]--;
    addToQueue(Q, lst.first);
    addToQueue(Q, lst.second);
  }
  reverse(res, res + m);
  for (int i = 0; i < m; i++) cout << res[i] << "\n";
}
