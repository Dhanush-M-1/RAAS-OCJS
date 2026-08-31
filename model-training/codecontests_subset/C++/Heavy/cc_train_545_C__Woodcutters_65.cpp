#include <bits/stdc++.h>
using namespace std;
template <class T>
T scan() {
  T t;
  cin >> t;
  return t;
}
int dr[] = {0, -1, 1, 0, -1, 1, -1, 1};
int dc[] = {-1, 0, 0, 1, 1, -1, -1, 1};
int main() {
  int n;
  cin >> n;
  vector<pair<int, pair<int, int> > > arr;
  arr.resize(n);
  for (int i = 0; i < n; ++i) {
    int x, h;
    cin >> x >> h;
    arr[i] = make_pair(x, make_pair(x - h, x + h));
  }
  int cavab = 1;
  for (int i = 1; i < n; ++i) {
    if (arr[i].second.first > arr[i - 1].first) {
      ++cavab;
    } else if (i + 1 < n && arr[i].second.second < arr[i + 1].first) {
      ++cavab;
      arr[i].first = arr[i].second.second;
    } else if (i + 1 == n) {
      ++cavab;
    }
  }
  cout << cavab << endl;
  return 0;
}
