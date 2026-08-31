#include <bits/stdc++.h>
using namespace std;
const int N = 100000 + 7;
const int M = 107;
const int mod = 998244353;
const int inf = 1e9 + 7;
const double pi = acos(-1);
const int maxn = N * 2;
const double PI = acos(-1);
int pl = 1, mn = 0;
int n;
string s;
vector<int> a;
bool canDo(int sum, int cnt) { return sum >= cnt && sum <= (long long)cnt * n; }
void solve() {
  a.push_back(1);
  while (cin >> s) {
    if (s[0] == '+') {
      pl++;
      a.push_back(1);
    }
    if (s[0] == '-') {
      mn++;
      a.push_back(-1);
    }
    if (s[0] >= '0' && s[0] <= '9') {
      n = s[0] - '0';
      for (int j = (1); j < (s.size()); j++) {
        n = n * 10 + s[j] - '0';
      }
    }
  }
  for (int sumPlus = 1; sumPlus <= n * 100; sumPlus++) {
    if (canDo(sumPlus, pl) && canDo(sumPlus - n, mn)) {
      int sumMinus = sumPlus - n;
      puts("Possible");
      for (int i = 0; i < a.size(); i++) {
        if (a[i] == 1) {
          if (i > 0) cout << " + ";
          if (pl == 1) {
            cout << sumPlus;
            continue;
          }
          int kq = 0;
          if (pl - 1 <= sumPlus - n) {
            kq = n;
          } else {
            kq = sumPlus - pl + 1;
          }
          cout << kq;
          sumPlus -= kq;
          pl--;
        } else {
          cout << " - ";
          if (mn == 1) {
            cout << sumMinus;
            continue;
          }
          int kq = 0;
          if (mn - 1 <= sumMinus - n) {
            kq = n;
          } else {
            kq = sumMinus - mn + 1;
          }
          sumMinus -= kq;
          cout << kq;
          mn--;
        }
      }
      cout << " = " << n;
      return;
    }
  }
  puts("Impossible");
}
int main() {
  int T = 1;
  for (int i = (1); i < (T + 1); i++) {
    solve();
  }
}
