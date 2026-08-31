#include <bits/stdc++.h>
using namespace std;
set<int> s, temp;
set<int>::iterator it;
vector<int> v[300011];
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  ;
  long long int i, n, m, a1, a2, c = 0, j, num;
  cin >> n >> m;
  long long int a[n + 1];
  for (i = 1; i <= n; i++) {
    cin >> a[i];
  }
  for (i = 0; i < m; i++) {
    cin >> a1 >> a2;
    v[a2].push_back(a1);
    if (a2 == a[n]) s.insert(a1);
  }
  j = n - 1;
  while (s.size() != 0 && j > 0) {
    if (s.find(a[j]) != s.end()) {
      s.erase(a[j]);
      c++;
      j--;
      continue;
    }
    temp = s;
    num = a[j];
    for (i = 0; i < v[num].size(); i++) {
      if (temp.find(v[num][i]) != temp.end()) temp.erase(v[num][i]);
    }
    for (it = temp.begin(); it != temp.end(); it++) {
      s.erase(*it);
    }
    j--;
  }
  cout << c;
}
