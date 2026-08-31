#include <bits/stdc++.h>
using namespace std;
int main() {
  int k;
  cin >> k;
  string f;
  cin >> f;
  map<char, int> car;
  for (auto ra : f) {
    car[ra]++;
  }
  string sal = "";
  for (auto w : car) {
    if (w.second % k != 0) {
      cout << -1 << endl;
      return 0;
    } else {
      for (int i = 0; i < w.second / k; i++) {
        sal += w.first;
      }
    }
  }
  string q = sal;
  for (int i = 0; i < k - 1; i++) {
    sal += q;
  }
  cout << sal << endl;
}
