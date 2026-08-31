#include <bits/stdc++.h>
using namespace std;
int main() {
  string a;
  cin >> a;
  vector<int> v;
  for (int i = 0; i < a.length(); i++) {
    switch (a[i]) {
      case '1':
        v.push_back(1);
        break;
      case '2':
        v.push_back(2);
        break;
      case '3':
        v.push_back(3);
        break;
    }
  }
  sort(v.begin(), v.end());
  for (int i = 0; i < v.size() - 1; i++) cout << v[i] << "+";
  cout << v.back() << endl;
}
