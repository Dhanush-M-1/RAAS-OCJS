#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int n{0}, f{0}, s{0}, o{0}, flag{2}, t{0}, flag1{0};
  cin >> n;
  o = n;
  vector<long long int> vecf;
  vector<long long int> vecs;
  vector<long long int> veco;
  while (o--) {
    long long int c{0};
    cin >> c;
    veco.push_back(c);
  }
  sort(veco.begin(), veco.end());
  t = veco[n - 1];
  t = t + 1;
  while (f < n) {
    if (f < n - 1) {
      long long int a{0};
      cin >> a;
      vecf.push_back(a);
    } else
      vecf.push_back(t);
    f++;
  }
  while (s < n) {
    if (s < n - 2) {
      long long int b{0};
      cin >> b;
      vecs.push_back(b);
    } else
      vecs.push_back(t);
    s++;
  }
  sort(vecf.begin(), vecf.end());
  sort(vecs.begin(), vecs.end());
  for (long long int i{0}; i < n; i++) {
    for (long long int j{i}; j < n; j++) {
      if (veco[i] == vecf[j])
        break;
      else {
        cout << veco[i] << '\n';
        flag = 1;
        break;
      }
    }
    if (flag == 1) break;
  }
  for (long long int i{0}; i < n; i++) {
    for (long long int j{i}; j < n; j++) {
      if (vecf[i] == vecs[j]) {
        break;
      } else {
        cout << vecf[i] << '\n';
        flag1 = 1;
        break;
      }
    }
    if (flag1 == 1) break;
  }
  cout << '\n';
  return 0;
}
