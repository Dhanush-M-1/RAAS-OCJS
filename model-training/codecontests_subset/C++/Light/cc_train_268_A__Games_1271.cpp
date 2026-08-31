#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  vector<int> home;
  vector<int> away;
  int h, a;
  for (int i = 0; i < n; i++) {
    cin >> h >> a;
    home.push_back(h);
    away.push_back(a);
  }
  int sum = 0;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++)
      if (home[i] == away[j]) sum++;
  }
  cout << sum << endl;
}
