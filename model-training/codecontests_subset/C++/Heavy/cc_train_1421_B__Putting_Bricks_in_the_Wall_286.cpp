#include <bits/stdc++.h>
using namespace std;
void sol() {
  long long n;
  cin >> n;
  char a;
  long long flag1 = 0, flag2 = 0, flag3 = 0, flag4 = 0;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      cin >> a;
      if (i == 0 && j == 1) {
        if (a == '1') flag1++;
      }
      if (i == 1 && j == 0) {
        if (a == '1') flag2++;
      }
      if (i == n - 1 && j == n - 2) {
        if (a == '1') flag3++;
      }
      if (i == n - 2 && j == n - 1) {
        if (a == '1') flag4++;
      }
    }
  }
  vector<pair<long long, long long>> res;
  if (flag3 == flag4) {
    if (flag3 == flag1) {
      res.push_back(pair<long long, long long>(0, 1));
    }
    if (flag3 == flag2) {
      res.push_back(pair<long long, long long>(1, 0));
    }
    cout << res.size() << endl;
    {
      for (int i = 0; i < res.size(); i++) {
        cout << res[i].first + 1 << " " << res[i].second + 1 << endl;
      }
    }
    return;
  }
  if (flag1 == flag2) {
    if (flag3 == flag1) {
      res.push_back(pair<long long, long long>(n - 1, n - 2));
    }
    if (flag4 == flag1) {
      res.push_back(pair<long long, long long>(n - 2, n - 1));
    }
    cout << res.size() << endl;
    {
      for (int i = 0; i < res.size(); i++) {
        cout << res[i].first + 1 << " " << res[i].second + 1 << endl;
      }
    }
    return;
  }
  if (flag1 == 1) {
    res.push_back(pair<long long, long long>(0, 1));
  } else {
    res.push_back(pair<long long, long long>(1, 0));
  }
  if (flag3 == 1) {
    res.push_back(pair<long long, long long>(n - 2, n - 1));
  } else {
    res.push_back(pair<long long, long long>(n - 1, n - 2));
  }
  cout << res.size() << endl;
  {
    for (int i = 0; i < res.size(); i++) {
      cout << res[i].first + 1 << " " << res[i].second + 1 << endl;
    }
  }
}
int main() {
  long long n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    sol();
  }
}
