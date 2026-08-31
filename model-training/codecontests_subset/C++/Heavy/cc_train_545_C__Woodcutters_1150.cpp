#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(NULL);
  cout.tie(NULL);
  int a = 0;
  cin >> a;
  vector<pair<int, int>> x;
  int b, c;
  for (int i = 0; i < a; i++) {
    cin >> b >> c;
    x.push_back(make_pair(b, c));
  }
  if (a < 3)
    cout << a;
  else {
    int count = 2;
    int occ = x[0].first;
    for (int i = 1; i < a - 1; i++) {
      if ((x[i].first - x[i].second > occ)) {
        count++;
        occ = x[i].first;
      } else if (x[i].first + x[i].second < x[i + 1].first) {
        occ = x[i].first + x[i].second;
        count++;
      } else {
        occ = x[i].first;
      }
    }
    cout << count;
  }
  return 0;
}
