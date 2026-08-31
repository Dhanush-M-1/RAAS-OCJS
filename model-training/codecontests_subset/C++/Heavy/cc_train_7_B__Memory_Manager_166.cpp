#include <bits/stdc++.h>
using namespace std;
const int OO = (int)1e8;
const double PI = acos(-1.0);
const double EPS = (1e-7);
int dcmp(double x, double y) { return fabs(x - y) <= EPS ? 0 : x < y ? -1 : 1; }
int arr[1000];
int blockIdx[1000];
int n, m;
int blockId = 0;
void allocate(int t, int id = -1, bool print = true) {
  int i = 1;
  int idx = -1;
  while (i <= m) {
    int ci = i;
    int free = 0;
    while (free < t && i <= m) {
      if (arr[i] != -1) break;
      i++, free++;
    }
    if (free == t) {
      idx = ci;
      break;
    }
    i++;
  }
  if (idx == -1) {
    if (print) cout << "NULL\n";
  } else {
    if (id == -1) {
      blockId++;
      id = blockId;
    }
    blockIdx[id] = idx;
    for (int j = (0); j < (int)(t); ++j) arr[j + idx] = id;
    if (print) cout << id << "\n";
  }
}
void dis() {
  int i = 1;
  while (i <= m) {
    cout << arr[i++] << " ";
  }
  cout << "\n";
}
int main() {
  cin >> n >> m;
  memset(arr, -1, sizeof(arr));
  memset(blockIdx, -1, sizeof(blockIdx));
  string s;
  for (int tt = (0); tt < (int)(n); ++tt) {
    cin >> s;
    int t;
    if (s == "alloc") {
      cin >> t;
      allocate(t);
    } else if (s == "erase") {
      cin >> t;
      if (t >= 1 && t <= blockId && blockIdx[t] != -1) {
        int k = blockIdx[t];
        while (arr[k] == t) {
          arr[k] = -1;
          k++;
        }
        blockIdx[t] = -1;
      } else {
        cout << "ILLEGAL_ERASE_ARGUMENT\n";
      }
    } else {
      vector<pair<int, int> > v;
      int i = 1;
      while (i <= m) {
        int cur = arr[i];
        int f = 0;
        while (i <= m && arr[i] == cur) f++, i++;
        if (cur != -1) v.push_back(make_pair(f, cur));
      }
      memset(arr, -1, sizeof(arr));
      memset(blockIdx, -1, sizeof(blockIdx));
      for (int j = (0); j < (int)(((int)((v).size()))); ++j)
        allocate(v[j].first, v[j].second, false);
    }
  }
  return 0;
}
