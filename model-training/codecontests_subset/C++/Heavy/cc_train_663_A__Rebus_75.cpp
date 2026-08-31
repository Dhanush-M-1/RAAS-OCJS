#include <bits/stdc++.h>
using namespace std;
using ll = long long;
const int N = 1e6 + 1;
int n;
string s;
int main() {
  cin.tie(0)->sync_with_stdio(0);
  getline(cin, s);
  n = s.size();
  int plus = 1, neg = 0;
  vector<int> v = {1};
  int nn = 0;
  for (int i = 0; i < n; i++) {
    if (s[i] == '+') {
      plus++;
      v.push_back(1);
    }
    if (s[i] == '-') {
      neg++;
      v.push_back(-1);
    }
    if ('0' <= s[i] && s[i] <= '9') {
      nn = nn * 10 + s[i] - '0';
    }
  }
  n = nn;
  if (plus - n * neg > n || n > n * plus - neg) {
    cout << "Impossible";
    return 0;
  }
  cout << "Possible\n";
  int sum = 0;
  for (int i = 0; i < v.size(); i++) {
    if (v[i] == 1)
      plus--;
    else
      neg--;
    for (int c = 1; c <= n; c++) {
      if (sum + c * v[i] + plus - n * neg > n ||
          n > sum + c * v[i] + n * plus - neg) {
        continue;
      }
      if (i == v.size() - 1) {
        if (sum + c * v[i] != n) {
          continue;
        }
      }
      if (i) {
        if (v[i] == 1) {
          cout << " + ";
        } else {
          cout << " - ";
        }
      }
      cout << c;
      sum += c * v[i];
      break;
    }
  }
  cout << " = " << n;
}
