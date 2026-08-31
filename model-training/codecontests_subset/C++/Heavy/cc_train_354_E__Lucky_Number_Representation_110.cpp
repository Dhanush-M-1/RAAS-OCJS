#include <bits/stdc++.h>
using namespace std;
const int N = 100010;
int inf = 1e9;
int mod = 1e9 + 7;
vector<int> pos[43];
void pre() {
  int p = 1;
  for (int i = 0; i < 6; i++) {
    p *= 3;
  }
  int bit[3] = {0, 4, 7};
  for (int i = 0; i < p; i++) {
    int temp = i, sum = 0;
    vector<int> A;
    for (int j = 0; j < 6; j++) {
      sum += bit[temp % 3];
      A.push_back(bit[temp % 3]);
      temp /= 3;
    }
    if (pos[sum].empty()) {
      pos[sum] = A;
    }
  }
  return;
}
signed main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  pre();
  int t;
  cin >> t;
  while (t--) {
    long long int n;
    cin >> n;
    vector<int> digits;
    while (n) {
      digits.push_back(n % 10);
      n /= 10;
    }
    bool check[19][10];
    memset(check, false, sizeof(check));
    int len = (int)digits.size();
    vector<int> stk;
    bool key = false;
    function<bool(int, int)> dfs = [&](int l, int carry) {
      if (l == len) {
        return !carry;
      }
      if (check[l][carry]) {
        return false;
      }
      check[l][carry] = true;
      for (int i = 0; i < 43; i++) {
        if (!pos[i].empty()) {
          int temp = carry + i;
          if (digits[l] == (temp % 10)) {
            stk.push_back(i);
            if (dfs(l + 1, temp / 10)) {
              return true;
            }
            stk.pop_back();
          }
        }
      }
      return false;
    };
    if (dfs(0, 0)) {
      vector<long long int> ans(6, 0LL);
      for (int i = (int)stk.size() - 1; i >= 0; i--) {
        for (int j = 0; j < 6; j++) {
          ans[j] *= 10;
          ans[j] += pos[stk[i]][j];
        }
      }
      for (int i = 0; i < 6; i++) {
        cout << ans[i] << " ";
      }
      cout << "\n";
      continue;
    }
    cout << "-1\n";
  }
  return 0;
}
