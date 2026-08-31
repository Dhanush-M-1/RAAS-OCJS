#include <bits/stdc++.h>
using namespace std;
int mat[5201][5201];
int n;
vector<int> factors;
bool eval(int x) {
  for (int i = 0; i < (n / x); i++) {
    for (int j = 0; j < (n / x); j++) {
      int block_val;
      for (int k = 0; k < x; k++) {
        for (int l = 0; l < x; l++) {
          if (k == 0 && l == 0)
            block_val = mat[x * i + k][x * j + l];
          else {
            if (mat[x * i + k][x * j + l] != block_val) return false;
          }
        }
      }
    }
  }
  return true;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  cin >> n;
  int num;
  for (int i = 0; i < n; i++) {
    string s;
    cin >> s;
    for (int j = 0; j < s.length(); j++) {
      if (s[j] >= '0' && s[j] <= '9') {
        num = s[j] - '0';
        for (int k = 0; k < 4; k++) {
          if (num & (1 << (3 - k)))
            mat[i][4 * j + k] = 1;
          else
            mat[i][4 * j + k] = 0;
        }
      } else {
        num = s[j] - 'A';
        num += 10;
        for (int k = 0; k < 4; k++) {
          if (num & (1 << (3 - k)))
            mat[i][4 * j + k] = 1;
          else
            mat[i][4 * j + k] = 0;
        }
      }
    }
  }
  for (int i = 1; i <= n; i++) {
    if (n % i == 0) factors.push_back(i);
  }
  int start = 0, end = factors.size() - 1;
  int ans;
  for (int i = 0; i < factors.size(); i++) {
    bool var = eval(factors[i]);
    if (var == true) {
      ans = i;
    }
  }
  cout << factors[ans];
}
