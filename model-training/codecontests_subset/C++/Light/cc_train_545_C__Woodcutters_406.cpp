#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  scanf("%d", &n);
  vector<pair<int, int> > v;
  for (int i = 0; i < n; i++) {
    int x, y;
    scanf("%d%d", &x, &y);
    v.push_back(make_pair(x, y));
  }
  int prev = v[0].first;
  int fell = 2;
  for (int i = 1; i < n - 1; i++) {
    if (prev < v[i].first - v[i].second) {
      fell++;
      prev = v[i].first;
    } else if (v[i + 1].first > v[i].first + v[i].second) {
      fell++;
      prev = v[i].first + v[i].second;
    } else {
      prev = v[i].first;
    }
  }
  if (n == 1)
    cout << "1";
  else
    cout << fell << endl;
}
