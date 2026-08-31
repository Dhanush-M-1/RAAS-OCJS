#include <bits/stdc++.h>
using namespace std;
vector<int> graf[200100];
pair<int, pair<int, int>> tree[1 << 19];
pair<int, pair<int, int>> st[200100];
int depth = 1 << 18, n;
void dfs() {
  int str = 1;
  st[0] = make_pair(1, make_pair(0, 1));
  while (str > 0) {
    if (st[str - 1].second.first < graf[st[str - 1].first].size()) {
      ++st[str - 1].second.first;
      if (str < 2 ||
          st[str - 2].first !=
              graf[st[str - 1].first][st[str - 1].second.first - 1]) {
        st[str] =
            make_pair(graf[st[str - 1].first][st[str - 1].second.first - 1],
                      make_pair(0, 1));
        ++str;
      }
    } else {
      if (str == 1) return;
      st[str - 2].second.second += st[str - 1].second.second;
      if (st[str - 1].second.second % 2 == 0) {
        if (str >= 2) ++tree[st[str - 2].first + depth].first;
      } else {
        ++tree[st[str - 1].first + depth].first;
      }
      --str;
    }
  }
}
void rem(int del) {
  int i;
  for (int g = 0; g < graf[del].size(); ++g) {
    i = graf[del][g] + depth;
    --tree[i].first;
    while (i > 1) {
      i >>= 1;
      if (tree[i * 2].second.first == 0)
        tree[i] = tree[2 * i + 1];
      else if (tree[i * 2 + 1].second.first == 0)
        tree[i] = tree[2 * i];
      else {
        if (tree[2 * i].first == 0)
          tree[i] = tree[2 * i];
        else
          tree[i] = tree[2 * i + 1];
      }
    }
  }
  i = del + depth;
  tree[del + depth] = make_pair(0, make_pair(0, 0));
  while (i > 1) {
    i >>= 1;
    if (tree[i * 2].second.first == 0)
      tree[i] = tree[2 * i + 1];
    else if (tree[i * 2 + 1].second.first == 0)
      tree[i] = tree[2 * i];
    else {
      if (tree[2 * i].first == 0)
        tree[i] = tree[2 * i];
      else
        tree[i] = tree[2 * i + 1];
    }
  }
}
int main() {
  cin >> n;
  if (n % 2 == 0) {
    cout << "NO";
    return 0;
  }
  for (int i = 1; i <= n; ++i) {
    int i1;
    cin >> i1;
    if (i1 != 0) {
      graf[i].push_back(i1);
      graf[i1].push_back(i);
    }
  }
  cout << "YES\n";
  dfs();
  for (int i = 0; i <= n; ++i) {
    tree[depth + i].second.first = i;
  }
  for (int i = depth - 1; i >= 1; --i) {
    if (tree[i * 2].second.first == 0)
      tree[i] = tree[2 * i + 1];
    else if (tree[i * 2 + 1].second.first == 0)
      tree[i] = tree[2 * i];
    else {
      if (tree[2 * i].first == 0)
        tree[i] = tree[2 * i];
      else
        tree[i] = tree[2 * i + 1];
    }
  }
  for (int i = 0; i < n; ++i) {
    cout << tree[1].second.first << "\n";
    rem(tree[1].second.first);
  }
  return 0;
}
