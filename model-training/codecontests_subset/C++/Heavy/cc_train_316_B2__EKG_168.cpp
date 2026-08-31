#include <bits/stdc++.h>
using namespace std;
int main(int argc, char const *argv[]) {
  int n, x;
  cin >> n >> x;
  vector<vector<int> > adj;
  adj.resize(n + 1);
  map<int, int> A;
  int a[n + 1];
  int s;
  for (int i = 0; i < n; ++i) {
    a[i + 1] = 0;
  }
  for (int i = 1; i <= n; ++i) {
    cin >> s;
    if (s != 0) {
      adj[i].push_back(s);
      a[s] = 1;
    }
  }
  vector<int> elements;
  if (adj[x].size() == 0) {
    A[1]++;
  }
  for (int i = 1; i <= n; ++i) {
    int cnt = 1;
    int d = 0;
    if (a[i] == 0) {
      s = i;
      while (adj[s].size() != 0) {
        if (s == x) {
          d = 1;
          cnt = 2;
          s = adj[x][0];
        } else {
          cnt++;
          s = adj[s][0];
        }
      }
      if (d == 0 && s != x) {
        elements.push_back(cnt);
      } else if (d == 1) {
        A[cnt]++;
      }
    }
  }
  for (int i = 0; i < elements.size(); ++i) {
    vector<int> add;
    for (map<int, int>::iterator it = A.begin(); it != A.end(); ++it) {
      add.push_back(it->first + elements[i]);
    }
    for (int j = 0; j < add.size(); ++j) {
      A[add[j]]++;
    }
  }
  for (map<int, int>::iterator it = A.begin(); it != A.end(); ++it) {
    cout << it->first << endl;
  }
  return 0;
}
