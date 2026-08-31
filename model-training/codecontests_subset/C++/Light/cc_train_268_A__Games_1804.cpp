#include <bits/stdc++.h>
using namespace std;
int main() {
  map<int, int> h;
  map<int, int> a;
  vector<int> uni;
  int teams;
  cin >> teams;
  int temph, tempa;
  for (int i = 0; i < teams; i++) {
    cin >> temph >> tempa;
    if (h.count(temph) > 0)
      h[temph]++;
    else {
      h[temph] = 1;
      uni.push_back(temph);
    }
    if (a.count(tempa) > 0)
      a[tempa]++;
    else
      a[tempa] = 1;
  }
  int resul = 0;
  for (int i = 0; i < uni.size(); i++) {
    resul += h[uni[i]] * a[uni[i]];
  }
  cout << resul;
  return 0;
}
