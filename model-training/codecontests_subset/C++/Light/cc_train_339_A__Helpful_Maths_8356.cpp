#include <bits/stdc++.h>
using namespace std;
int main() {
  string a;
  cin >> a;
  vector<long long> y;
  for (long long i = 0; i < a.size(); i++) {
    if (a[i] != '+') y.push_back(a[i] - '0');
  }
  sort(y.begin(), y.end());
  for (long long i = 0; i < y.size() - 1; i++) cout << y[i] << "+";
  cout << y[y.size() - 1];
}
