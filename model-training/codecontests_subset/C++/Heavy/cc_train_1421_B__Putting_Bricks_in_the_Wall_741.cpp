#include <bits/stdc++.h>
using namespace std;
void solve() {
  int n;
  cin >> n;
  vector<vector<int> > v;
  char a[n][n];
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      cin >> a[i][j];
    }
  }
  int c = 0;
  int zeroc = 0;
  int onec = 0;
  if (a[0][1] == '0')
    zeroc++;
  else
    onec++;
  if (a[1][0] == '0')
    zeroc++;
  else
    onec++;
  if (a[n - 2][n - 1] == '0')
    zeroc++;
  else
    onec++;
  if (a[n - 1][n - 2] == '0')
    zeroc++;
  else
    onec++;
  if (zeroc == 0 || onec == 0) {
    cout << "2" << endl;
    cout << "1 2" << endl;
    cout << "2 1" << endl;
    return;
  }
  if (zeroc > onec) {
    if (a[0][1] != a[1][0]) {
      c++;
      if (a[0][1] == '0') {
        vector<int> temp;
        temp.push_back(1);
        temp.push_back(2);
        v.push_back(temp);
      } else {
        vector<int> temp;
        temp.push_back(2);
        temp.push_back(1);
        v.push_back(temp);
      }
    } else {
      c++;
      if (a[n - 1][n - 2] == '0') {
        vector<int> temp;
        temp.push_back(n);
        temp.push_back(n - 1);
        v.push_back(temp);
      } else {
        vector<int> temp;
        temp.push_back(n - 1);
        temp.push_back(n);
        v.push_back(temp);
      }
    }
  } else if (onec > zeroc) {
    if (a[0][1] != a[1][0]) {
      c++;
      if (a[0][1] == '1') {
        vector<int> temp;
        temp.push_back(1);
        temp.push_back(2);
        v.push_back(temp);
      } else {
        vector<int> temp;
        temp.push_back(2);
        temp.push_back(1);
        v.push_back(temp);
      }
    } else {
      c++;
      if (a[n - 1][n - 2] == '1') {
        vector<int> temp;
        temp.push_back(n);
        temp.push_back(n - 1);
        v.push_back(temp);
      } else {
        vector<int> temp;
        temp.push_back(n - 1);
        temp.push_back(n);
        v.push_back(temp);
      }
    }
  } else {
    if (a[0][1] != a[1][0]) {
      c++;
      if (a[0][1] == '0') {
        vector<int> temp;
        temp.push_back(2);
        temp.push_back(1);
        v.push_back(temp);
      } else {
        vector<int> temp;
        temp.push_back(1);
        temp.push_back(2);
        v.push_back(temp);
      }
    }
    if (a[n - 1][n - 2] != a[n - 2][n - 1]) {
      c++;
      if (a[n - 1][n - 2] == '1') {
        vector<int> temp;
        temp.push_back(n - 1);
        temp.push_back(n);
        v.push_back(temp);
      } else {
        vector<int> temp;
        temp.push_back(n);
        temp.push_back(n - 1);
        v.push_back(temp);
      }
    }
  }
  cout << c << endl;
  for (int i = 0; i < v.size(); i++) {
    cout << v[i][0] << " " << v[i][1] << endl;
  }
}
int main() {
  int t;
  cin >> t;
  while (t--) {
    solve();
  }
}
