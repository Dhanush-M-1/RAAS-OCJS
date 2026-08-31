#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  vector<pair<long long, long long> > v;
  for (int i = 0; i < n; i++) {
    long long a, b;
    cin >> a >> b;
    v.push_back(make_pair(a, b));
  }
  int counter = 0;
  for (int i = 0; i < n; i++) {
    if (i == 0 || i == n - 1)
      counter++;
    else {
      if (i - 1 >= 0 && (v[i].first - v[i].second) > v[i - 1].first)
        counter++;
      else if (i + 1 < n && (v[i].first + v[i].second) < v[i + 1].first) {
        counter++;
        v[i].first = v[i].first + v[i].second;
      }
    }
  }
  cout << counter << endl;
}
