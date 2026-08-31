#include <bits/stdc++.h>
using namespace std;
int main(int agrc, char* argv[]) {
  int n, m, k;
  scanf("%d %d %d", &n, &m, &k);
  std::vector<std::vector<int>> edges(n + 1);
  int selected[n];
  for (int i = 0; i < n; ++i) {
    selected[i] = 1;
  }
  int total = n;
  int friends[m][2];
  for (int i = 0; i < m; ++i) {
    scanf("%d %d", &friends[i][0], &friends[i][1]);
    --friends[i][0];
    --friends[i][1];
    edges[friends[i][0]].push_back(friends[i][1]);
    edges[friends[i][1]].push_back(friends[i][0]);
  }
  int friends_going[n];
  for (int i = 0; i < n; ++i) {
    friends_going[i] = edges[i].size();
  }
  for (int i = 0; i < n; ++i) {
    std::stack<int> rejected;
    rejected.push(i);
    while (!rejected.empty()) {
      int index = rejected.top();
      rejected.pop();
      if (!(selected[index] == 1 && friends_going[index] < k)) {
        continue;
      }
      selected[index] = 0;
      --total;
      for (int j : edges[index]) {
        --friends_going[j];
        rejected.push(j);
      }
    }
  }
  int answer[m];
  answer[m - 1] = total;
  for (int i = m - 2; i >= 0; --i) {
    int first = friends[i + 1][0], second = friends[i + 1][1];
    edges[first].pop_back();
    edges[second].pop_back();
    if (selected[second] == 1) {
      --friends_going[first];
    }
    if (selected[first]) {
      --friends_going[second];
    }
    std::stack<int> rejected;
    rejected.push(first);
    rejected.push(second);
    while (!rejected.empty()) {
      int index = rejected.top();
      rejected.pop();
      if (!(selected[index] == 1 && friends_going[index] < k)) {
        continue;
      }
      selected[index] = 0;
      --total;
      for (int j : edges[index]) {
        --friends_going[j];
        rejected.push(j);
      }
    }
    answer[i] = total;
  }
  for (int i = 0; i < m; i++) {
    printf("%d\n", answer[i]);
  }
}
