#include <bits/stdc++.h>
using namespace std;
vector<pair<int, int> > blocks;
char used[128];
int n;
int Malloc(int v) {
  for (int i = 0; i < n; i++) {
    bool ok = 1;
    for (int j = 0; j < v; j++) {
      if (i + j >= n || used[i + j]) {
        ok = 0;
        break;
      }
    }
    if (ok) {
      for (int j = 0; j < v; j++) {
        used[i + j] = 1;
      }
      blocks.push_back(pair<int, int>(i, v));
      return blocks.size();
    }
  }
  return -1;
}
int Erase(int id) {
  id--;
  if (id < 0 || id >= blocks.size()) return -1;
  pair<int, int>& b = blocks[id];
  if (b.first == -1) return -1;
  for (int i = 0; i < b.second; i++) {
    used[b.first + i] = 0;
  }
  b.first = -1;
  return 0;
}
void Defragment() {
  map<int, char> was;
  int cn = blocks.size();
  int last = 0;
  while (cn > 0) {
    int bi = -1;
    for (int i = 0; i < blocks.size(); i++) {
      if (was[i]) continue;
      if (bi == -1 || blocks[i].first < blocks[bi].first) {
        bi = i;
      }
    }
    cn--;
    was[bi] = 1;
    if (blocks[bi].first == -1) continue;
    blocks[bi].first = last;
    last += blocks[bi].second;
  }
  memset(used, 0, sizeof(used));
  for (int i = 0; i < last; i++) {
    used[i] = 1;
  }
}
int main() {
  int t;
  scanf("%d%d", &t, &n);
  for (int i = 0; i < t; i++) {
    string cmd;
    int p;
    cin >> cmd;
    if (cmd == "alloc") {
      cin >> p;
      int r = Malloc(p);
      if (r == -1)
        cout << "NULL";
      else
        cout << r;
      cout << endl;
    } else if (cmd == "erase") {
      cin >> p;
      int r = Erase(p);
      if (r == -1) cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
    } else {
      Defragment();
    }
  }
  return 0;
}
