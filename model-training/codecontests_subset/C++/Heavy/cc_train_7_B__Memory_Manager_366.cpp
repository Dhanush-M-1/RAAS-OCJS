#include <bits/stdc++.h>
using namespace std;
int M;
vector<pair<pair<int, int>, int> > v;
bool alloc(int x, int id) {
  int i, j;
  for ((i) = 0; (i) < (int)M - x + 1; (i)++) {
    bool bad = false;
    for ((j) = 0; (j) < (int)v.size(); (j)++) {
      int a = v[j].first.first, b = v[j].first.second;
      if (a < i + x && b > i) bad = true;
    }
    if (!bad) {
      v.push_back(make_pair(make_pair(i, i + x), id));
      cout << id << endl;
      return true;
    }
  }
  cout << "NULL" << endl;
  return false;
}
bool erase2(int id) {
  int i;
  for ((i) = 0; (i) < (int)v.size(); (i)++)
    if (v[i].second == id) {
      v.erase(v.begin() + i);
      return true;
    }
  return false;
}
void defragment(void) {
  int i, sum = 0;
  sort(v.begin(), v.end());
  for ((i) = 0; (i) < (int)v.size(); (i)++) {
    int x = v[i].first.second - v[i].first.first;
    v[i].first.first = sum;
    v[i].first.second = sum + x;
    sum += x;
  }
}
int main() {
  int Q, x, i, id = 1;
  cin >> Q >> M;
  for ((i) = 0; (i) < (int)Q; (i)++) {
    string s;
    cin >> s;
    if (s == "alloc") {
      cin >> x;
      if (alloc(x, id)) id++;
    } else if (s == "erase") {
      cin >> x;
      if (!erase2(x)) cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
    } else {
      defragment();
    }
  }
  return 0;
}
