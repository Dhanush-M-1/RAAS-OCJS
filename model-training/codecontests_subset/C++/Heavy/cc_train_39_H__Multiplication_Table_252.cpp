#include <bits/stdc++.h>
using namespace std;
vector<int> v;
int main() {
  int n, sz;
  cin >> n;
  for (int a = 1; a < n; a++) {
    while (a >= n) {
      v.push_back(a % n);
      a /= n;
    }
    v.push_back(a);
    for (int i = 1; i < 4 - v.size(); i++) cout << " ";
    for (int i = v.size() - 1; i >= 0; i--) {
      if (v[i] < 10)
        cout << v[i];
      else
        cout << char('A' + v[i] - 10);
    }
    sz = v.size() - 1;
    for (int i = sz; i >= 0; i--) {
      v.pop_back();
    }
  }
  cout << endl;
  int a;
  for (int a1 = 2; a1 < n; a1++) {
    for (int a2 = 1; a2 < n; a2++) {
      a = a1 * a2;
      while (a >= n) {
        v.push_back(a % n);
        a /= n;
      }
      v.push_back(a);
      for (int i = 0; i < 3 - v.size(); i++) cout << " ";
      for (int i = v.size() - 1; i >= 0; i--) {
        if (v[i] < 10)
          cout << v[i];
        else
          cout << char('A' + v[i] - 10);
      }
      sz = v.size() - 1;
      for (int i = sz; i >= 0; i--) {
        v.pop_back();
      }
    }
    cout << endl;
  }
  return 0;
}
