#include <bits/stdc++.h>
using namespace std;
int main() {
  string pass;
  cin >> pass;
  long long n;
  cin >> n;
  vector<string> a;
  for (int i = 0; i < n; i++) {
    string j;
    cin >> j;
    j = j + j;
    a.push_back(j);
  }
  long long flag = 0;
  for (int i = 0; i < n; i++) {
    if (a[i].find(pass) != string::npos) {
      flag = 1;
      break;
    }
  }
  if (flag == 1) {
    cout << "YES";
    return 0;
  }
  long long one = 0, two = 0;
  for (int i = 0; i < n; i++) {
    if (a[i][0] == pass[1]) one = 1;
    if (a[i][1] == pass[0]) two = 1;
  }
  if (one == 1 && two == 1)
    cout << "YES";
  else
    cout << "NO";
}
