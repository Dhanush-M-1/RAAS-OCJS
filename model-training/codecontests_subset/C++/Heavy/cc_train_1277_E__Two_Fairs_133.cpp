#include <bits/stdc++.h>
using namespace std;
const int MAX_N = 200005;
int visited_a[MAX_N];
int visited_b[MAX_N];
vector<int> route[MAX_N];
int n, m, a, b;
int main() {
  int test_case_num = 0;
  cin >> test_case_num;
  for (int test_case = 1; test_case <= test_case_num; test_case++) {
    cin >> n >> m >> a >> b;
    set<int> a_neighbor;
    set<int> b_neighbor;
    set<int> ab_neighbor;
    for (int i = 0; i <= n; i++) {
      route[i].clear();
    }
    for (int i = 0; i < m; i++) {
      int temp1, temp2;
      cin >> temp1 >> temp2;
      route[temp1].push_back(temp2);
      route[temp2].push_back(temp1);
    }
    {
      queue<int> q;
      q.push(a);
      visited_a[a] = test_case;
      while (!q.empty()) {
        int cur = q.front();
        q.pop();
        for (vector<int>::iterator it = route[cur].begin();
             it != route[cur].end(); it++) {
          if (*it != b && visited_a[*it] != test_case) {
            visited_a[*it] = test_case;
            q.push(*it);
            a_neighbor.insert(*it);
          }
        }
      }
    }
    {
      queue<int> q;
      q.push(b);
      visited_b[b] = test_case;
      while (!q.empty()) {
        int cur = q.front();
        q.pop();
        for (vector<int>::iterator it = route[cur].begin();
             it != route[cur].end(); it++) {
          if (*it != a && visited_b[*it] != test_case) {
            visited_b[*it] = test_case;
            q.push(*it);
            b_neighbor.insert(*it);
          }
        }
      }
    }
    for (set<int>::iterator it = a_neighbor.begin(); it != a_neighbor.end();
         it++) {
      if (b_neighbor.find(*it) != b_neighbor.end()) {
        ab_neighbor.insert(*it);
      }
    }
    cout << (unsigned long long)((unsigned long long)a_neighbor.size() -
                                 (unsigned long long)ab_neighbor.size()) *
                ((unsigned long long)b_neighbor.size() -
                 (unsigned long long)ab_neighbor.size())
         << endl;
  }
  return 0;
}
