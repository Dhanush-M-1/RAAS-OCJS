#include <bits/stdc++.h>
using namespace std;
const long long INF = 10000000000000;
const double long EPS = 1e-8;
int main() {
  cout.setf(ios::fixed);
  cout.precision(0);
  int n;
  cin >> n;
  vector<long long> kuda(n);
  vector<pair<long long, long long> > coor(n);
  for (int i = 0; i < n; ++i) {
    cin >> coor[i].first >> coor[i].second;
  }
  sort(coor.begin(), coor.end());
  long long amount = 2;
  if (n < 2) amount = n;
  kuda[0] = 0;
  for (int i = 1; i < n - 1; ++i) {
    if (kuda[i - 1] == 1) {
      if (coor[i].first - coor[i].second >
          coor[i - 1].first + coor[i - 1].second) {
        kuda[i] = 0;
        amount++;
      } else if (coor[i].first + coor[i].second < coor[i + 1].first) {
        kuda[i] = 1;
        amount++;
      } else
        kuda[i] = 0;
    } else {
      if (coor[i].first - coor[i].second > coor[i - 1].first) {
        kuda[i] = 0;
        amount++;
      } else if (coor[i].first + coor[i].second < coor[i + 1].first) {
        kuda[i] = 1;
        amount++;
      } else
        kuda[i] = 0;
    }
  }
  cout << amount << endl;
  return 0;
}
