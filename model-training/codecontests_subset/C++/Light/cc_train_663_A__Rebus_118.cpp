#include <bits/stdc++.h>
using namespace std;
int main() {
  char c;
  int n;
  vector<int> v;
  char sign = '+';
  int sum = 0;
  while (1) {
    cin >> c;
    if (c == '+' or c == '-')
      sign = c;
    else if (c == '?') {
      if (sign == '+')
        v.push_back(1);
      else
        v.push_back(-1);
    }
    if (c == '=') break;
  }
  for (auto x : v) sum += x;
  cin >> n;
  vector<int> pos, neg;
  for (long long i = 0; i < v.size(); i++) {
    if (v[i] == 1)
      pos.push_back(i);
    else
      neg.push_back(i);
  }
  while (sum < n) {
    while (pos.size() > 0 and v[pos.back()] == n) pos.pop_back();
    if (pos.size() == 0) {
      cout << "Impossible";
      return 0;
    }
    v[pos.back()]++;
    sum++;
  }
  while (sum > n) {
    while (neg.size() > 0 and v[neg.back()] == -n) neg.pop_back();
    if (neg.size() == 0) {
      cout << "Impossible";
      return 0;
    }
    sum--;
    v[neg.back()]--;
  }
  cout << "Possible\n";
  for (long long i = 0; i < v.size(); i++) {
    if (i != 0) {
      if (v[i] > 0)
        cout << "+ ";
      else
        cout << "- ";
    }
    cout << abs(v[i]) << " ";
  }
  cout << "= " << n;
}
