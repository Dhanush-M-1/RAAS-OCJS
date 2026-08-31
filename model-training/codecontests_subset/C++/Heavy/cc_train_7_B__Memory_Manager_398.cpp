#include <bits/stdc++.h>
using namespace std;
int get(int size, const bool* f, int fsize) {
  int streak = 0;
  for (int i = 0; i < fsize; i++) {
    if (!f[i]) {
      if (++streak == size) {
        return i - size + 1;
      }
    } else
      streak = 0;
  }
  return -1;
}
int main() {
  int t, m;
  cin >> t >> m;
  map<int, pair<int, int> > allocated;
  bool* f = new bool[m];
  for (int i = 0; i < m; i++) f[i] = false;
  int nextId = 1;
  while (t--) {
    string cmd;
    cin >> cmd;
    if (cmd[0] == 'a') {
      int size;
      cin >> size;
      int start = get(size, f, m);
      if (start < 0)
        cout << "NULL" << endl;
      else {
        cout << nextId << endl;
        allocated[nextId] = make_pair(start, start + size);
        for (int i = 0; i < size; i++) f[start + i] = true;
        nextId++;
      }
    } else if (cmd[0] == 'e') {
      int id;
      cin >> id;
      map<int, pair<int, int> >::iterator it = allocated.find(id);
      if (it == allocated.end())
        cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
      else {
        for (int i = it->second.first; i < it->second.second; i++) f[i] = false;
        allocated.erase(it);
      }
    } else {
      map<pair<int, int>, int> s;
      map<int, pair<int, int> >::iterator it = allocated.begin();
      while (it != allocated.end()) {
        s[it->second] = it->first;
        it++;
      }
      int loc = 0;
      allocated.clear();
      map<pair<int, int>, int>::iterator it1 = s.begin();
      while (it1 != s.end()) {
        int size = it1->first.second - it1->first.first;
        allocated[it1->second] = make_pair(loc, loc + size);
        for (int i = 0; i < size; i++) f[loc + i] = true;
        loc += size;
        it1++;
      }
      while (loc < m) f[loc++] = false;
    }
  }
  delete[] f;
  return 0;
}
