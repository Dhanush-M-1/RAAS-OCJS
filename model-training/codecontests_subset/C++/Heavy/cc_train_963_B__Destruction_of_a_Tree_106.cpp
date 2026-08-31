#include <bits/stdc++.h>
using namespace std;
vector<long long int> v[200005];
long long int degree[200005], vis2[200005];
deque<long long int> dq2;
void DFS2(long long int x) {
  if (vis2[x]) {
    return;
  }
  vis2[x] = 1;
  long long int i;
  dq2.push_back(x);
  for (i = 0; i < v[x].size(); i++) {
    DFS2(v[x][i]);
  }
}
void DFS1(long long int x, long long int par) {
  long long int i;
  for (i = 0; i < v[x].size(); i++) {
    DFS1(v[x][i], x);
  }
  if (!(degree[x] % 2)) {
    DFS2(x);
    degree[par]--;
  }
}
int main(void) {
  long long int i, n, x, size = 0, lol;
  cin >> n;
  for (i = 1; i <= n; i++) {
    cin >> x;
    if (x != 0) {
      v[x].push_back(i);
      degree[i]++;
      degree[x]++;
    } else {
      lol = i;
    }
  }
  if (!(n % 2)) {
    cout << "NO\n";
    return 0;
  }
  DFS1(lol, 200002);
  cout << "YES\n";
  while (!dq2.empty()) {
    cout << dq2.front() << "\n";
    dq2.pop_front();
  }
  return 0;
}
