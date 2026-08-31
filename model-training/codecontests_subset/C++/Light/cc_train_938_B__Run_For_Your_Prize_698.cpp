#include <bits/stdc++.h>
using namespace std;
long long int mod = 1e9 + 7;
long long int sum = 0, tmp3, tmp = 0, tmp2 = 0, comb = 0;
vector<long long int> ans, check, arr;
vector<vector<int>> g;
vector<pair<char, char>> sol;
long long int n, m;
string s;
int a = 0, b = 0, c = 0;
int main() {
  cin >> n;
  int x, maxi = 0;
  for (int i = 0; i < n; i++) {
    cin >> x;
    maxi = max(maxi, min(x - 1, 1000000 - x));
  }
  cout << maxi;
  return 0;
}
